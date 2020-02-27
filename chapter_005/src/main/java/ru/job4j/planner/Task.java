package ru.job4j.planner;

import java.util.Date;

public class Task {
    int number;
    String info;
    int urgency;
    Date createDate;
    String color;

    public Task(String info, int urgency) {
        this.info = info;
        this.urgency = urgency;
    }

    public Task(int number, String info, int urgency, Date createDate) {
        this.number = number;
        this.info = info;
        this.urgency = urgency;
        this.createDate = createDate;
    }

    public int getNumber() {
        return number;
    }

    public String getInfo() {
        return info;
    }

    public int getUrgency() {
        return urgency;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getColor() {
        switch (this.urgency) {
            case 1:
                this.color = "crimson";
                break;
            case 2:
                this.color = "orange";
                break;
            case 3:
                this.color = "gold";
                break;
            case 4:
                this.color = "chartreuse";
                break;
            case 5:
                this.color = "aquamarine";
                break;
            case 6:
                this.color = "aqua";
                break;
            case 7:
                this.color = "fuchsia";
                break;
            default:
                this.color = "aliceblue";
        }
        return this.color;
    }
}
