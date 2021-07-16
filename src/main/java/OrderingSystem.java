import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;

public class OrderingSystem {

    private ArrayList<Drink> drinks;
    private ArrayList<MainCourse> maincourses;
    private ArrayList<Dessert> desserts;
    private ArrayList<String> cuisines;
    Order order;

    public OrderingSystem() {
        order = new Order();
        drinks = new ArrayList<Drink>();
        maincourses = new ArrayList<MainCourse>();
        desserts = new ArrayList<Dessert>();
        cuisines = new ArrayList<String>();
    }

    public void init() {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/drinks.txt"));
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                String[] drink = temp.split("/");
                drinks.add(new Drink(drink[0], Float.parseFloat(drink[1])));
            }

        } catch (Exception ex) {
            System.out.println("Błąd wczytywania danych");
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/desserts.txt"));
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                String[] dessert = temp.split("/");
                desserts.add(new Dessert(dessert[0], Float.parseFloat(dessert[1])));
            }
        } catch (Exception ex) {
            System.out.println("Błąd wczytywania danych");
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/maincourses.txt"));
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                String[] maincourse = temp.split("/");
                maincourses.add(new MainCourse(maincourse[0], Float.parseFloat(maincourse[1]), maincourse[2]));
            }
        } catch (Exception ex) {
            System.out.println("Błąd wczytywania danych");
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/cuisine.txt"));
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                cuisines.add(temp);
            }

        } catch (Exception ex) {
            System.out.println("Błąd wczytywania danych");
        }

    }

    public void start() {
        boolean work = true;
        int choose;
        Scanner scanner = new Scanner(in);


        while (work) {
            System.out.println("Restauracja XYZ");
            System.out.println("Elektroniczny system składania zamówień");
            System.out.println("wprowadź numer 1-5 i zatwierdź klawiszem enter");
            System.out.println("1 Wyświetl MENU");
            System.out.println("2 Dodaj lunch");
            System.out.println("3 Dodaj napój");
            System.out.println("4 Wyświetl i edytuj zamówienie");
            System.out.println("5 Zatwierdz zamówienie i wyjdź");

            try {
                choose = Integer.parseInt(scanner.nextLine());
            } catch (Exception ex) {
                choose = 6;
            }

            switch (choose) {
                case 1:
                    printMenu();
                    break;
                case 2:
                    chooseLunch();
                    break;
                case 3:
                    chooseDrink();
                    break;
                case 4:
                    printOrEditOrder();
                    break;
                case 5:
                    work = confirmAndExit();
                    break;
                default:
                    System.out.println(" \n BŁĄD - Wprowadź cyfrę z zakresu 1-5 \n ");

            }
        }
    }

    private void printMenu() {
        System.out.println("\n-----------------------MENU-----------------------");
        System.out.println(" \n NAPOJE: \n");
        for (Drink drink : drinks) {
            System.out.println(drink.toString());
        }
        System.out.println(" \n DESERY: \n");
        for (Dessert dessert : desserts) {
            System.out.println(dessert.toString());
        }
        System.out.println("\n DANIA GŁÓWNE: \n");
        for (MainCourse mainCourse : maincourses) {
            System.out.println(mainCourse.toString());
        }
        System.out.println("\n-------------------------------------------------- \n");

        System.out.println("Naciśnij ENTER aby kontynuować");
        try {
            System.in.read();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void chooseLunch() {


    }

    private void chooseDrink() {
        System.out.println("wybierz napój z listy: ");
        for (int i=0;i<drinks.size();i++) {
            System.out.println(i+" "+drinks.get(i).toString());
        }


    }

    private void printOrEditOrder() {
        int choose;
        Scanner scanner = new Scanner(in);
        order.printOrder();
        System.out.println("\n1 Usuń pozycje");
        System.out.println("2 Wróć");
        try {
            choose = Integer.parseInt(scanner.nextLine());
        } catch (Exception ex) {
            choose = 2;
        }
        if (choose==1) {
            System.out.println("Podaj numer pozycji do usunięcia: ");
            try {
                choose = Integer.parseInt(scanner.nextLine());
            } catch (Exception ex) {
                System.out.println("Podano wartość z poza zakresu");
                choose = -1;
            }





        }
        System.out.println("Naciśnij ENTER aby kontynuować");
        try {
            System.in.read();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private boolean confirmAndExit() {
        int choose;
        Scanner scanner = new Scanner(in);

        order.printOrder();
        System.out.println("\nCzy potwierdzić zamówienie?");
        System.out.println("1 TAK");
        System.out.println("2 NIE");
        try {
            choose = Integer.parseInt(scanner.nextLine());
        } catch (Exception ex) {
            choose = 2;
        }
        if(choose==1) {
            System.out.println("Twoje zamówienie zostało przekazane do realizacji. \nDziękujemy i zapraszamy ponownie.");
            System.out.println("\n\nNaciśnij ENTER aby zakończyć");
            try {
                System.in.read();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return false;
        }
        else return true;
    }


}
