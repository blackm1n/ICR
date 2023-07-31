package classes;

import java.util.ArrayList;
import java.util.Date;

public class Horse extends PackAnimal{

    public Horse(String name, ArrayList<String> commands, Date dob) {
        super(name, commands, dob);
    }

    @Override
    public String info() {
        return String.format("Лошадь %s - %d-%d-%d", name, dob.getYear(), dob.getMonth(), dob.getDate());
    }

    @Override
    public void addCommand(String c){
        this.commands.add(c);
    }
}
