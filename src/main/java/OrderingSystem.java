import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class OrderingSystem {

    private ArrayList<Drink> drinks;
    private ArrayList<MainCourse> maincourses;
    private ArrayList<Dessert> desserts;
    private ArrayList<String> cuisines;


    public OrderingSystem() {
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
        while (true) {
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
            System.out.println("\n KUCHNIE: ");
            for (String cuisine : cuisines) {
                System.out.println(cuisine);
            }

            System.out.println("--------------------------------------------------");
            break;
        }
    }

}
