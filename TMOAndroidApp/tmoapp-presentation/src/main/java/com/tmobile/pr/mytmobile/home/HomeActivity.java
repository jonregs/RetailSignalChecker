package com.tmobile.pr.mytmobile.home;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.tmobile.pr.mytmobile.R;
import com.tmobile.pr.mytmobile.ui.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by asaifudeen on 10/1/17.
 */

public class HomeActivity extends BaseActivity {

    private TabLayout tabLayout;
    private TabLayout.Tab tab;
    private TextView textFlipper;
    private View view;
    private View divider;
    private List<String> optionList = new ArrayList<>();
    private List<String> optionDestination = new ArrayList<>();
    private HashMap<String, String> footerHash = new HashMap<>();
    private Pair<String, String> option;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void onResume() {
        super.onResume();
        tabLayout = (TabLayout) findViewById(R.id.home_footer);

        optionList.add("My Account");
        optionList.add("My Bill");
        optionList.add("Shop");
        optionList.add("More");
        //optionList.add("0");

        optionDestination.add("WOO");
        optionDestination.add("WOO");
        optionDestination.add("WOO");
        optionDestination.add("WOO");
        //optionDestination.add("WOO");

        fillTabLayout(optionList, optionDestination);
    }


    /*
    Order is decided by how the options were passed.
    options list: list of options to be displayed

    TODO: destination: where each option will go (right now it is assuming a url) NEEDS CLARIFICATION

     */
    private void fillTabLayout(final List<String> options, List<String> destination) {
        for (int i = 0; i < optionList.size(); i++) {
            View v = LayoutInflater.from(this).inflate(R.layout.custom_footer_item_layout, null);
            textFlipper = (TextView) v.findViewById(R.id.txtCustomFooterText);
            textFlipper.setText(options.get(i));
            textFlipper.setScaleY(-1);
            v.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            tab = tabLayout.newTab().setCustomView(v).setTag(destination.get(i));
            textFlipper.setSingleLine();

            divider = (View) v.findViewById(R.id.divider);
            divider.setVisibility(i == 0 ? View.GONE : View.VISIBLE);

            tabLayout.addTab(tab);
        }

        tabLayout.setSelectedTabIndicatorColor(Color.TRANSPARENT);
        /*
        TODO: Implement the change of Page.
         */
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.magenta));
                tab.getCustomView().setBackgroundColor(getResources().getColor(R.color.grey));
                Toast.makeText(getApplicationContext(),options.get(tab.getPosition()),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getCustomView().setBackgroundColor(getResources().getColor(R.color.black));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.magenta));
                tab.getCustomView().setBackgroundColor(getResources().getColor(R.color.grey));
                Toast.makeText(getApplicationContext(),options.get(tab.getPosition()),Toast.LENGTH_SHORT).show();

            }
        });
    }

}
