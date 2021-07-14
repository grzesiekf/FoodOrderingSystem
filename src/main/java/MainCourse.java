public class MainCourse extends Food {
    public final Cuisine cuisine;

    public MainCourse(String name, float prise, Cuisine cuisine) {
        super(name, prise);
        this.cuisine = cuisine;
    }

}
