package ru.job4j.threads.threadsproblems.lifelock;

public class PoliteMan {
    private String name;
    private boolean active;
    private final String ln = System.lineSeparator();

    public PoliteMan(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public synchronized void work(BackPoliteMan backPoliteMan, PoliteMan otherMan) {
//        Пока сохраняется активность (а она будет сохраняться всегда)...
        while (active) {
            // если в переменной backPoliteMan хранится ссылка на этого же PoliteMan, то ждём. Если нет - тогда "передаём ресурс" другому worker
            if (backPoliteMan.getMan() != this) {
                try {
//                  Если вдруг backPoliteMan и наш экземпляр не совпали - значит,
//                  другой метод ещё не успел отработать. Надо подождать.
                    wait(1);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
                continue;
            }
//          пока "другой worker" активен - передаём ему активность.
            if (otherMan.isActive()) {
                System.out.printf("%s is listening to %s.%s", this.getName(), otherMan.getName(), ln);
//              меняем значение переменной otherWorker и вываливаемся из цикла
                backPoliteMan.setMan(otherMan);
//              самая важная строчка, предотвращающая изменения статуса active и, тем самым,
//              помещающая нас в состояние вечного возвращения в один и тот же "вечный поток".
                continue;
            }
//          так как оба раза отработал continue, мы никогда не достигнем этих строк и,
//          как следствие, будем всё время крутиться между двух потоков.
            System.out.printf("%s has started talking.%s", getName(), ln);
            active = false;
            backPoliteMan.setMan(otherMan);
        }
    }
}
