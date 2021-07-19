package grzesiekf.eatables;

public abstract class Food {
    private final String name;
    private final float prise;

    public Food(String name, float prise) {
        this.name = name;
        this.prise = prise;
    }

    public String getName() {
        return name;
    }

    public float getPrise() {
        return prise;
    }

    @Override
    public String toString() {
        return String.format("%1$-35s", name) + String.format("%15.2f", prise);
    }


}
