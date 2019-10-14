package ru.job4j.homeworks;

//12.277. Выяснить, есть ли в массиве строки, в которых буква а расположена справа
//        от буквы д (известно, что буква д в каждой строке единственная).

public class Task12277 {
    public boolean check(char[][] ch, char a, char z) {
        boolean result = false;
        boolean is;
        for (int i = 0; i < ch.length; i++) {
            is = false;
            for (int j = 0; j < ch[i].length; j++) {
                if (ch[i][j] == a) {
                    is = true;
                }
                if (is && ch[i][j] == z) {
                    result = true;
                    break;
                }
            }
            if (result) {
                break;
            }
        }
        return result;
    }
}
