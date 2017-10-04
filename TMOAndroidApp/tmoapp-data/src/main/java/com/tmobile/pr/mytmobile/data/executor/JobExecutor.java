
package com.tmobile.pr.mytmobile.data.executor;

import android.support.annotation.NonNull;
import com.tmobile.pr.mytmobile.domain.executor.ThreadExecutor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Decorated {@link ThreadPoolExecutor}
 */
@Singleton
public class JobExecutor implements ThreadExecutor {
    private final ThreadPoolExecutor threadPoolExecutor;
    private int INITIAL_POOL_SIZE = 3;
    private int MAX_POOL_SIZE = 5;

    // Sets the amount of time an idle thread waits before terminating
    private int KEEP_ALIVE_TIME = 10;

    // Sets the Time Unit to seconds
    private TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;

    @Inject
    JobExecutor() {
        this.threadPoolExecutor = new ThreadPoolExecutor(INITIAL_POOL_SIZE, MAX_POOL_SIZE,
                KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT, new LinkedBlockingQueue<Runnable>(), new JobThreadFactory());
    }

    @Override
    public void execute(@NonNull Runnable runnable) {
        this.threadPoolExecutor.execute(runnable);
    }

    private static class JobThreadFactory implements ThreadFactory {
        private int counter = 0;

        @Override
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(runnable, "android_" + counter++);
        }
    }
}
