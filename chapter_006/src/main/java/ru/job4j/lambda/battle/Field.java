package ru.job4j.lambda.battle;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class Field {
    private int[] disposition = {1, 3, 4};
    private Logger logger = new Logger();
    private Team team = new Team(logger, disposition);
    private Round r = new Round();
    private Random random = new Random();
    private boolean lightWinner = true;
    private ArrayList<Unit> lightUnits;
    private ArrayList<Unit> darkUnits;

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
        this.lightUnits = team.form(true);
        this.darkUnits = team.form(false);
        team = null; // making free memory
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
     * round actions with attacking team (who) and defending (whom).
     *
     * @param who
     * @param whom
     */
    private void round(ArrayList<Unit> who, ArrayList<Unit> whom) {
        this.r.upgrade();
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
            whatsHappen = format("%s%s %s blessed %s %s.%s%s", this.r.getRound(), damager.getType(), damager.getName(), blessed.getType(), blessed.getName(), System.lineSeparator(), System.lineSeparator());
        } else if (damage == -1.0) {
            unitCastingNulling(damager);
            whom.get(choose).setCursed(true);
            whatsHappen = format("%s%s %s cursed %s %s.%s%s", this.r.getRound(), damager.getType(), damager.getName(), whom.get(choose).getType(), whom.get(choose).getName(), System.lineSeparator(), System.lineSeparator());
        } else {
            damage = damager.isBlessed() ? damage * 2 : damage;
            damage = damager.isCursed() ? damage / 2 : damage;
            unitCastingNulling(damager);
            whom.get(choose).setHealth(whom.get(choose).getHealth() - damage);
            whatsHappen = format("%s%s %s with %f HP made %f damage to %s %s.%s%s %s's HP = %f now.%s", this.r.getRound(), damager.getType(), damager.getName(), damager.getHealth(), damage, whom.get(choose).getType(), whom.get(choose).getName(), System.lineSeparator(), whom.get(choose).getType(), whom.get(choose).getName(), whom.get(choose).getHealth(), System.lineSeparator());
        }
        logger.logging(whom.get(choose).getHealth() <= 0 ? String.format("%s%s %s is down.%s%s", whatsHappen, whom.get(choose).getType(), whom.get(choose).getName(), System.lineSeparator(), System.lineSeparator()) : String.format("%s%s", whatsHappen, System.lineSeparator()));
    }

    /**
     * Returning information about teams.
     */
    public void info() {
        logger.logging(format("%s%s", "Light army:", System.lineSeparator()));
        if (lightUnits.size() != 0) {
            this.lightUnits.forEach(x -> logger.logging(format(" %s %s;", x.getType(), x.getName())));
        } else {
            logger.logging("...is down.");
            this.lightWinner = false;
        }
        logger.logging(format("%sDark army:%s", System.lineSeparator(), System.lineSeparator()));
        if (darkUnits.size() != 0) {
            this.darkUnits.forEach(x -> logger.logging(format(" %s %s;", x.getType(), x.getName())));
        } else {
            logger.logging(format("%s%s", "...is down.", System.lineSeparator()));
        }
        logger.logging(format("%s%s", System.lineSeparator(), System.lineSeparator()));
    }

    /**
     * Final actions, results.
     */
    public void end() {
        logger.logging(format("%s%s%s team wins!%s%s", "************************", System.lineSeparator(), lightWinner ? "Light" : "Dark", System.lineSeparator(), System.lineSeparator()));
        this.logger.close();
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
     * Method for choose the type of attack.
     *
     * @param unit for choosing attack
     * @return with chosen attack
     */
    private double chooseAttack(Unit unit) {
        return random.nextBoolean() ? unit.getActionOne() : unit.getActionTwo();
    }

    /**
     * Method for nulling all blessings and curses.
     *
     * @param unit for dispelling
     */
    private void unitCastingNulling(Unit unit) {
        unit.setBlessed(false);
        unit.setCursed(false);
    }

    /**
     * Method for delete troops.
     *
     * @param units to clean
     * @return cleaned team
     */
    private ArrayList<Unit> deleteGarbage(ArrayList<Unit> units) {
        return (ArrayList<Unit>) units.stream().filter(x -> x.getHealth() > 0).collect(Collectors.toList());
    }
}