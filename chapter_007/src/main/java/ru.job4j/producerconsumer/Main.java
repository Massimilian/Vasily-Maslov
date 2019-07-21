package ru.job4j.producerconsumer;

public class Main {
    public static void main(String[] args) {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<Integer>();
        final Thread consumer = new Thread(
                () -> {
                    while (true) {
                        System.out.printf("%s (consumer) - %d.%s", Thread.currentThread().getName(), queue.poll(), System.lineSeparator());
                    }
                }
        );
        consumer.setDaemon(true);
        consumer.start();
        new Thread(
                () -> {
                    for (int index = 0; index != 3; index++) {
                        queue.offer(index);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Producer finished.");
                }
        ).start();
    }
}
