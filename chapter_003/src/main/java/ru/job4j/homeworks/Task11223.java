package ru.job4j.homeworks;

//11.223. Даны два массива из 20 однозначных чисел. В первом из них записано количество мячей,
//        забитых футбольной командой в игре, во втором — количество пропущенных мячей в этой же игре.
//        а) Для каждой проведенной игры напечатать словесный результат: "выигрыш", "ничья" или "проигрыш".
//        б) Определить количество выигрышей данной команды.
//        в) Определить количество выигрышей и количество проигрышей данной команды.
//        г) Определить количество выигрышей, количество ничьих и количество проигрышей данной команды.
//        д) Определить, в скольких играх разность забитых и пропущенных мячей была большей или равной трем.
//        е) Общее число очков, набранных командой (за выигрыш дается 3 очка, за ничью — 1, за проигрыш — 0).

import java.util.List;

public class Task11223 {
    public String games(int[] goals, int[] falses) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < goals.length; i++) {
            String game = goals[i] > falses[i] ? "victory" : goals[i] == falses[i] ? "drawn game" : "false";
            result.append(String.format("Game №%d. Count %d:%d. Result - %s.\n", i + 1, goals[i], falses[i], game));
        }
        return result.toString();
    }

    public int[] gamesResult(int[] goals, int[] falses) {
        int[] result = new int[3];
        for (int i = 0; i < goals.length; i++) {
            if (goals[i] > falses[i]) {
                result[0]++;
            } else if (goals[i] == falses[i]) {
                result[1]++;
            } else {
                result[2]++;
            }
        }
        return result;
    }

    public String interestingGame(int[] goals, int[] falses) {
        String result = "Most interesting games:";
        String game = "";
        for (int i = 0; i < falses.length; i++) {
            if (Math.abs(goals[i] - falses[i]) >= 3) {
                game = "number " + (i + 1);
                result = String.format("%s \n %s", result, game);
            }
        }
        result = game.equals("") ? "There wasn't interesting games!" : result;
        return result;
    }

    public int count(int[] goals, int[] falses) {
        int result = 0;
        for (int i = 0; i < falses.length; i++) {
            result += goals[i] > falses[i] ? 3 : goals[i] == falses[i] ? 1 : 0;
        }
        return result;
    }

    public String games(List<Integer> goals, List<Integer> falses) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < goals.size(); i++) {
            String game = goals.get(i) > falses.get(i) ? "victory" : goals.get(i).equals(falses.get(i)) ? "drawn game" : "false";
            result.append(String.format("Game №%d. Count %d:%d. Result - %s.\n", i + 1, goals.get(i), falses.get(i), game));
        }
        return result.toString();
    }
}
