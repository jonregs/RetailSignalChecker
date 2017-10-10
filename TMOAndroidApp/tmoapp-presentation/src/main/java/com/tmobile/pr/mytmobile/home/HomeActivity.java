package com.tmobile.pr.mytmobile.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.tmobile.pr.mytmobile.AnalyticsModel;
import com.tmobile.pr.mytmobile.R;
import com.tmobile.pr.mytmobile.message.MessageActivity;
import com.tmobile.pr.mytmobile.ui.BaseActivity;
import com.tmobile.pr.mytmobile.ui.common.BaseToolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import timber.log.Timber;

/**
 * Created by asaifudeen on 10/1/17.
 */

public class HomeActivity extends BaseActivity {

    private TabLayout tabLayout;
    private TabLayout.Tab tab;
    private TextView textFlipper;
    private View divider;
    private List<String> optionList = new ArrayList<>();
    private List<String> optionDestination = new ArrayList<>();
    private FragmentManager fragmentManager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected boolean setUpToolbar() {
        return true;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tabLayout =  findViewById(R.id.home_footer);
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

        //Change Icon color of toolbar
        toolbar.setToolbarIconColor(R.color.magenta);

        setUpToolbarListener();
        fragmentManager = getSupportFragmentManager();
        changeFragment(new HomeFragment());
    }


    /*
    Order is decided by how the options were passed.
    options list: list of options to be displayed

    TODO: destination: where each option will go (right now it is assuming a url) NEEDS CLARIFICATION

     */
    private void fillTabLayout(final List<String> options, List<String> destination) {
        for (int i = 0; i < optionList.size(); i++) {
            View v = LayoutInflater.from(this).inflate(R.layout.custom_footer_item_layout, null);
            textFlipper = v.findViewById(R.id.txtCustomFooterText);
            textFlipper.setText(options.get(i));
            textFlipper.setScaleY(-1);
            v.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            tab = tabLayout.newTab().setCustomView(v).setTag(destination.get(i));
            textFlipper.setSingleLine();

            divider = v.findViewById(R.id.divider);
            divider.setVisibility(i == 1 ? View.GONE : View.VISIBLE);

            tabLayout.addTab(tab);
        }
        ((ViewGroup) tabLayout.getChildAt(0)).getChildAt(0).setVisibility(View.GONE);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.magenta));

        /*
        TODO: Implement the change of Page.
         */
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.magenta));
                if (tab.getPosition() == 0) {
                    toolbar.setToolbarIconColor(R.color.magenta);
                    toolbar.getToolbarTitle().setText("");
                    changeFragment(new HomeFragment());

                } else {
                    toolbar.setToolbarIconColor(R.color.black);
                    toolbar.getToolbarTitle().setText(options.get(tab.getPosition()));
                    changeFragment(new Fragment());

                }
                tab.getCustomView().setBackgroundColor(getResources().getColor(R.color.grey));
                AnalyticsModel model = new AnalyticsModel();
                model.setFooter_id(getResources().getResourceEntryName(tabLayout.getId()));
                model.setUi_element_type("footer");
                Timber.d(model.toString());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getCustomView().setBackgroundColor(getResources().getColor(R.color.black));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
//                tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.magenta));
                tab.getCustomView().setBackgroundColor(getResources().getColor(R.color.grey));
//                Toast.makeText(getApplicationContext(),options.get(tab.getPosition()),Toast.LENGTH_SHORT).show();

            }
        });
    }


    private void setUpToolbarListener() {
        toolbar.setListener(new BaseToolbar.ToolbarClickListener() {
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
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("isHome", false)) {
            tabLayout.getTabAt(0).select();
        }
    }

    private void changeFragment(Fragment fragment) {
        if (fragmentManager != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        }
    }
}
