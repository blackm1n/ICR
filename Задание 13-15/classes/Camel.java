package classes;

import java.util.ArrayList;
import java.util.Date;

public class Camel extends PackAnimal{

    public Camel(String name, ArrayList<String> commands, Date dob) {
        super(name, commands, dob);
    }

    @Override
    public String info() {
        return String.format("Верблюд %s - %d-%d-%d", name, dob.getYear(), dob.getMonth(), dob.getDate());
    }

    @Override
    public void addCommand(String c){
        this.commands.add(c);
    }
}
