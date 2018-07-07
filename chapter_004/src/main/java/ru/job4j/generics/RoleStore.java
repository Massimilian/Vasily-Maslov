package ru.job4j.generics;

public class RoleStore extends AbstractStore<Role> {

    public RoleStore(int size) {
        this.userSa = new SimpleArray<>(size);
        super.size = size;
    }

    @Override
    public Role findById(String id) {
        Role role = new Role(null);
        for (int i = 0; i < size; i++) {
            Role t = (Role) this.userSa.get(i);
            if (t != null && t.getId().equals(id)) {
                role = t;
                break;
            }
        }
        return role;
    }
}
