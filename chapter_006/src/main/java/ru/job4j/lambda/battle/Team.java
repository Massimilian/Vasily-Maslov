package ru.job4j.lambda.battle;

import java.util.ArrayList;
import java.util.Random;

public class Team {
    Logger log;
    int[] disposition;
    private Random random = new Random();

    public Team(Logger log, int[] disposition) {
        this.log = log;
        this.disposition = disposition;
    }

    /**
     * Method to form the team
     *
     * @param light -true, dark - false
     * @return
     */
    public ArrayList<Unit> form(boolean light) {
        ArrayList<Unit> result;
        if (light) {
            Unit[][] lightPersonajes = {{new Unit("Mage", "Elf", 0, 10.0), new Unit("Mage", "Human", 0, 4.0)}, {new Unit("Archer", "Elf", 7.0, 3.0), new Unit("Crossbowman", "Human", 5.0, 3.0)}, {new Unit("Warrior", "Elf", 15, 15), new Unit("Warrior", "Human", 18.0, 18.0)}};
            result = fill(lightPersonajes);
        } else {
            Unit[][] darkPersonajes = {{new Unit("Shaman", "Orc", 0.0, -1.0), new Unit("Necromant", "Walking dead", -1.0, 5.0)}, {new Unit("Archer", "Orc", 3.0, 2.0), new Unit("Hunter", "Walking dead", 4.0, 2.0)}, {new Unit("Goblin", "Orc", 20.0, 20.0), new Unit("Zombi", "Walking dead", 18.0, 18.0)}};
            result = fill(darkPersonajes);
        }
        return result;
    }

    /**
     * Method for prepare team to battle.
     *
     * @param personajes
     * @return ready team
     */
    private ArrayList<Unit> fill(Unit[][] personajes) {
        ArrayList<Unit> persons = new ArrayList<>();
        for (int i = 0; i < this.disposition.length; i++) {
            for (int j = 0; j < this.disposition[i]; j++) {
                try {
                    persons.add((Unit) personajes[i][this.random.nextInt(2)].clone());
                } catch (CloneNotSupportedException cnse) {
                    log.logging("System error.");
                }
            }
        }
        return persons;
    }
}
