package com.tmobile.pr.mytmobile.di;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;
import android.support.v4.app.Fragment;
import com.tmobile.pr.mytmobile.TMobileApplication;
import com.tmobile.pr.mytmobile.TMobileApplication_MembersInjector;
import com.tmobile.pr.mytmobile.UIThread;
import com.tmobile.pr.mytmobile.UIThread_Factory;
import com.tmobile.pr.mytmobile.data.entity.mapper.UserEntityDataMapper;
import com.tmobile.pr.mytmobile.data.entity.mapper.UserEntityDataMapper_Factory;
import com.tmobile.pr.mytmobile.data.executor.JobExecutor;
import com.tmobile.pr.mytmobile.data.executor.JobExecutor_Factory;
import com.tmobile.pr.mytmobile.data.repository.UserDataRepository;
import com.tmobile.pr.mytmobile.data.repository.UserDataRepository_Factory;
import com.tmobile.pr.mytmobile.data.repository.datasource.UserDataStoreFactory;
import com.tmobile.pr.mytmobile.data.repository.datasource.UserDataStoreFactory_Factory;
import com.tmobile.pr.mytmobile.domain.executor.PostExecutionThread;
import com.tmobile.pr.mytmobile.domain.executor.ThreadExecutor;
import com.tmobile.pr.mytmobile.domain.interactor.browse.GetUserList;
import com.tmobile.pr.mytmobile.domain.interactor.browse.GetUserList_Factory;
import com.tmobile.pr.mytmobile.domain.repository.UserRepository;
import com.tmobile.pr.mytmobile.mapper.UserModelDataMapper_Factory;
import com.tmobile.pr.mytmobile.ui.MainActivity;
import com.tmobile.pr.mytmobile.ui.MainActivity_MembersInjector;
import com.tmobile.pr.mytmobile.ui.UserListFragment;
import com.tmobile.pr.mytmobile.ui.UserListFragment_MembersInjector;
import com.tmobile.pr.mytmobile.viewmodel.UserListViewModel;
import com.tmobile.pr.mytmobile.viewmodel.UserListViewModel_Factory;
import dagger.MembersInjector;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.DispatchingAndroidInjector_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.MapProviderFactory;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import java.util.Map;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerAppComponent implements AppComponent {
  private Provider<MainActivityModule_ContributeMainActivity.MainActivitySubcomponent.Builder>
      mainActivitySubcomponentBuilderProvider;

  private Provider<AndroidInjector.Factory<? extends Activity>> bindAndroidInjectorFactoryProvider;

  private Provider<
          Map<Class<? extends Activity>, Provider<AndroidInjector.Factory<? extends Activity>>>>
      mapOfClassOfAndProviderOfFactoryOfProvider;

  private Provider<DispatchingAndroidInjector<Activity>> dispatchingAndroidInjectorProvider;

  private MembersInjector<TMobileApplication> tMobileApplicationMembersInjector;

  private Provider<ViewModelSubComponent.Builder> viewModelSubComponentBuilderProvider;

  private Provider<ViewModelProvider.Factory> provideViewModelFactoryProvider;

  private Provider<Application> applicationProvider;

  private Provider<UserDataStoreFactory> userDataStoreFactoryProvider;

  private Provider<UserEntityDataMapper> userEntityDataMapperProvider;

  private Provider<UserDataRepository> userDataRepositoryProvider;

  private Provider<UserRepository> provideUserRepositoryProvider;

  private Provider<JobExecutor> jobExecutorProvider;

  private Provider<ThreadExecutor> provideThreadExecutorProvider;

  private Provider<UIThread> uIThreadProvider;

  private Provider<PostExecutionThread> providePostExecutionThreadProvider;

  private DaggerAppComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static AppComponent.Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.mainActivitySubcomponentBuilderProvider =
        new dagger.internal.Factory<
            MainActivityModule_ContributeMainActivity.MainActivitySubcomponent.Builder>() {
          @Override
          public MainActivityModule_ContributeMainActivity.MainActivitySubcomponent.Builder get() {
            return new MainActivitySubcomponentBuilder();
          }
        };

    this.bindAndroidInjectorFactoryProvider = (Provider) mainActivitySubcomponentBuilderProvider;

    this.mapOfClassOfAndProviderOfFactoryOfProvider =
        MapProviderFactory
            .<Class<? extends Activity>, AndroidInjector.Factory<? extends Activity>>builder(1)
            .put(MainActivity.class, bindAndroidInjectorFactoryProvider)
            .build();

    this.dispatchingAndroidInjectorProvider =
        DispatchingAndroidInjector_Factory.create(mapOfClassOfAndProviderOfFactoryOfProvider);

    this.tMobileApplicationMembersInjector =
        TMobileApplication_MembersInjector.create(dispatchingAndroidInjectorProvider);

    this.viewModelSubComponentBuilderProvider =
        new dagger.internal.Factory<ViewModelSubComponent.Builder>() {
          @Override
          public ViewModelSubComponent.Builder get() {
            return new ViewModelSubComponentBuilder();
          }
        };

    this.provideViewModelFactoryProvider =
        DoubleCheck.provider(
            AppModule_ProvideViewModelFactoryFactory.create(
                builder.appModule, viewModelSubComponentBuilderProvider));

    this.applicationProvider = InstanceFactory.create(builder.application);

    this.userDataStoreFactoryProvider = DoubleCheck.provider(UserDataStoreFactory_Factory.create());

    this.userEntityDataMapperProvider = DoubleCheck.provider(UserEntityDataMapper_Factory.create());

    this.userDataRepositoryProvider =
        DoubleCheck.provider(
            UserDataRepository_Factory.create(
                userDataStoreFactoryProvider, userEntityDataMapperProvider));

    this.provideUserRepositoryProvider =
        DoubleCheck.provider(
            AppModule_ProvideUserRepositoryFactory.create(
                builder.appModule, userDataRepositoryProvider));

    this.jobExecutorProvider = DoubleCheck.provider(JobExecutor_Factory.create());

    this.provideThreadExecutorProvider =
        DoubleCheck.provider(
            AppModule_ProvideThreadExecutorFactory.create(builder.appModule, jobExecutorProvider));

    this.uIThreadProvider = DoubleCheck.provider(UIThread_Factory.create());

    this.providePostExecutionThreadProvider =
        DoubleCheck.provider(
            AppModule_ProvidePostExecutionThreadFactory.create(
                builder.appModule, uIThreadProvider));
  }

  @Override
  public void inject(TMobileApplication tMobileApplication) {
    tMobileApplicationMembersInjector.injectMembers(tMobileApplication);
  }

  private static final class Builder implements AppComponent.Builder {
    private AppModule appModule;

    private Application application;

    @Override
    public AppComponent build() {
      if (appModule == null) {
        this.appModule = new AppModule();
      }
      if (application == null) {
        throw new IllegalStateException(Application.class.getCanonicalName() + " must be set");
      }
      return new DaggerAppComponent(this);
    }

    @Override
    public Builder application(Application application) {
      this.application = Preconditions.checkNotNull(application);
      return this;
    }
  }

  private final class MainActivitySubcomponentBuilder
      extends MainActivityModule_ContributeMainActivity.MainActivitySubcomponent.Builder {
    private MainActivity seedInstance;

    @Override
    public MainActivityModule_ContributeMainActivity.MainActivitySubcomponent build() {
      if (seedInstance == null) {
        throw new IllegalStateException(MainActivity.class.getCanonicalName() + " must be set");
      }
      return new MainActivitySubcomponentImpl(this);
    }

    @Override
    public void seedInstance(MainActivity arg0) {
      this.seedInstance = Preconditions.checkNotNull(arg0);
    }
  }

  private final class MainActivitySubcomponentImpl
      implements MainActivityModule_ContributeMainActivity.MainActivitySubcomponent {
    private Provider<
            FragmentBuildersModule_ContributeProjectListFragment.UserListFragmentSubcomponent
                .Builder>
        userListFragmentSubcomponentBuilderProvider;

    private Provider<AndroidInjector.Factory<? extends Fragment>>
        bindAndroidInjectorFactoryProvider;

    private Provider<
            Map<Class<? extends Fragment>, Provider<AndroidInjector.Factory<? extends Fragment>>>>
        mapOfClassOfAndProviderOfFactoryOfProvider;

    private Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;

    private MembersInjector<MainActivity> mainActivityMembersInjector;

    private MainActivitySubcomponentImpl(MainActivitySubcomponentBuilder builder) {
      assert builder != null;
      initialize(builder);
    }

    @SuppressWarnings("unchecked")
    private void initialize(final MainActivitySubcomponentBuilder builder) {

      this.userListFragmentSubcomponentBuilderProvider =
          new dagger.internal.Factory<
              FragmentBuildersModule_ContributeProjectListFragment.UserListFragmentSubcomponent
                  .Builder>() {
            @Override
            public FragmentBuildersModule_ContributeProjectListFragment.UserListFragmentSubcomponent
                    .Builder
                get() {
              return new UserListFragmentSubcomponentBuilder();
            }
          };

      this.bindAndroidInjectorFactoryProvider =
          (Provider) userListFragmentSubcomponentBuilderProvider;

      this.mapOfClassOfAndProviderOfFactoryOfProvider =
          MapProviderFactory
              .<Class<? extends Fragment>, AndroidInjector.Factory<? extends Fragment>>builder(1)
              .put(UserListFragment.class, bindAndroidInjectorFactoryProvider)
              .build();

      this.dispatchingAndroidInjectorProvider =
          DispatchingAndroidInjector_Factory.create(mapOfClassOfAndProviderOfFactoryOfProvider);

      this.mainActivityMembersInjector =
          MainActivity_MembersInjector.create(dispatchingAndroidInjectorProvider);
    }

    @Override
    public void inject(MainActivity arg0) {
      mainActivityMembersInjector.injectMembers(arg0);
    }

    private final class UserListFragmentSubcomponentBuilder
        extends FragmentBuildersModule_ContributeProjectListFragment.UserListFragmentSubcomponent
            .Builder {
      private UserListFragment seedInstance;

      @Override
      public FragmentBuildersModule_ContributeProjectListFragment.UserListFragmentSubcomponent
          build() {
        if (seedInstance == null) {
          throw new IllegalStateException(
              UserListFragment.class.getCanonicalName() + " must be set");
        }
        return new UserListFragmentSubcomponentImpl(this);
      }

      @Override
      public void seedInstance(UserListFragment arg0) {
        this.seedInstance = Preconditions.checkNotNull(arg0);
      }
    }

    private final class UserListFragmentSubcomponentImpl
        implements FragmentBuildersModule_ContributeProjectListFragment
            .UserListFragmentSubcomponent {
      private MembersInjector<UserListFragment> userListFragmentMembersInjector;

      private UserListFragmentSubcomponentImpl(UserListFragmentSubcomponentBuilder builder) {
        assert builder != null;
        initialize(builder);
      }

      @SuppressWarnings("unchecked")
      private void initialize(final UserListFragmentSubcomponentBuilder builder) {

        this.userListFragmentMembersInjector =
            UserListFragment_MembersInjector.create(
                DaggerAppComponent.this.provideViewModelFactoryProvider);
      }

      @Override
      public void inject(UserListFragment arg0) {
        userListFragmentMembersInjector.injectMembers(arg0);
      }
    }
  }

  private final class ViewModelSubComponentBuilder implements ViewModelSubComponent.Builder {
    @Override
    public ViewModelSubComponent build() {
      return new ViewModelSubComponentImpl(this);
    }
  }

  private final class ViewModelSubComponentImpl implements ViewModelSubComponent {
    private Provider<GetUserList> getUserListProvider;

    private Provider<UserListViewModel> userListViewModelProvider;

    private ViewModelSubComponentImpl(ViewModelSubComponentBuilder builder) {
      assert builder != null;
      initialize(builder);
    }

    @SuppressWarnings("unchecked")
    private void initialize(final ViewModelSubComponentBuilder builder) {

      this.getUserListProvider =
          GetUserList_Factory.create(
              MembersInjectors.<GetUserList>noOp(),
              DaggerAppComponent.this.provideUserRepositoryProvider,
              DaggerAppComponent.this.provideThreadExecutorProvider,
              DaggerAppComponent.this.providePostExecutionThreadProvider);

      this.userListViewModelProvider =
          UserListViewModel_Factory.create(
              MembersInjectors.<UserListViewModel>noOp(),
              DaggerAppComponent.this.applicationProvider,
              getUserListProvider,
              UserModelDataMapper_Factory.create());
    }

    @Override
    public UserListViewModel userListViewModel() {
      return userListViewModelProvider.get();
    }
  }
}
