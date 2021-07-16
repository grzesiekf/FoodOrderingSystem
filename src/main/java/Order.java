import java.util.ArrayList;

public class Order {
    private ArrayList<Food> order;
    private float bill;

    public Order() {
        order = new ArrayList<Food>();
        bill = 0.0f;
    }

    public void addOrder(Food food) {
        order.add(food);
        bill = bill + food.getPrise();
    }

    public void deleteOrder(Food food) {
        order.remove(food);
        bill = bill - food.getPrise();
    }

    public float getBill() {
        return bill;
    }

    public void printOrder() {
        System.out.println("Twoje zamówienie: ");
        for(int i=0;i<order.size();i++)
        {
            System.out.println(i+" "+order.get(i).toString());
        }
        System.out.println("\n Kwota do zapłaty: "+ bill);

    }


}
