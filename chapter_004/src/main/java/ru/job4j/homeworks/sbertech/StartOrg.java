package ru.job4j.homeworks.sbertech;

import java.util.Scanner;

public class StartOrg {
    public static void main(String[] args) {
        Organizer organizer = new Organizer();
        boolean cont = true;
        while (cont) {
            organizer.help();
            Scanner scanner = new Scanner(System.in);
            String ask = scanner.nextLine();
            if (ask.equals("1")) {
                organizer.help();
            } else if (ask.equals("2")) {
                organizer.insert(organizer.getInfo());
            } else if (ask.equals("3")) {
                organizer.update(organizer.getSmallInfo("name for change"), organizer.getInfo());
            } else if (ask.equals("4")) {
                organizer.delete(organizer.getSmallInfo("name"));
            } else if (ask.equals("5")) {
                organizer.list();
            } else if (ask.equals("6")) {
                organizer.findByTel(organizer.getSmallInfo("phone number"));
            } else if (ask.equals("7")) {
                cont = organizer.finish();
            } else {
                System.out.println("Unknown operation! Read the possible operations, please.");
            }
        }
    }
}
