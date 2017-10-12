
package com.tmobile.pr.mytmobile.domain.interactor.browse;

import com.tmobile.pr.mytmobile.domain.executor.PostExecutionThread;
import com.tmobile.pr.mytmobile.domain.executor.ThreadExecutor;
import com.tmobile.pr.mytmobile.domain.interactor.UseCase;
import com.tmobile.pr.mytmobile.domain.model.User;
import com.tmobile.pr.mytmobile.domain.repository.UserRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * retrieving a collection of all {@link User}.
 */
public class GetUserList extends UseCase<List<User>, Void> {

    private final UserRepository userRepository;

    @Inject
    GetUserList(UserRepository userRepository, ThreadExecutor threadExecutor,
                PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
    }

    @Override
    public Observable<List<User>> buildUseCaseObservable(Void unused) {
        return this.userRepository.users();
    }
}
