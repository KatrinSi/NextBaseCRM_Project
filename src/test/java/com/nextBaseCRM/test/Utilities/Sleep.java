package com.nextBaseCRM.test.Utilities;

public class Sleep {
    public static void toSleep(long seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
