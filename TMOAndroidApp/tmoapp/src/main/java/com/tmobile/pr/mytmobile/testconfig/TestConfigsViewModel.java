package com.tmobile.pr.mytmobile.testconfig;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

import static android.content.Context.MODE_PRIVATE;
import static com.tmobile.pr.mytmobile.testconfig.TestConfigsDataModel.CUSTOM;
import static com.tmobile.pr.mytmobile.testconfig.TestConfigsDataModel.PROD;
import static com.tmobile.pr.mytmobile.testconfig.TestConfigsDataModel.SETTING_NAME;
import static com.tmobile.pr.mytmobile.testconfig.TestConfigsDataModel.URL1;
import static com.tmobile.pr.mytmobile.testconfig.TestConfigsDataModel.URL2;

public class TestConfigsViewModel {

    private static final String DBG_SETTIGS_SHARED_PREFS = "DBG_SETTIGS_SHARED_PREFS";
    private static final String TAG = "TestConfigsDataModel";
    private static final String PROD_URL1 = "PROD_URL1";
    private static final String PROD_URL2 = "PROD_URL2";

    private static HashMap<String,String> settingsMap = new HashMap<>();

    private TestConfigsDataModel configsDataModel = new TestConfigsDataModel();

    private static String DBG_ENV_NAME = "DBG_ENV_NAME";

    public Single<HashMap<String, HashMap<String, String>>> getTestConfigs(final Context context){

        HashMap<String, HashMap<String, String>> map = configsDataModel.getEnvironments();
        map.put(CUSTOM,getCustomConfigMap(context));

        return Single.just(map);
    }

    public  String getLastUsedConfigName(Context context) {

        String envName = context.getSharedPreferences(DBG_SETTIGS_SHARED_PREFS,MODE_PRIVATE)
                .getString(DBG_ENV_NAME, PROD);
        Log.d(TAG, "getLastUsedConfigName: "+ envName);
        return envName;
    }

    public void setLastUsedConfigName(Context context, String envName) {

        Log.d(TAG, "setLastUsedConfigName: "+ envName);

        SharedPreferences prefs = context.getSharedPreferences(DBG_SETTIGS_SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(DBG_ENV_NAME,envName).apply();
        editor.commit();
    }

    public void saveCustomConfigData(Context context, Map<String,String> data){

        SharedPreferences prefs = context.getSharedPreferences(DBG_SETTIGS_SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(URL1,data.get(URL1));
        editor.putString(URL2, data.get(URL2));
        editor.putString(SETTING_NAME, data.get(SETTING_NAME));
        editor.commit();
    }

    public HashMap<String,String> getCustomConfigMap(Context context){

        HashMap<String,String> map = new HashMap<>();

        String url1 = context.getSharedPreferences(DBG_SETTIGS_SHARED_PREFS,MODE_PRIVATE).getString(URL1, PROD_URL1);
        String url2 = context.getSharedPreferences(DBG_SETTIGS_SHARED_PREFS,MODE_PRIVATE).getString(URL2, PROD_URL2);
        String name = context.getSharedPreferences(DBG_SETTIGS_SHARED_PREFS,MODE_PRIVATE).getString(SETTING_NAME, PROD);

        map.put(URL1, url1);
        map.put(URL2, url2);
        map.put(SETTING_NAME, name);

        return map;
    }
}