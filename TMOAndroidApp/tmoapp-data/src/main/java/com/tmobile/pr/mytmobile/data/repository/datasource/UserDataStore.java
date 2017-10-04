
package com.tmobile.pr.mytmobile.data.repository.datasource;

import com.tmobile.pr.mytmobile.data.entity.UserEntity;

import io.reactivex.Observable;
import java.util.List;

/**
 * Interface that represents a data store from where data is retrieved.
 */
public interface UserDataStore {
  /**
   * Get an {@link Observable} which will emit a List of {@link UserEntity}.
   */
  Observable<List<UserEntity>> userEntityList();

}
