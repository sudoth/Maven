public class Child {
    /** To be happy or not to be */
    private boolean isHappy = false;
    /** All humans have names */
    private final String name;

    /** Constructor */
    public Child(String name) {
        this.name = name;
    }

    /** Ask child */
    public boolean isHappy() {
        return isHappy;
    }

    /**
     * Just give children some sweets and they will be happy
     * @param egg  everyone loves chocolate
     * @throws EasterFailException  egg has already been eaten, poor child is crying =(
     */
    public void makeHappy(EasterEgg egg) throws EasterFailException {
        if (egg.isEaten()) {
            throw new EasterFailException(name + " is crying =(");
        }

        isHappy = true;
        egg.eat();
    }
}
