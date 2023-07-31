package programm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import classes.*;

public class Model {

    ArrayList<Animal> animals = new ArrayList<>();

    public String addAnimal(String[] info) {
        String name = info[0];
        ArrayList<String> commands = new ArrayList<>(Arrays.asList(info[1].split(", ")));
        String[] nums = info[2].split("-");
        Integer[] date = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            date[i] = Integer.parseInt(nums[i]);
        }
        Date dob = new Date(date[0], date[1], date[2]);
        animals.add(new Animal(name, commands, dob));
        return "Добавление успешно";
    }

    public String[] showAnimals() {
        ArrayList<String> res = new ArrayList<>();
        for (Animal a : animals) {
            res.add(a.info());
        }
        if (res.size() == 0) {
            return null;
        }
        return res.toArray(new String[res.size()]);
    }

    public String[] showUnknownAnimals() {
        ArrayList<String> res = new ArrayList<>();
        for (Animal a : animals) {
            if (a.getClass() == Animal.class) {
                res.add(a.info());
            }
        }
        if (res.size() == 0) {
            return null;
        }
        return res.toArray(new String[res.size()]);
    }

    public String identifyAnimal(int n, int c) {
        Animal a = this.getUnknownAnimal(n);
        this.animals.remove(a);
        switch(c) {
            case 1 -> this.animals.add(new Cat(a.getName(), a.getArrayCommands(), a.getDob()));
            case 2 -> this.animals.add(new Dog(a.getName(), a.getArrayCommands(), a.getDob()));
            case 3 -> this.animals.add(new Hamster(a.getName(), a.getArrayCommands(), a.getDob()));
            case 4 -> this.animals.add(new Horse(a.getName(), a.getArrayCommands(), a.getDob()));
            case 5 -> this.animals.add(new Camel(a.getName(), a.getArrayCommands(), a.getDob()));
            case 6 -> this.animals.add(new Donkey(a.getName(), a.getArrayCommands(), a.getDob()));
        }
        return "Определение успешно";
    }

    public Animal getUnknownAnimal(int n) {
        int i = 0;
        for (Animal a : this.animals) {
            if (a.getClass() == Animal.class) {
                i++;
            }
            if (n == i) {
                return a;
            }
        }
        return null;
    }

    public String showCommands(int n) {
        StringBuilder res = new StringBuilder();
        String[] commands = animals.get(n - 1).getCommands();
        for (String c : commands) {
            res.append(c);
            res.append("\n");
        }
        return res.toString();
    }

    public String addCommand(int n, String c) {
        try {
            animals.get(n - 1).addCommand(c);
        }
        catch(UnknownAnimal e) {
            return "Нельзя добавить команду неопределенному животному";
        }
        return "Добавление успешно";
    }
}
