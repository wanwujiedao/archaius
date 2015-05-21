package com.netflix.archaius.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadFactories {
    public static ThreadFactory newNamedDaemonThreadFactory(final String name) {
        final AtomicInteger counter = new AtomicInteger();
        
        return new ThreadFactory() {
            @Override
            public Thread newThread(Runnable runnable) {
                Thread thread = Executors.defaultThreadFactory().newThread(runnable);
                thread.setDaemon(true);
                thread.setName(String.format(name, counter.incrementAndGet()));
                return thread;
            }
        };
    }
}
