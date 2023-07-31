package classes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class Animal {

    String name;
    ArrayList<String> commands;
    Date dob;

    public Animal(String name, ArrayList<String> commands, Date dob) {
        this.name = name;
        this.commands = commands;
        this.dob = dob;
    }

    public String info() {
        return String.format("%s - %d-%d-%d", name, dob.getYear(), dob.getMonth(), dob.getDate());
    }

    public String[] getCommands() {
        return this.commands.toArray(new String[commands.size()]);
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<String> getArrayCommands() {
        return this.commands;
    }

    public Date getDob() {
        return this.dob;
    }

    public void addCommand(String c) throws UnknownAnimal {
        throw new UnknownAnimal("Неопределенное животное");
    }
}
