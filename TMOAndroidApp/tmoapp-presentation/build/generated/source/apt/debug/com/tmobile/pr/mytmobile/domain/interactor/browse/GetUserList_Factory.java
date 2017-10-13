package com.tmobile.pr.mytmobile.domain.interactor.browse;

import com.tmobile.pr.mytmobile.domain.executor.PostExecutionThread;
import com.tmobile.pr.mytmobile.domain.executor.ThreadExecutor;
import com.tmobile.pr.mytmobile.domain.repository.UserRepository;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GetUserList_Factory implements Factory<GetUserList> {
  private final MembersInjector<GetUserList> getUserListMembersInjector;

  private final Provider<UserRepository> userRepositoryProvider;

  private final Provider<ThreadExecutor> threadExecutorProvider;

  private final Provider<PostExecutionThread> postExecutionThreadProvider;

  public GetUserList_Factory(
      MembersInjector<GetUserList> getUserListMembersInjector,
      Provider<UserRepository> userRepositoryProvider,
      Provider<ThreadExecutor> threadExecutorProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    assert getUserListMembersInjector != null;
    this.getUserListMembersInjector = getUserListMembersInjector;
    assert userRepositoryProvider != null;
    this.userRepositoryProvider = userRepositoryProvider;
    assert threadExecutorProvider != null;
    this.threadExecutorProvider = threadExecutorProvider;
    assert postExecutionThreadProvider != null;
    this.postExecutionThreadProvider = postExecutionThreadProvider;
  }

  @Override
  public GetUserList get() {
    return MembersInjectors.injectMembers(
        getUserListMembersInjector,
        new GetUserList(
            userRepositoryProvider.get(),
            threadExecutorProvider.get(),
            postExecutionThreadProvider.get()));
  }

  public static Factory<GetUserList> create(
      MembersInjector<GetUserList> getUserListMembersInjector,
      Provider<UserRepository> userRepositoryProvider,
      Provider<ThreadExecutor> threadExecutorProvider,
      Provider<PostExecutionThread> postExecutionThreadProvider) {
    return new GetUserList_Factory(
        getUserListMembersInjector,
        userRepositoryProvider,
        threadExecutorProvider,
        postExecutionThreadProvider);
  }
}
