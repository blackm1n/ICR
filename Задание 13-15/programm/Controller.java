package programm;

import classes.Counter;

import java.io.IOException;

public class Controller {

    Model m = new Model();
    View v = new View();
    boolean on = true;

    public void start() {
        while(this.on) {
            int n = v.showMenu();
            switch(n) {
                case 1 -> this.addAnimal();
                case 2 -> this.identifyAnimal();
                case 3 -> this.viewCommands();
                case 4 -> this.addCommand();
                case 5 -> this.exit();
            }
        }
    }

    private void addAnimal() {
        try(Counter count = new Counter()) {
            String[] input = v.createAnimal();
            if (input.length >= 3) {
                count.open();
            }
            count.add();
            v.message(m.addAnimal(input));
        }
        catch(Exception e) {
            v.message("Не все поля были заполнены");
        }
    }

    public void identifyAnimal() {
        int n = v.chooseAnimal(m.showUnknownAnimals());
        if (n == 0) {
            return;
        }
        int c = v.identifyAnimal();
        v.message(m.identifyAnimal(n, c));
    }

    private void viewCommands() {
        int n = v.chooseAnimal(m.showAnimals());
        if (n == 0) {
            return;
        }
        v.message(m.showCommands(n));
    }

    private void addCommand() {
        int n = v.chooseAnimal(m.showAnimals());
        if (n == 0) {
            return;
        }
        String c = v.getCommand();
        v.message(m.addCommand(n, c));
    }

    private void exit() {
        this.on = false;
    }
}
