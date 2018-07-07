package ru.job4j.generics;

public abstract class AbstractStore <T extends Base> implements Store<Base>{
    protected int size;
    SimpleArray<Base> userSa;

    @Override
    public void add(Base model) {
        this.userSa.add(model);
    }

    @Override
    public boolean replace(String id, Base model) {
        boolean done = false;
        Base base = findById(id);
        if (base.getId() != null) {
            userSa.set(userSa.findIndex(base), model);
            done = true;
        }
        return done;
    }

    @Override
    public boolean delete(String id) {
        boolean done = false;
        Base base = findById(id);
        if (base.getId() != null) {
            this.userSa.delete(userSa.findIndex(base));
            done = true;
        }
        return done;
    }
}
