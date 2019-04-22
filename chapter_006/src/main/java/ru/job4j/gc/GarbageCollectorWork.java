package ru.job4j.gc;

public class GarbageCollectorWork {

    public static void info() {
        int mb = 1024 * 1024;
        Runtime rt = Runtime.getRuntime();
        System.out.println("Total memory: " + rt.totalMemory());
        System.out.println("Used memory: " + (rt.totalMemory() - rt.freeMemory()));
    }

    public static void main(String[] args) {
        // count нужен, чтобы отследить,какие объекты созданы, а какие уничтожены
        int count = 1;
        System.out.println("Memory status before creating object:");
        info();
        User u = new User(0);
        System.out.println("Memory status after creating object:");
        info();
        u = null;
        while (true) {
            new User(count++);
            count = count == Integer.MAX_VALUE ? 1 : count;
        }
    }
}
