package com.mveeramuthu.executor.basic;

class MyRunnable implements Runnable {
    private final String task;

    MyRunnable(String task) {
        this.task = task;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
           System.out.println("Executing "+ task +" with "+Thread.currentThread().getName());
        }
        System.out.println();
    }
}
