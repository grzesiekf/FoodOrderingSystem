package grzesiekf.eatables;

public class MainCourse extends Food {
    public final String cuisine;

    public MainCourse(String name, float prise, String cuisine) {
        super(name, prise);
        this.cuisine = cuisine;
    }

}
