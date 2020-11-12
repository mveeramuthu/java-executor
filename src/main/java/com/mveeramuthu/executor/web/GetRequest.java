package com.mveeramuthu.executor.web;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GetRequest {
    private final ExecutorService executor;

    public GetRequest(int numThreads) {
        executor = Executors.newFixedThreadPool(numThreads);
    }

    public void executeGetRequest(String requestName) {
        executor.execute(() -> {
            System.out.println("Executing "+ requestName +" with "+Thread.currentThread().getName());
        });
    }

    public ExecutorService getExecutor() {
        return executor;
    }

    public static void main(String args[]) {
        var obj = new GetRequest(10);

        try {
            obj.executeGetRequest("getHomePageRequest");
            obj.executeGetRequest("getCataloguePageRequest");
            obj.executeGetRequest("getCartPageRequest");
        } finally {
            obj.getExecutor().shutdown();
        }
    }
}
