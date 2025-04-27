/**
 * Nothing strange, just Easter bunny
 */
public class EasterBunny {
    /** Bunny's name */
    private final String name;

    /** All args constructor - nothing interesting */
    public EasterBunny(String name) {
        this.name = name;
    }

    /**
     * Bunny creates an egg
     * @param weight the weight of egg
     * @return Easter egg object
     */
    public EasterEgg produce(int weight) {
        return new EasterEgg(this, weight);
    }

    /** Bunny wants to greet you */
    public String sayHi() {
        return "Hi, I'm " + name;
    }
}
