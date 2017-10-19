package com.tmobile.pr.mytmobile.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;
import com.tmobile.pr.mytmobile.home.view.HomeActivity;
import com.tmobile.tmoid.helperlib.sit.MsisdnData;
import com.tmobile.tmoid.helperlib.sit.SessionInstanceToken;
import com.tmobile.tmoid.sdk.AccessToken;
import com.tmobile.tmoid.sdk.Agent;
import com.tmobile.tmoid.sdk.AgentException;
import com.tmobile.tmoid.sdk.AgentService;
import com.tmobile.tmoid.sdk.ErrorListener;
import com.tmobile.tmoid.sdk.ImmutableNalOverride;
import com.tmobile.tmoid.sdk.NalOverride;
import com.tmobile.tmoid.sdk.PushType;
import com.tmobile.tmoid.sdk.impl.AgentImpl;
import com.tmobile.tmoid.sdk.impl.util.Prefs;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created by asaifudeen on 10/1/17.
 */

public class LoginActivity extends AppCompatActivity {

    private String TAG = "LoginActivity";
    private AccessToken accessToken;
    private String jsonPayload;
    private AgentException exception;
    private MsisdnData msisdnData;
    private String infoSdk;
    private String infoConnectionMode;
    private String transactionId;
    private SessionInstanceToken obtainedSitToken;
    private HashMap<String, String> oauthParameters;
    Handler handler;
    Prefs prefs;
    NalOverride nalOverride;
    private AgentService agentService;
    private AgentImpl agent;
    private String clientId;
    private String myTransId;
    private String LOG_TAG = "LoginTester";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefs = new Prefs(this);
        setup();
    }

    private void setup() {
        getAgentService();

        start();
        jsonPayload = "";
        exception = null;
        agentService.connectAgent(
                new AgentService.ConnectAgentCallback() {
                    @Override
                    public void onSuccess(Agent agent) {
                        LoginActivity.this.agent = (AgentImpl) agent;
                        Log.i(TAG, "Got Agent!");
                        agent.setNalOverride(nalOverride);
                        updateConnectionMode();
                        showLoginPage();
                    }
                }, new ErrorListener() {
                    @Override
                    public void onError(AgentException e) {
                        Log.e(LOG_TAG, "", e);
                        updateConnectionMode();
                    }
                }
        );

    }

    private void showLoginPage() {
        oauthParameters = Utils.convertJsonStringToHashMap(prefs.fetch(PrefKey.OAUTH_PARAMS_KEY, Utils.getPropertyFromAssets(LoginActivity.this, PrefKey.OAUTH_PARAMS_KEY)));
        agent.requestAccessToken(LoginActivity.this, null, oauthParameters, new Agent.TokenListener() {
            @Override
            public void onSuccess(AccessToken accessToken) {
                Toast.makeText(LoginActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        }, new ErrorListener() {
            @Override
            public void onError(AgentException e) {
                exception = e;

            }
        }, new Agent.RemListener() {
            @Override
            public void onReport(String s) {
                updateView();
            }
        });
    }

    private void getAgentService() {
        clientId = prefs.fetch(PrefKey.CLIENT_ID_KEY, Utils.getPropertyFromAssets(this, PrefKey.CLIENT_ID_KEY));
        myTransId = prefs.fetch(PrefKey.TRANSACTION_ID_KEY, UUID.randomUUID().toString());
        final PushType pushType = PushType.valueOf(prefs.fetch(PrefKey.PUSH_TYPE_KEY, PushType.PushNone.getValue()));

        Log.i(LOG_TAG, "getAgentService: " + clientId);
        Log.i(LOG_TAG, "getAgentService: " + myTransId);
        Log.i(LOG_TAG, "getAgentService: " + pushType);

        agentService = AgentService.getInstance(this, clientId, myTransId, pushType);

        nalOverride = ImmutableNalOverride.builder()
                .showKLMI(prefs.fetch(PrefKey.SHOW_KLMI, Utils.getPropertyFromAssets(this, PrefKey.SHOW_KLMI).equals("true") ? true : false))
                .showUserId(prefs.fetch(PrefKey.SHOW_USER_ID, Utils.getPropertyFromAssets(this, PrefKey.SHOW_USER_ID).equals("true") ? true : false))
                .editUserId(prefs.fetch(PrefKey.EDIT_USER_ID, Utils.getPropertyFromAssets(this, PrefKey.EDIT_USER_ID).equals("true") ? true : false))
                .showDefaultReturnHeaderImage(prefs.fetch(PrefKey.SHOW_DEFAULT_RETURN_HEADER_IMAGE, Utils.getPropertyFromAssets(this, PrefKey.SHOW_DEFAULT_RETURN_HEADER_IMAGE).equals("true") ? true : false))
                .showDefaultReturnHeaderText(prefs.fetch(PrefKey.SHOW_DEFAULT_RETURN_HEADER_TEXT, Utils.getPropertyFromAssets(this, PrefKey.SHOW_DEFAULT_RETURN_HEADER_TEXT).equals("true") ? true : false))
                .build();
    }


    private void updateView() {
        if (agent != null) {
            accessToken = agent.getAccessToken();
        }
    }

    void start() {
        exception = null;
        updateView();
    }

    private void updateConnectionMode() {
        infoConnectionMode = (agent != null ? agent.getConnectionMode() : "Not connected yet").toString();
    }
}