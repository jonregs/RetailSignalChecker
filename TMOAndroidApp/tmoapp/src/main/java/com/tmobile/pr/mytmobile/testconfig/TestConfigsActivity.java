package com.tmobile.pr.mytmobile.testconfig;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.tmobile.pr.mytmobile.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import io.reactivex.Flowable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.tmobile.pr.mytmobile.testconfig.TestConfigsDataModel.CUSTOM;
import static com.tmobile.pr.mytmobile.testconfig.TestConfigsDataModel.SETTING_NAME;
import static com.tmobile.pr.mytmobile.testconfig.TestConfigsDataModel.URL1;
import static com.tmobile.pr.mytmobile.testconfig.TestConfigsDataModel.URL2;

public class TestConfigsActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private static final String TAG = "TestConfigsActivity";
    private Spinner configSpinner;
    private Button btnLoadDefaults;
    private Button btnSave;

    private EditText editSetting1;
    private EditText editSetting2;
    private TestConfigsViewModel testConfigsViewModel= new TestConfigsViewModel();

    private TextView configText;
    String[] items;
    private HashMap<String, HashMap<String, String>> allConfigsMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setupViews();
    }

    private void setupViews() {
        configSpinner = findViewById(R.id.config_spinner);
        btnLoadDefaults = findViewById(R.id.btn_load_defaults);
        btnLoadDefaults.setOnClickListener(this);

        btnSave = findViewById(R.id.btn_save);
        btnSave.setOnClickListener(this);

        editSetting1 = findViewById(R.id.edit_setting1);
        editSetting2 = findViewById(R.id.edit_setting2);

        configText = findViewById(R.id.config_text);
        setTitle(R.string.title_configurator);

        //get last Used Config name
        final String lastUsedConfig = testConfigsViewModel.getLastUsedConfigName(this);

        //get configs from DataModel
        testConfigsViewModel.getTestConfigs(this)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<HashMap<String, HashMap<String, String>>>() {
            @Override
            public void onSubscribe(Disposable d) { }

            @Override
            public void onSuccess(HashMap<String, HashMap<String, String>> configMap) {
                allConfigsMap = configMap;

                Set<String> set = configMap.keySet();
                items =   set.toArray(new String[set.size()]);

                ArrayAdapter<String> adapter = new ArrayAdapter(TestConfigsActivity.this,
                        android.R.layout.simple_spinner_dropdown_item, items);
                configSpinner.setAdapter(adapter);
                configSpinner.setOnItemSelectedListener(TestConfigsActivity.this);

                int lastConfigIndex = getIndexFor(lastUsedConfig);

                populateFields(lastUsedConfig);
                configSpinner.setSelection(lastConfigIndex);
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(TestConfigsActivity.this, "Could not load config data",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private int getIndexFor(String configName){
        for (int i = 0; i < items.length; i++) {
            if (items[i].equalsIgnoreCase(configName)) {
                return i;
            }
        }
        return 0;
    }

    private void saveCustomConfig(){
        String url1 = editSetting1.getText().toString();
        String url2 = editSetting2.getText().toString();
        configSpinner.setSelection(getIndexFor(TestConfigsDataModel.CUSTOM));

        HashMap<String,String> map = new HashMap<>();
        map.put(URL1, url1);
        map.put(URL2, url2);
        map.put(SETTING_NAME, TestConfigsDataModel.CUSTOM);

        testConfigsViewModel.saveCustomConfigData(this,map);
    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        if (allConfigsMap == null || allConfigsMap.size() < position) {
            return;
        }

        Log.d(TAG, "onItemSelected: " + position);
        String envName = items[position];
        testConfigsViewModel.setLastUsedConfigName(this, envName);
        Toast.makeText(this, "Config name se to " + envName, Toast.LENGTH_SHORT).show();
        populateFields(envName);
    }

    private void populateFields(String configName){
        HashMap<String,String> currentConfigMap = allConfigsMap.get(configName);

        editSetting1.setText(currentConfigMap.get(URL1));
        editSetting2.setText(currentConfigMap.get(URL2));
        configText.setText("CURRENT CONfIG:  " +currentConfigMap.get(TestConfigsDataModel.SETTING_NAME).toUpperCase());

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_load_defaults) {
            int index = getIndexFor(TestConfigsDataModel.PROD);
            configSpinner.setSelection(index);
            HashMap<String,String> currentConfigMap = allConfigsMap.get(items[index]);

            editSetting1.setText(currentConfigMap.get(URL1));
            editSetting2.setText(currentConfigMap.get(URL2));
            configText.setText("TEST CONfIG :  " +currentConfigMap.get(TestConfigsDataModel.SETTING_NAME).toUpperCase());
        } else if (v.getId() == R.id.btn_save) {
            saveCustomConfig();
        }
    }
}
