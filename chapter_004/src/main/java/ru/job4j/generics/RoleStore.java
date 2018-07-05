package ru.job4j.generics;

public class RoleStore extends AbstractStore implements Store<Role> {

    public RoleStore(int size) {
        this.userSa = new SimpleArray<>(size);
        super.size = size;
    }

    @Override
    public void add(Role model) {
        this.userSa.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        boolean done = false;
        Role role = findById(id);
        if (role.getId() != null) {
            userSa.set(userSa.findIndex(role), model);
            done = true;
        }
        return done;
    }

    @Override
    public boolean delete(String id) {
        boolean done = false;
        Role role = findById(id);
        if (role.getId() != null) {
            this.userSa.delete(userSa.findIndex(role));
            done = true;
        }
        return done;
    }

    @Override
    public Role findById(String id) {
        Role role = new Role(null);
        for (int i = 0; i < size; i++) {
            Role t = this.userSa.get(i);
            if (t != null && t.getId().equals(id)) {
                role = t;
                break;
            }
        }
        return role;
    }
}
