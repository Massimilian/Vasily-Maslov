package ru.job4j.departments;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Departments {
    private ArrayList<Department> deps = new ArrayList<>();

    public Departments(ArrayList<Department> deps) {
        this.deps = deps;
    }

    public ArrayList<Department> getDeps() {
        return deps;
    }

    // сортировка по возрастанию
    public ArrayList<String> sorting() {
        ArrayList<String> names = getNames();
        // готовим сортировку
        names.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        names = this.makeList(names);
        return names;
    }

    //сортировка по убыванию
    public ArrayList<String> backSorting() {
        ArrayList<String> names = getNames();
        // удаляем головные департаменты для правильной сортировки
        for (int i = 0; i < names.size(); i++) {
            if (!names.get(i).contains("\\")) {
                names.remove(i);
            }
        }
        // готовим сортировку
        names.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        names = this.makeList(names);
        return names;
    }

    // вставляем головные департаменты
    private ArrayList<String> makeList(ArrayList<String> names) {
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).contains("\\")) {
                String headName = "";
                for (int j = 0; j < names.get(i).length(); j++) {
                    if (names.get(i).charAt(j) != '\\') {
                        headName += names.get(i).charAt(j);
                    } else {
                        if (!names.contains(headName)) {
                            names.add(i, headName);
                            i++;
                        }
                        break;
                    }
                }
            }
        }
        return names;
    }

    // проверяем целесообразность вставки головного департамента
    private boolean container(String name, ArrayList<String> names) {
        return names.contains(name);
    }

    private ArrayList<String> getNames() {
        ArrayList<String> result = new ArrayList<>(deps.size());
        Iterator<Department> depsIt = deps.iterator();
        while (depsIt.hasNext()) {
            result.add(depsIt.next().getName());
        }
        return result;
    }
}
