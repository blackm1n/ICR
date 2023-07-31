package programm;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class View {

    public int showMenu() {
        System.out.println(this.separate());
        System.out.println("Выберете необходимое действие");
        System.out.println("1. Завести новое животное");
        System.out.println("2. Определить животного");
        System.out.println("3. Вывести список команд животного");
        System.out.println("4. Добавить новую команду животному");
        System.out.println("5. Закончить работу");
        return this.getInt("Введите номер необходимого действия: ");
    }

    public String[] createAnimal() {
        System.out.println(this.separate());
        ArrayList<String> info = new ArrayList<>();
        info.add(this.getString("Введите имя животного: "));
        info.add(this.getString("Введите команды животного через запятую: "));
        info.add(this.getDate("Введите дату рождения животного в формате YYYY-MM-DD: "));
        return info.toArray(new String[info.size()]);
    }

    public int chooseAnimal(String[] animals) {
        if (animals == null) {
            System.out.println(this.separate());
            System.out.println("Нету подходящих животных.");
            return 0;
        }
        int res;
        do {
            System.out.println(this.separate());
            for (int i = 0; i < animals.length; i++) {
                System.out.printf("%d. %s\n", i + 1, animals[i]);
            }
            res = this.getInt("Введите номер животного: ");
        } while (res < 1 || res > animals.length);
        return res;
    }

    public int identifyAnimal() {
        System.out.println(this.separate());
        System.out.println("1. Домашнее животное");
        System.out.println("2. Вьючное животное");
        int type = this.getInt("Введите тип животного: ");
        if (type == 1) {
            System.out.println("1. Кот/Кошка");
            System.out.println("2. Собака");
            System.out.println("3. Хомяк");
        }
        else {
            System.out.println("1. Лошадь");
            System.out.println("2. Верблюд");
            System.out.println("3. Осел");
        }
        int animal = this.getInt("Введите животное: ");
        return animal + (3 * (type - 1));
    }

    public String getCommand() {
        System.out.println(this.separate());
        return getString("Введите новую команду животного: ");
    }

    private int getInt(String mes) {
        boolean caught;
        int res = 0;
        do {
            System.out.print(mes);
            Scanner in = new Scanner(System.in);
            try {
                res = in.nextInt();
                caught = false;
            }
            catch(Exception e) {
                System.out.println("Что-то пошло не так. Повторите попытку.");
                caught = true;
            }
        } while (caught);
        return res;
    }

    private String getString(String mes) {
        Scanner in = new Scanner(System.in);
        System.out.print(mes);
        return in.nextLine();
    }

    private String getDate(String mes) {
        boolean caught;
        String res = "";
        do {
            System.out.print(mes);
            Scanner in = new Scanner(System.in);
            try {
                res = in.nextLine();
                LocalDate.parse(res);
                caught = false;
            }
            catch(Exception e) {
                System.out.println("Что-то пошло не так. Повторите попытку.");
                caught = true;
            }
        } while(caught);
        return res;
    }

    public void message(String mes) {
        System.out.println(this.separate());
        System.out.println(mes);
        this.pause("Нажмите ENTER для продолжения...");
    }

    private void pause(String mes) {
        Scanner in = new Scanner(System.in);
        System.out.print(mes);
        in.nextLine();
    }

    private String separate() {
        return "=".repeat(20);
    }
}
