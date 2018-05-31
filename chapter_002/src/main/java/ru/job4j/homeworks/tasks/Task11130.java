package ru.job4j.homeworks.tasks;

//11.130. Известны очки (3, 1 или 0), полученные футбольной командой за ряд игр в порядке их проведения.
//        Что было раньше: первый выигрыш (3 очка) или первый проигрыш (0 очков)?

public class Task11130 {
    public String info(int[] array) {
        String result = "There were not loses and wins!";
        for (int i : array) {
            if (i == 3) {
                result = "Win first";
                break;
            }
            if (i == 0) {
                result = "Lose first";
                break;
            }
        }
        return result;
    }
}
