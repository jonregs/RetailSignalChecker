package com.tmobile.pr.mytmobile.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.tmobile.pr.mytmobile.AnalyticsModel;
import com.tmobile.pr.mytmobile.R;
import com.tmobile.pr.mytmobile.model.Model;
import com.tmobile.pr.mytmobile.ui.BaseActivity;
import com.tmobile.pr.mytmobile.ui.common.BaseInjectingFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import timber.log.Timber;

/**
 * Created by asaifudeen on 10/9/17.
 * Home Page with Hello World Card
 */

public class HomeFragment extends BaseInjectingFragment {
    private static final String TAG = "HomeFragment";

    private RecyclerView recyclerView;
    private HomeCardAdapter myAdapter;
    private RecyclerViewScrollListener scrollListener;
    private float computedValue;
    private float cardHeight;
    private float scrollY;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpCards();

    }

    private void setUpCards() {
        recyclerView = getFragmentView().findViewById(R.id.my_recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        scrollListener = new RecyclerViewScrollListener();

        List<Model> dataModel = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            dataModel.add(new Model(getString(R.string.hello), getString(R.string.welcome_text)));
        }

        myAdapter = new HomeCardAdapter(dataModel);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (recyclerView == null) {
            return;
        }
        recyclerView.addOnScrollListener(scrollListener);
    }

    @Override
    public void onResume() {
        super.onResume();
        //Todo: Change this to dynamic
        AnalyticsModel analyticsModel = new AnalyticsModel();
        analyticsModel.setPage_id("home_page");
        analyticsModel.setPage_name("Home");
        analyticsModel.setPage_uuid(UUID.randomUUID().toString());
        analyticsModel.setUi_element_type("page");
        Timber.d(analyticsModel.toString());
    }

    @Override
    public void onStop() {
        super.onStop();
        if (recyclerView == null) {
            return;
        }
        recyclerView.removeOnScrollListener(scrollListener);
    }

    private class RecyclerViewScrollListener extends RecyclerView.OnScrollListener {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);

        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            scrollY = recyclerView.computeVerticalScrollOffset();
            cardHeight = ((HomeCardAdapter) recyclerView.getAdapter()).getViewHeight();
            computedValue = ((Math.abs(scrollY) / Math.abs(cardHeight)) * (255));

            Log.i(TAG, "cardHeight: " + cardHeight);
            Log.i(TAG, "scrollY: " + scrollY);
            Log.i(TAG, "computedValue: " + (int) computedValue);

            if (scrollY <= cardHeight) {
                ((BaseActivity) getActivity()).getToolbar().setBackgroundOpacity((int) computedValue);
            } else if (scrollY > cardHeight) {
                computedValue = 255;
                ((BaseActivity) getActivity()).getToolbar().setBackgroundOpacity((int) computedValue);
            }

        }
    }

}
