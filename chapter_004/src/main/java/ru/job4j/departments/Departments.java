package ru.job4j.departments;

import java.util.ArrayList;
import java.util.List;

public class Departments {
    List<Department> deps = new ArrayList<>();

    public Departments(List<Department> deps) {
        this.deps = deps;
    }

    public void firstSort() {
        for (int i = 0; i < deps.size(); i++) {
            if (deps.get(i).getName().contains("\\")) {
                this.edit(i);
            }
        }
    }

    public void edit(int position) {
        String name = "";
        for (int i = 0; i < this.deps.get(position).getName().length(); i++) {
            name = name + this.deps.get(position).getName().charAt(i);
            if (this.deps.get(position).getName().charAt(i) == '\\') {
                break;
            }
        }
        Department dep = new Department(name);
        if (!this.deps.contains(dep)) {
            this.deps.add(position, dep);
        }
    }
}
