package com.tmobile.pr.mytmobile.login;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by jonegalado on 10/13/17, Gimmyo Project.
 */

public class Utils {

    private static final String SETTINGS_FILE = "settings.properties";

    public static String getPropertyFromAssets(Context context, String key) {
        try {
            Properties properties = new Properties();
            AssetManager assetManager = context.getAssets();
            properties.load(assetManager.open(SETTINGS_FILE));
            return properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static HashMap<String, String> convertJsonStringToHashMap(String oauthParamsString){
        Gson gson = new Gson();
        HashMap<String, String> map = new HashMap<String, String>();
        map = (HashMap<String, String>) gson.fromJson(oauthParamsString, map.getClass());

        return map;
    }
}