package com.tmobile.pr.mytmobile.domain.executor;

import io.reactivex.Scheduler;

public interface PostExecutionThread {
    public Scheduler getScheduler();
}