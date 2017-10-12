package com.tmobile.pr.mytmobile.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by ckompella on 10/9/17.
 */

public class DebugSettingsModel {

    public static final String PREPROD = "preprod";
    public static final String PROD = "prod";
    public static final String MOCK = "mock";
    public static final String QA = "qa";
    public static final String CUSTOM = "custom";

    public static final String URL1 = "url1";
    public static final String URL2 = "url2";
    public static final String SETTING_NAME = "setting_name";
    private static final String DBG_SETTIGS_SHARED_PREFS = "DBG_SETTIGS_SHARED_PREFS";
    private static final String TAG = "DebugSettingsModel";

    private static final String QA_URL1 = "QA Url1";
    private static final String QA_URL2 = "QA Url2";

    private static final String MOCK_URL1 = "MOCK Url1";
    private static final String MOCK_URL2 = "MOCK Url2";

    private static final String PREPROD_URL1 = "PREPROD Url1";
    private static final String PREPROD_URL2 = "PREPROD Url2";
    private static final String PROD_URL1 = "Prod Url1";
    private static final String PROD_URL2 = "Prod Url2";

//    private static final String FLAG = "flag";

    private static HashMap<String,String> settingsMap = new HashMap<>();
    //private static String currentEnvName = PROD;

    private static String DBG_ENV_NAME = "DBG_ENV_NAME";
    private static String DBG_SETTINGS = "DBG_SETTINGS";

    public  ArrayList<String> getEnvironments() {

        String[] items = new String[]{PROD, PREPROD,MOCK,QA,CUSTOM };
        ArrayList<String> list = new ArrayList<>();
        for(String s: items) {
            list.add(s);
        }

        return list;
    }

    public  Map<String, String> getSettngsForEnvironment(Context context, String environmentName) {
//        if (environmentName.equalsIgnoreCase(CUSTOM)) {
//            return settingsMap;
//        }

        settingsMap.clear();
        Log.d(TAG, "getSettngsForEnvironment: getting Settings for " + environmentName);

        switch (environmentName) {
            case QA:
                settingsMap.put(URL1, QA_URL1);
                settingsMap.put(URL2, QA_URL2);
                //settingsMap.put(FLAG, true);
                settingsMap.put(SETTING_NAME, QA);
                break;

            case PREPROD:
                settingsMap.put(URL1, PREPROD_URL1);
                settingsMap.put(URL2, PREPROD_URL2);
              //  settingsMap.put(FLAG, true);
                settingsMap.put(SETTING_NAME, PREPROD);
                break;

            case MOCK:
                settingsMap.put(URL1, MOCK_URL1);
                settingsMap.put(URL2, MOCK_URL2);
             //   settingsMap.put(FLAG, true);
                settingsMap.put(SETTING_NAME, MOCK);
                break;

            case CUSTOM:
                settingsMap = getCustomConfigMap(context);
                break;

            case PROD:
            default:
                settingsMap.put(URL1, PROD_URL1);
                settingsMap.put(URL2, PROD_URL2);
              //  settingsMap.put(FLAG, true);
                settingsMap.put(SETTING_NAME, PROD);
                break;
        }
        return settingsMap;
    }

    public  String getCurrentEnvName(Context context) {

        String envName = context.getSharedPreferences(DBG_SETTIGS_SHARED_PREFS,MODE_PRIVATE).getString(DBG_ENV_NAME, PROD);
        Log.d(TAG, "getCurrentEnvName: "+ envName);
        return envName;
    }

    public void setCurrentEnvName(Context context, String envName) {

        if (!getEnvironments().contains(envName.toLowerCase())) {
            envName = PROD;
        }
        Log.d(TAG, "setCurrentEnvName: "+ envName);

        SharedPreferences prefs = context.getSharedPreferences(DBG_SETTIGS_SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(DBG_ENV_NAME,envName).apply();
        editor.commit();
    }

    public void saveCustomonfigData(Context context, Map<String,String> configMap) {
        //always when we save the config name becomes CUSTOM
        SharedPreferences prefs = context.getSharedPreferences(DBG_SETTIGS_SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(URL1,configMap.get(URL1)).apply();
        editor.putString(URL2, configMap.get(URL2)).apply();
        editor.putString(SETTING_NAME, configMap.get(SETTING_NAME));
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