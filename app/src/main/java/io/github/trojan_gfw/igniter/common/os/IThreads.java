package io.github.trojan_gfw.igniter.common.os;

import java.util.concurrent.Executor;

/**
 * 线程池的接口。提供方法使 {@link Task} 或者 {@link Runnable}在主线程或者后台运行
 * Interface of thread pool. Provides methods to run {@link Task} or {@link Runnable} in main thread
 * or in background.
 */
public interface IThreads {
    Executor getThreadPoolExecutor();

    void runOnUiThread(Runnable runnable);

    void runOnUiThread(Runnable runnable, long delayMillis);

    void runOnWorkThread(Task task);

    void runOnWorkThread(final Task task, long delayMillis);

    void removeDelayedAction(Runnable action);
}
