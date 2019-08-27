package ru.job4j.wget;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WGet {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future future = executor.submit(new Http(new Downloadable("https://imslp.org/wiki/Symphony_No.23_in_D_major%2C_K.181%2F162b_(Mozart%2C_Wolfgang_Amadeus)", 100)));
        System.out.println(future.get());
        executor.shutdown();
    }
}
