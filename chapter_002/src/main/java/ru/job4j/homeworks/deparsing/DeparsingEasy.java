package ru.job4j.homeworks.deparsing;

public class DeparsingEasy {
    private String str;

    public int[][] deparse(String str) {
        this.str = str;
        int[][] result = new int[this.str.length() / 2][2];
        result = working(result);
        return result;
    }

    private int[][] working(int[][] result) {
        for (int i = 0; i < this.str.length() - 1; i++) {
            if (this.str.charAt(i) == '(') {
                result = this.check(result, i, new char[]{'(', ')', '{', '}', '[', ']'});
            }
            if (this.str.charAt(i) == '[') {
                result = this.check(result, i, new char[]{'[', ']', '(', ')', '{', '}'});
            }
            if (this.str.charAt(i) == '{') {
                result = this.check(result, i, new char[]{'{', '}', '[', ']', '(', ')'});
            }
        }
        return result;
    }

    private int[][] check(int[][] result, int position, char[] values) {
        boolean timeToGoAway = false;
        int count = position + 1;
        do {
            if (this.str.charAt(count) == values[3] || this.str.charAt(count) == values[5]) {
                char[] string = this.str.toCharArray();
                string[count] = '0';
                str = new String(string);
                timeToGoAway = true;
            }

            if (this.str.charAt(count) == values[0]) {
                result = this.check(result, count, values);
            }

            if (this.str.charAt(count) == values[2]) {
                result = this.check(result, count, new char[]{values[2], values[3], values[4], values[5], values[0], values[1]});
            }

            if (this.str.charAt(count) == values[4]) {
                result = this.check(result, count, new char[]{values[4], values[5], values[0], values[1], values[2], values[3]});
            }

            if (this.str.charAt(count) == values[1]) {
                for (int k = 0; k < result.length; k++) {
                    if (result[k][1] == 0) {
                        result[k][0] = position;
                        result[k][1] = count;
                        char[] string = this.str.toCharArray();
                        string[position] = '0';
                        string[count] = '0';
                        this.str = new String(string);
                        timeToGoAway = true;
                        break;
                    }
                }
            }
            count++;
            if (count == this.str.length()) {
                timeToGoAway = true;
            }
        } while (!timeToGoAway);
        return result;
    }
}