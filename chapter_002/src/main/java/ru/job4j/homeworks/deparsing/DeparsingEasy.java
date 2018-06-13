package ru.job4j.homeworks.deparsing;

public class DeparsingEasy {
    private String str;
    private char[] string;

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


    public int[][] deparseAnotherWay(String str) {
        this.string = str.toCharArray();
        int[][] result = new int[string.length / 2 + 1][2];
        int count = 0;
        char[] openValues = {'{', '(', '['};
        char[] closeValues = {'}', ')', ']'};
        for (int i = string.length - 2; i >= 0; i--) {
            if (string[i] == closeValues[0] || string[i] == closeValues[1] || string[i] == closeValues[2]) {
                continue;
            }
            if (string[i] == openValues[0]) {
                closeValues = new char[]{'}', ')', ']'};
                result = this.preparing(result, i, closeValues, count);
                count++;
            }
            if (string[i] == openValues[1]) {
                closeValues = new char[]{')', ']', '}'};
                result = this.preparing(result, i, closeValues, count);
                count++;
            }
            if (string[i] == openValues[2]) {
                closeValues = new char[]{']', '}', ')'};
                result = this.preparing(result, i, closeValues, count);
                count++;
            }
        }

        return this.correct(result);
    }


    private int[][] preparing(int[][] result, int numberOfI, char[] closeValues, int count) {
        for (int j = numberOfI + 1; j < string.length; j++) {
            if (string[j] == closeValues[0]) {
                result[count][0] = numberOfI + 1;
                result[count][1] = j + 1;
                string[numberOfI] = '*';
                string[j] = '*';
                break;
            }
            if (string[j] == closeValues[1] || string[j] == closeValues[2]) {
                break;
            }
        }
        return result;
    }

    private int[][] correct(int[][] mediumResult) {
        int count = 0;
        for (int i = 0; i < mediumResult.length; i++) {
            if (mediumResult[i][0] != 0) {
                count++;
            }
        }
        int[][] result = new int[count][2];
        count = 0;
        for (int i = 0; i < mediumResult.length; i++) {
            if (mediumResult[i][0] != 0) {
                result[count][0] = mediumResult[i][0];
                result[count++][1] = mediumResult[i][1];
            }
        }
        return result;
    }
}