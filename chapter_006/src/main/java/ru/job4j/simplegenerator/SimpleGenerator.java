package ru.job4j.simplegenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Main class of generator
 */
public class SimpleGenerator {
    private Map map;

    public SimpleGenerator() {
        map = new HashMap<String, String>();
    }

    /**
     * Methods to put the value into the map
     *
     * @param values
     */
    public void addMapValue(ArrayList<String> values) {
        map.put(values.get(0), values.get(1));
    }

    public void addMapValue(Map.Entry<String, String> entry) {
        map.put(entry.getKey(), entry.getValue());
    }

    /**
     * Method that looks at map values and check are they in the string or no.
     *
     * @param enter
     * @return
     */
    public String generate(String enter) {
        try {
            check();
        } catch (NullMapException e) {
            System.out.println(e.getMessage());
//            e.printStackTrace();
        }
        Iterator it = this.map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (enter.contains((CharSequence) entry.getKey())) {
                enter = enter.replace((CharSequence) entry.getKey(), (CharSequence) entry.getValue());
            }
        }
        return enter;
    }

    /**
     * Method to avoid the Exception
     *
     * @throws NullMapException
     */
    private void check() throws NullMapException {
        if (this.map.isEmpty()) {
            throw new NullMapException("Exception! The map is empty!");
        }
    }
}
