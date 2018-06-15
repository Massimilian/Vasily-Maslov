package ru.job4j.tracker2.start;
import ru.job4j.tracker2.models.*;
import java.util.*;

public class TrackerSecond {
    private List<ItemSecond> items = new ArrayList<>();
    private static final Random RN = new Random();

    public ItemSecond getItem(int position) {
        return items.get(position);
    }

    public void add(ItemSecond item) {
        item.setId(this.generateId());
        items.add(item);
    }

    public void update(ItemSecond fresh) {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i) != null && this.items.get(i).getId().equals(fresh.getId())) {
                items.remove(i);
                items.add(i, fresh);
                break;
            }
        }
    }


    public void delete(String id) {
        for (int i = 0; i < this.items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                items.remove(i);
                break;
            }
        }
    }

    public ArrayList<ItemSecond> findByName(String key) {
        ArrayList<ItemSecond> result = new ArrayList<>();
        for (ItemSecond item : items) {
            if (item != null && item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    protected ItemSecond findById(String id) {
        ItemSecond result = null;
        for (ItemSecond item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }

    public List<ItemSecond> getAll() {
        return items;
    }

}