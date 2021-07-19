package grzesiekf.applicationModel;
import grzesiekf.eatables.Dessert;
import org.junit.Assert;


public class TestOrder {

    @org.junit.Test
    public void testAddOrder() {
        Order order= new Order();
        order.addOrder(new Dessert("TEST",1.0f));
        Assert.assertEquals(1, order.getSize());
    }
    @org.junit.Test
    public void testDeleteOrder() {
        Order order= new Order();
        order.addOrder(new Dessert("TEST",1.0f));
        order.deleteOrder(0);
        Assert.assertEquals(0, order.getSize());
    }
    @org.junit.Test
    public void testGetSize() {
        Order order= new Order();
        order.addOrder(new Dessert("TEST",1.0f));
        order.addOrder(new Dessert("TEST",1.0f));
        order.addOrder(new Dessert("TEST",1.0f));
        Assert.assertEquals(3, order.getSize());
    }


}
