package ru.job4j.pool;

import ru.job4j.producerconsumer.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;

// Не уверен, что верно понял задачу. Поэтому комментирую каждый шаг, чтобы было понятно, чего я пытаюсь добиться каждым следующим методом.
public class ThreadPool {
    private final int size = Runtime.getRuntime().availableProcessors();
    private final List<Thread> threads = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>();

    // добавляем задачи в tasks. Если задач уже слишком много, tasks ждёт освобождения пространства. Затем запускаем метод run.
    public void work(Runnable job) {
        tasks.offer(job);
        this.run();
    }

    // будим все потоки. Если размер threads не больше количества ядер в процессоре, то добавляем задачу (одновременно изымая её из tasks и освобождая место для следующей задачи). Иначе ждём.
    private void run() {
        if (this.threads.size() < this.size) {
            threads.add(new Thread(tasks.poll()));
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // по реализации данного метода не нашёл никаких указаний.
    public void shutdown() {
        threads.stream().forEach(t -> t.interrupt());
    }
}