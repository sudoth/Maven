/**
 * Tasty Easter eggs
 */
public class EasterEgg {
    /** To be eaten or not to be? */
    private boolean isEaten;
    /** Which bunny has made this egg */
    private final EasterBunny producer;
    /** Egg's weight */
    private final double weight;

    /** All args constructor - nothing interesting */
    public EasterEgg(EasterBunny producer, double weight) {
        this.producer = producer;
        this.weight = weight;
        this.isEaten = false;
    }

    /**
     * Getter
     * @return bunny which has made this egg
     */
    public EasterBunny getProducer() {
        return producer;
    }

    /**
     * Another getter
     * @return egg's weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Getter, but not getter =)
     * @return current state of egg
     */
    public boolean isEaten() {
        return isEaten;
    }

    /**
     * Oops, someone is going to eat it
     */
    public void eat() {
        isEaten = true;
    }
}
