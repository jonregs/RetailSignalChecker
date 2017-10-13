package com.tmobile.pr.mytmobile.di;

import android.support.v4.app.Fragment;
import com.tmobile.pr.mytmobile.ui.UserListFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents =
      FragmentBuildersModule_ContributeProjectListFragment.UserListFragmentSubcomponent.class
)
public abstract class FragmentBuildersModule_ContributeProjectListFragment {
  private FragmentBuildersModule_ContributeProjectListFragment() {}

  @Binds
  @IntoMap
  @FragmentKey(UserListFragment.class)
  abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(
      UserListFragmentSubcomponent.Builder builder);

  @Subcomponent
  public interface UserListFragmentSubcomponent extends AndroidInjector<UserListFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<UserListFragment> {}
  }
}
