package ru.job4j.lambda.battle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class Field {
    private int round = 0;
    private Random random = new Random();
    private boolean lightWinner = true;
    private int[] disposition = {1, 3, 4};
    private Unit[][] lightPersonajes = {{new Unit("Mage", "Elf", 0, 10.0), new Unit("Mage", "Human", 0, 4.0)}, {new Unit("Archer", "Elf", 7.0, 3.0), new Unit("Crossbowman", "Human", 5.0, 3.0)}, {new Unit("Warrior", "Elf", 15, 15), new Unit("Warrior", "Human", 18.0, 18.0)}};
    private Unit[][] darkPersonajes = {{new Unit("Shaman", "Orc", 0.0, -1.0), new Unit("Necromant", "Walking dead", -1.0, 5.0)}, {new Unit("Archer", "Orc", 3.0, 2.0), new Unit("Hunter", "Walking dead", 4.0, 2.0)}, {new Unit("Goblin", "Orc", 20.0, 20.0), new Unit("Zombi", "Walking dead", 18.0, 18.0)}};
    private ArrayList<Unit> lightUnits;
    private ArrayList<Unit> darkUnits;
    private File log = new File("C:\\projects\\Vasily-Maslov\\chapter_006\\src\\main\\java\\ru\\job4j\\lambda\\battle\\files\\battlelog.txt");
    private FileWriter fw;

    public ArrayList<Unit> getLightUnits() {
        return lightUnits;
    }

    public ArrayList<Unit> getDarkUnits() {
        return darkUnits;
    }

    /**
     * Initialization field with two formed teams and logger.
     */
    public Field() {
        this.lightUnits = fill(this.lightPersonajes);
        this.darkUnits = fill(this.darkPersonajes);
        lightPersonajes = null;
        darkPersonajes = null;
        disposition = null;
        try {
            this.log.createNewFile();
            this.fw = new FileWriter(log, true);
            Date d = new Date();
            this.fw.write(format("%s%s%s", "BATTLE DATE: ", d.toString(), System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Choosing class of who and whom.
     */
    public void battle() {
        if (this.random.nextBoolean()) {
            round(lightUnits, darkUnits);
        } else {
            round(darkUnits, lightUnits);
        }
        lightUnits = deleteGarbage(lightUnits);
        darkUnits = deleteGarbage(darkUnits);
    }

    /**
     * Returning information about teams.
     */
    public void info() {
        logging(format("%s%s", "Light army:", System.lineSeparator()));
        if (lightUnits.size() != 0) {
            this.lightUnits.forEach(x -> logging(format(" %s %s;", x.getType(), x.getName())));
        } else {
            logging("...is down.");
            this.lightWinner = false;
        }
        logging(format("%sDark army:%s", System.lineSeparator(), System.lineSeparator()));
        if (darkUnits.size() != 0) {
            this.darkUnits.forEach(x -> logging(format(" %s %s;", x.getType(), x.getName())));
        } else {
            logging(format("%s%s", "...is down.", System.lineSeparator()));
        }
        logging(format("%s%s", System.lineSeparator(), System.lineSeparator()));
    }

    /**
     * Final actions, results.
     */
    public void end() {
        logging(format("%s%s", "************************", System.lineSeparator()));
        logging(format("%s team wins!%s%s", lightWinner ? "Light" : "Dark", System.lineSeparator(), System.lineSeparator()));
        try {
            this.fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * checking that the game is over.
     *
     * @return game over
     */
    public boolean isDown() {
        return lightUnits.size() == 0 || darkUnits.size() == 0;
    }

    /**
     * Logging class
     *
     * @param log
     */
    private void logging(String log) {
        System.out.print(log);
        try {
            fw.write(log);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                    logging("System error.");
                }
            }
        }
        return persons;
    }

    /**
     * round actions with attacking team (who) and defending (whom).
     *
     * @param who
     * @param whom
     */
    private void round(ArrayList<Unit> who, ArrayList<Unit> whom) {
        this.round++;
        Unit damager = who.stream().filter(Unit::isBlessed).count() > 0 ? who.stream().filter(Unit::isBlessed).collect(Collectors.toList()).get(0) : null;
        String whatsHappen;
        if (damager == null) {
            damager = who.get(random.nextInt(who.size()));

        }
        double damage = chooseAttack(damager);
        int choose = random.nextInt(whom.size());
        if (damage == 0) {
            unitCastingNulling(damager);
            Unit blessed = who.get(random.nextInt(who.size()));
            blessed.setBlessed(true);
            whatsHappen = format("%d. %s %s blessed %s %s.%s%s", this.round, damager.getType(), damager.getName(), blessed.getType(), blessed.getName(), System.lineSeparator(), System.lineSeparator());
        } else if (damage == -1.0) {
            unitCastingNulling(damager);
            whom.get(choose).setCursed(true);
            whatsHappen = format("%d. %s %s cursed %s %s.%s%s", this.round, damager.getType(), damager.getName(), whom.get(choose).getType(), whom.get(choose).getName(), System.lineSeparator(), System.lineSeparator());
        } else {
            damage = damager.isBlessed() ? damage * 2 : damage;
            damage = damager.isCursed() ? damage / 2 : damage;
            unitCastingNulling(damager);
            whom.get(choose).setHealth(whom.get(choose).getHealth() - damage);
            whatsHappen = format("%d. %s %s with %f HP made %f damage to %s %s.%s%s %s's HP = %f now.%s", this.round, damager.getType(), damager.getName(), damager.getHealth(), damage, whom.get(choose).getType(), whom.get(choose).getName(), System.lineSeparator(), whom.get(choose).getType(), whom.get(choose).getName(), whom.get(choose).getHealth(), System.lineSeparator());
        }
        logging(whatsHappen);
        logging(whom.get(choose).getHealth() <= 0 ? String.format("%s %s is down.%s%s", whom.get(choose).getType(), whom.get(choose).getName(), System.lineSeparator(), System.lineSeparator()) : System.lineSeparator());
    }

    /**
     * Method for choose the type of attack.
     *
     * @param unit
     * @return
     */
    private double chooseAttack(Unit unit) {
        return random.nextBoolean() ? unit.getActionOne() : unit.getActionTwo();
    }

    /**
     * Method for nulling all blessings and curses.
     *
     * @param unit
     */
    private void unitCastingNulling(Unit unit) {
        unit.setBlessed(false);
        unit.setCursed(false);
    }

    /**
     * Method for delete troops.
     *
     * @param units
     * @return
     */
    private ArrayList<Unit> deleteGarbage(ArrayList<Unit> units) {
        return (ArrayList<Unit>) units.stream().filter(x -> x.getHealth() > 0).collect(Collectors.toList());
    }
}