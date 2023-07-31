package classes;

import java.util.ArrayList;
import java.util.Date;

public class Dog extends HomeAnimal{

    public Dog(String name, ArrayList<String> commands, Date dob) {
        super(name, commands, dob);
    }

    @Override
    public String info() {
        return String.format("Собака %s - %d-%d-%d", name, dob.getYear(), dob.getMonth(), dob.getDate());
    }

    @Override
    public void addCommand(String c){
        this.commands.add(c);
    }
}
