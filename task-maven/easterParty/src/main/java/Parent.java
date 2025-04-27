import java.util.List;

/**
 * Old people that have children
 */
public class Parent {
    /** Small humans */
    private final List<Child> children;
    /** Secret friend of all parents */
    private final EasterBunny friendBunny;

    /** All args constructor - nothing interesting */
    public Parent(List<Child> children, EasterBunny friendBunny) {
        this.children = children;
        this.friendBunny = friendBunny;
    }

    /**
     * Happy child - happy parent
     * @throws EasterFailException child is not happy 0_0
     */
    public void celebrateEaster() throws EasterFailException {
        for (Child child : children) {
            EasterEgg present = friendBunny.produce(11);
            child.makeHappy(present);
        }
    }
}
