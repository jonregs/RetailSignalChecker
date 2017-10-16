package com.tmobile.pr.mytmobile.testconfig;

import java.util.HashMap;
import io.reactivex.Observable;

public class TestConfigsDataModel {

    public static final String PREPROD = "preprod";
    public static final String PROD = "prod";
    public static final String MOCK = "mock";
    public static final String QA = "qa";
    public static final String CUSTOM = "custom";

    public static final String URL1 = "url1";
    public static final String URL2 = "url2";
    public static final String SETTING_NAME = "setting_name";

    private static final String QA_URL1 = "QA Url1";
    private static final String QA_URL2 = "QA Url2";

    private static final String MOCK_URL1 = "MOCK Url1";
    private static final String MOCK_URL2 = "MOCK Url2";

    private static final String PREPROD_URL1 = "PREPROD Url1";
    private static final String PREPROD_URL2 = "PREPROD Url2";
    private static final String PROD_URL1 = "Prod Url1";
    private static final String PROD_URL2 = "Prod Url2";

    private HashMap<String,HashMap<String,String>> envMap = null;

    public Observable<HashMap<String, HashMap<String, String>>> getEnvironmentsObservable(){

        if (envMap == null) {
            envMap = new HashMap<>();

            HashMap<String, String> prodMap = new HashMap<>();
            prodMap.put(URL1, PROD_URL1);
            prodMap.put(URL2, PROD_URL2);
            prodMap.put(SETTING_NAME, PROD);

            HashMap<String, String> preprodMap = new HashMap<>();
            preprodMap.put(URL1, PREPROD_URL1);
            preprodMap.put(URL2, PREPROD_URL2);
            preprodMap.put(SETTING_NAME, PREPROD);

            HashMap<String, String> mockMap = new HashMap<>();
            mockMap.put(URL1, MOCK_URL1);
            mockMap.put(URL2, MOCK_URL2);
            mockMap.put(SETTING_NAME, MOCK);

            HashMap<String, String> qaMap = new HashMap<>();
            qaMap.put(URL1, QA_URL1);
            qaMap.put(URL2, QA_URL2);
            qaMap.put(SETTING_NAME, QA);

            envMap.put(PROD, prodMap);
            envMap.put(PREPROD, preprodMap);
            envMap.put(MOCK, mockMap);
            envMap.put(QA, qaMap);
        }

        return io.reactivex.Observable.just(envMap);
    }
}