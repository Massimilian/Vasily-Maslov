package ru.job4j.concurrency;

import java.util.concurrent.Callable;

public class Call implements Callable<String> {
    final int version; // версия файла - понадобится, чтобы отследить конкретный поток

    public Call(int version) {
        this.version = version;
    }

    @Override
    public String call() throws Exception {
        return String.format("Callable %d worked.", version);
    }
}
