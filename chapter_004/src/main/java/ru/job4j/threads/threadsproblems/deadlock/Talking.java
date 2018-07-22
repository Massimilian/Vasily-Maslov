package ru.job4j.threads.threadsproblems.deadlock;

public class Talking {
    private String name;
    private final String ln = System.lineSeparator();

    public Talking(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
//      Вызываем синхронизированный (!) метод, который будет что-нибудь делать (соответственно, "вешать замок")
//      и обращаться ко второму методу (также "вешая замок")
    public synchronized void tell(Talking talk) {
        System.out.format("%s: %s is working. %s", this.name, talk.getName(), this.ln);
        talk.tellBack(this);
    }

    //      "Вешаем замок" на второй метод. Доступа к нему не будет.
    public synchronized void tellBack(Talking talk) {
        System.out.format("%s: %s is working too. %s", this.name, talk.getName(), this.ln);
    }
}

