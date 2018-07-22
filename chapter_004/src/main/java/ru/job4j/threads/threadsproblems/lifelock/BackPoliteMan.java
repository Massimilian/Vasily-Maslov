package ru.job4j.threads.threadsproblems.lifelock;

public class BackPoliteMan {
    private PoliteMan man;

    public BackPoliteMan(PoliteMan man) {
        this.man = man;
    }

    public PoliteMan getMan() {
        return man;
    }

//  На тот случай, если в PoliteMan всё-таки уберём continue,
//  лучше подстраховаться и синхронизировать метод во избежание Race Condition
    public synchronized void setMan(PoliteMan man) {
        this.man = man;
    }
}