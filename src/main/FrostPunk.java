package main;

import manager.Controller;

public class FrostPunk {
    public static void main(String[] args) {
        (new Controller()).init();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                (new Controller()).init2();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(10000);
                        (new Controller()).goDowmTemperature();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
