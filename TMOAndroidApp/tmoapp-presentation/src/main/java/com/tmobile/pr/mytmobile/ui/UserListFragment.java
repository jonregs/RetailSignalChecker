/*
 *
 *  *
 *  *  * Copyright 2017 TMobile. All rights reserved.
 *  *  *
 *  *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  *  * you may not use this file except in compliance with the License.
 *  *  * You may obtain a copy of the License at
 *  *  *
 *  *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *  *
 *  *  * Unless required by applicable law or agreed to in writing, software
 *  *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *  * See the License for the specific language governing permissions and
 *  *  * limitations under the License.
 *  *
 *
 */

package com.tmobile.pr.mytmobile.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tmobile.pr.mytmobile.R;
import com.tmobile.pr.mytmobile.di.Injectable;
import com.tmobile.pr.mytmobile.model.UserModel;
import com.tmobile.pr.mytmobile.ui.common.BaseInjectingFragment;
import com.tmobile.pr.mytmobile.viewmodel.UserListViewModel;
import java.util.List;
import javax.inject.Inject;

public class UserListFragment extends BaseInjectingFragment implements Injectable {
    public static final String TAG = "UserListFragment";

    private UserListAdapter userListAdapter;
    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final UserListViewModel viewModel = ViewModelProviders.of(this,
                viewModelFactory).get(UserListViewModel.class);

        observeViewModel(viewModel);
    }

    /***
     * Observe the view model and replace the adapter data.
     * @param viewModel
     */
    private void observeViewModel(@NonNull UserListViewModel viewModel) {
        // Update the list when the data changes
        viewModel.getProjectListObservable().observe(this, new Observer<List<UserModel>>() {
            @Override
            public void onChanged(@Nullable List<UserModel> projects) {
                if (projects != null) {
                    userListAdapter.replace(projects);
                }
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user_list;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.project_list);
        userListAdapter = new UserListAdapter();
        recyclerView.setAdapter(userListAdapter);
        TabLayout tabLayout = view.findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("MY ACCOUNT"));
        tabLayout.addTab(tabLayout.newTab().setText("BILL"));
        tabLayout.addTab(tabLayout.newTab().setText("SHOP"));
        tabLayout.addTab(tabLayout.newTab().setText("MORE"));

    }
}
