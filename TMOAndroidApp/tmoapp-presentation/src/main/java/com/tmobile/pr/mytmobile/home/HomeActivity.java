package com.tmobile.pr.mytmobile.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.tmobile.pr.mytmobile.AnalyticsModel;
import com.tmobile.pr.mytmobile.BuildConfig;
import com.tmobile.pr.mytmobile.R;
import com.tmobile.pr.mytmobile.message.MessageActivity;
import com.tmobile.pr.mytmobile.ui.BaseActivity;
import com.tmobile.pr.mytmobile.ui.DebugSettingsActivity;
import com.tmobile.pr.mytmobile.ui.common.BaseToolbar;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

/**
 * Created by asaifudeen on 10/1/17.
 * Home Activity with Toolbar and Footer configuration
 */

public class HomeActivity extends BaseActivity {
    private static final int HOME_DIVIDER_INDEX = 1;
    private TabLayout tabLayout;

    private List<String> optionList = new ArrayList<>();
    private List<String> optionDestination = new ArrayList<>();
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getToolbar().setToolbarIconColor(R.color.magenta);
        setUpToolbarListener();

        tabLayout = findViewById(R.id.home_footer);
        optionList.add("Home");
        optionList.add("My Account");
        optionList.add("My Bill");
        optionList.add("Shop");
        optionList.add("More");

        optionDestination.add("WOO");
        optionDestination.add("WOO");
        optionDestination.add("WOO");
        optionDestination.add("WOO");
        optionDestination.add("WOO");

        fillTabLayout(optionList, optionDestination);

        fragmentManager = getSupportFragmentManager();
        changeFragment(new HomeFragment());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected boolean setUpToolbar() {
        return true;
    }

    private void setUpToolbarListener() {
        getToolbar().setListener(new BaseToolbar.ToolbarClickListener() {
            @Override
            public void onHomeIconClick() {
                Toast.makeText(getApplicationContext(), R.string.home_navigate, Toast.LENGTH_SHORT).show();
                tabLayout.getTabAt(0).select();
            }

            @Override
            public void onMessageIconClick() {
                Intent intent = new Intent(getApplicationContext(), MessageActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (BuildConfig.DEBUG) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.options_menu, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.diagnostics:
                startActivity(new Intent(this, DebugSettingsActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    /*
    * Order is decided by how the options were passed.
    * options list: list of options to be displayed
    * TODO: destination: where each option will go (right now it is assuming a url) NEEDS CLARIFICATION
    */
    private void fillTabLayout(final List<String> options, List<String> destination) {
        TabLayout.Tab tab;
        TextView textFlipper;
        View divider;
        for (int i = 0; i < optionList.size(); i++) {
            View v = LayoutInflater.from(this).inflate(R.layout.custom_footer_item_layout, null);
            textFlipper = v.findViewById(R.id.txtCustomFooterText);
            textFlipper.setText(options.get(i));
            textFlipper.setScaleY(-1);
            v.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            tab = tabLayout.newTab().setCustomView(v).setTag(destination.get(i));
            textFlipper.setSingleLine();

            divider = v.findViewById(R.id.divider);
            divider.setVisibility(i == HOME_DIVIDER_INDEX ? View.GONE : View.VISIBLE);

            tabLayout.addTab(tab);
        }

        ((ViewGroup) tabLayout.getChildAt(0)).getChildAt(0).setVisibility(View.GONE);
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.magenta));

        /*
        *TODO: Implement the change of Page.
        */
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    getToolbar().setToolbarIconColor(R.color.magenta);
                    getToolbar().getToolbarTitle().setText("");
                    changeFragment(new HomeFragment());
                } else {
                    getToolbar().setToolbarIconColor(R.color.black);
                    getToolbar().getToolbarTitle().setText(options.get(tab.getPosition()));
                    changeFragment(new Fragment());
                }
                if (tab.getCustomView() != null) {
                    tab.getCustomView().setBackgroundColor(ContextCompat.getColor(HomeActivity.this, R.color.grey));
                }
                AnalyticsModel model = new AnalyticsModel();
                model.setFooter_id(getResources().getResourceEntryName(tabLayout.getId()));
                model.setUi_element_type("footer");
                Timber.d(model.toString());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab.getCustomView() != null) {
                    tab.getCustomView().setBackgroundColor(ContextCompat.getColor(HomeActivity.this, R.color.black));
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                if (tab.getCustomView() != null) {
                    tab.getCustomView().setBackgroundColor(ContextCompat.getColor(HomeActivity.this, R.color.grey));
                }
            }
        });
    }

    private void changeFragment(Fragment fragment) {
        if (fragmentManager != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("isHome", false)) {
            tabLayout.getTabAt(0).select();
        }
    }
}
