
package com.tmobile.pr.mytmobile.data.repository.datasource;

import com.tmobile.pr.mytmobile.data.entity.UserEntity;
import com.tmobile.pr.mytmobile.data.net.RestApi;

import java.util.List;

import io.reactivex.Observable;

/**
 * {@link UserDataStore} implementation based on connections to the api (Cloud).
 */
class CloudUserDataStore implements UserDataStore {

  private final RestApi restApi;

  /**
   * Construct a {@link UserDataStore} based on connections to the api (Cloud).
   *
   * @param restApi The {@link RestApi} implementation to use.
   */
  CloudUserDataStore(RestApi restApi) {
    this.restApi = restApi;
  }

  @Override public Observable<List<UserEntity>> userEntityList() {
    return this.restApi.userEntityList();
  }

}
