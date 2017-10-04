
package com.tmobile.pr.mytmobile.domain.repository;



import com.tmobile.pr.mytmobile.domain.model.User;
import io.reactivex.Observable;
import java.util.List;

/**
 * Interface that represents a Repository for getting {@link User} related data.
 */
public interface UserRepository {
  /**
   * Get an {@link Observable} which will emit a List of {@link User}.
   */
  Observable<List<User>> users();

}