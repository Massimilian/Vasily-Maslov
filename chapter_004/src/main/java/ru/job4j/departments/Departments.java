package ru.job4j.departments;

import java.util.ArrayList;
import java.util.Comparator;

public class Departments {
    private ArrayList<Department> deps = new ArrayList<>();

    public Departments(ArrayList<Department> deps) {
        this.deps = deps;
    }

    public ArrayList<Department> getDeps() {
        return deps;
    }

    // сортировка по возрастанию
    public void sorting() {
        // готовим сортировку
        this.deps.sort(new Comparator<Department>() {
            @Override
            public int compare(Department o1, Department o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        this.makeList();
    }

    //сортировка по убыванию
    public void backSorting() {
        // удаляем головные департаменты для правильной сортировки
        for (int i = 0; i < deps.size(); i++) {
            if (!deps.get(i).getName().contains("\\")) {
                deps.remove(i);
            }
        }
        // готовим сортировку
        this.deps.sort(new Comparator<Department>() {
            @Override
            public int compare(Department o1, Department o2) {
                return o2.getName().compareTo(o1.getName());
            }
        });
        this.makeList();
    }

    // вставляем головные департаменты
    private void makeList() {
        for (int i = 0; i < deps.size(); i++) {
            StringBuilder name = new StringBuilder();
            for (int j = 0; j < this.deps.get(i).getName().length(); j++) {
                if (this.deps.get(i).getName().charAt(j) == '\\') {
                    break;
                }
                name.append(this.deps.get(i).getName().charAt(j));
            }
            Department dep = new Department(name.toString());
            if (!this.container(dep.getName())) {
                this.deps.add(i, dep);
            }
        }
    }

    // проверяем целесообразность вставки головного департамента
    private boolean container(String name) {
        boolean result = false;
        for (Department department : this.deps) {
            if (department.getName().equals(name)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
