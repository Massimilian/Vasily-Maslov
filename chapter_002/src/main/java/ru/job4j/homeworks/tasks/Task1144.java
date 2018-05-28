package ru.job4j.homeworks.tasks;

//11.44. В массиве хранится информация о количестве побед, одержанных 20 фут-больными командами.
//        Определить номера команд, имеющих меньше трех побед.

public class Task1144 {
    public int[] viewOutsiders(int[] commands) {
        int count = 0;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] >= 3) {
                commands[i] = -1;
            } else {
                count++;
            }
        }
        int[] result = new int[count];
        count = 0;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] != -1) {
                result[count++] = i + 1;
            }
        }
        return result;
    }
}
