package com.tmobile.pr.mytmobile.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.tmobile.pr.mytmobile.model.DebugSettingsModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DebugSettingsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    private static final String TAG = "DebugSettingsActivity";
    private Spinner configSpinner;
    private Button btnLoadDefaults;
    private Button btnSave;

    private EditText editSetting1;
    private EditText editSetting2;
    private DebugSettingsModel debugSettingsModel = new DebugSettingsModel();

    private ArrayList<String> envList;
    private TextView configText;
    String[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setupUI();
    }

    private void setupUI() {
        configSpinner = findViewById(R.id.config_spinner);
        envList = debugSettingsModel.getEnvironments();
        items = envList.toArray(new String[envList.size()]);

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items);
        configSpinner.setAdapter(adapter);
        configSpinner.setOnItemSelectedListener(this);

        setTitle(R.string.title_configurator);

        btnLoadDefaults = findViewById(R.id.btn_load_defaults);
        btnLoadDefaults.setOnClickListener(this);

        btnSave = findViewById(R.id.btn_save);
        btnSave.setOnClickListener(this);

        editSetting1 = findViewById(R.id.edit_setting1);
        editSetting2 = findViewById(R.id.edit_setting2);

        configText = findViewById(R.id.config_text);

        String lastEnvName = debugSettingsModel.getCurrentEnvName(this);
        int index = getIndexFor(lastEnvName);

        populateFields(items[index]);
        debugSettingsModel.setCurrentEnvName(this, debugSettingsModel.PROD);
    }

    private int getIndexFor(String configName){
        for (int i = 0; i < items.length; i++) {
            if (items[i].equalsIgnoreCase(configName)) {
                //populateFields(lastEnvName);
                configSpinner.setSelection(i);
                return i;
            }
        }
        return 0;
    }


    private void saveCustomConfig(){
        String url1 = editSetting1.getText().toString();
        String url2 = editSetting2.getText().toString();

        HashMap<String,String> map = new HashMap<>();
        map.put(DebugSettingsModel.URL1, url1);
        map.put(DebugSettingsModel.URL2, url2);
        map.put(DebugSettingsModel.SETTING_NAME, DebugSettingsModel.CUSTOM);
        debugSettingsModel.saveCustomonfigData(DebugSettingsActivity.this,map);
        debugSettingsModel.setCurrentEnvName(DebugSettingsActivity.this, DebugSettingsModel.CUSTOM);
        configSpinner.setSelection(getIndexFor(DebugSettingsModel.CUSTOM));
    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        Log.d(TAG, "onItemSelected: " + position);
        String envName = envList.get(position);
        debugSettingsModel.setCurrentEnvName(this, envName);
        Toast.makeText(this, "Config name se to " + envName, Toast.LENGTH_SHORT).show();
        populateFields(envName);
    }

    private void populateFields(String configName) {
        Map<String, String> dataMap = debugSettingsModel.getSettngsForEnvironment(this,configName);
        if (dataMap != null) {
            if (dataMap.containsKey(DebugSettingsModel.URL1)) {
                String s = dataMap.get(DebugSettingsModel.URL1);
                editSetting1.setText(s);
            } else {
                Log.e(TAG, "populateFields: Didnt find setting for URL1");
            }

            if (dataMap.containsKey(DebugSettingsModel.URL2)) {
                String s = dataMap.get(DebugSettingsModel.URL2);
                editSetting2.setText(s);
            } else {
                Log.e(TAG, "populateFields: Didnt find setting for URL2");
            }

            if (dataMap.containsKey(DebugSettingsModel.SETTING_NAME)) {
                configText.setText("TEST CONfIG :  " +dataMap.get(DebugSettingsModel.SETTING_NAME).toUpperCase());
            }
        } else {
            Log.e(TAG, "populateFields: Didn't find settings for this environment " + configName);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_load_defaults) {
            populateFields(debugSettingsModel.getCurrentEnvName(this));
            debugSettingsModel.setCurrentEnvName(this, DebugSettingsModel.PROD);
        } else if (v.getId() == R.id.btn_save) {
            saveCustomConfig();
        }

    }
}