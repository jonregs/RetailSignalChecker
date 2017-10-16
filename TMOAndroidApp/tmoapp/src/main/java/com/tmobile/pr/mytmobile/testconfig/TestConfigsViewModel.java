package com.tmobile.pr.mytmobile.testconfig;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.util.HashMap;
import java.util.Set;

import io.reactivex.Observable;

import static android.content.Context.MODE_PRIVATE;
import static com.tmobile.pr.mytmobile.testconfig.TestConfigsDataModel.PROD;
import static com.tmobile.pr.mytmobile.testconfig.TestConfigsDataModel.SETTING_NAME;
import static com.tmobile.pr.mytmobile.testconfig.TestConfigsDataModel.URL1;
import static com.tmobile.pr.mytmobile.testconfig.TestConfigsDataModel.URL2;

/**
 * Created by ckompella on 10/9/17.
 */

public class TestConfigsViewModel {

    private static final String DBG_SETTIGS_SHARED_PREFS = "DBG_SETTIGS_SHARED_PREFS";
    private static final String TAG = "TestConfigsDataModel";
    private static final String PROD_URL1 = "PROD_URL1";
    private static final String PROD_URL2 = "PROD_URL2";

    private static HashMap<String,String> settingsMap = new HashMap<>();

    private TestConfigsDataModel configsDataModel = new TestConfigsDataModel();

    private static String DBG_ENV_NAME = "DBG_ENV_NAME";
    private static String DBG_SETTINGS = "DBG_SETTINGS";

    public Set<String> getConfigNames(){
        HashMap<String,HashMap<String,String>> map =  configsDataModel.getEnvironmentsObservable().blockingFirst();
        return map.keySet();
    }

    public Observable<HashMap<String, HashMap<String, String>>> getConfigSettings(){
        return configsDataModel.getEnvironmentsObservable();
    }

    public  String getCurrentEnvName(Context context) {

        String envName = context.getSharedPreferences(DBG_SETTIGS_SHARED_PREFS,MODE_PRIVATE).getString(DBG_ENV_NAME, PROD);
        Log.d(TAG, "getCurrentEnvName: "+ envName);
        return envName;
    }

    public void setCurrentEnvName(Context context, String envName) {

        if (!getConfigNames().contains(envName.toLowerCase())) {
            envName = PROD;
        }
        Log.d(TAG, "setCurrentEnvName: "+ envName);

        SharedPreferences prefs = context.getSharedPreferences(DBG_SETTIGS_SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(DBG_ENV_NAME,envName).apply();
        editor.commit();
    }

    public void saveCustomConfigData(Context context, String url1, String url2, String configName){

        SharedPreferences prefs = context.getSharedPreferences(DBG_SETTIGS_SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(URL1,url1).apply();
        editor.putString(URL2, url2).apply();
        editor.putString(SETTING_NAME, configName);
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