import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class EasterEggTests {
    static EasterBunny bunny;
    static EasterBunny otherBunny;

    @BeforeAll
    static void init() {
        bunny = new EasterBunny("George");
        otherBunny = new EasterBunny("Peter");
    }

    @Test
    void creationTest() {
        EasterEgg egg = bunny.produce(30);
        Assertions.assertEquals(egg.getWeight(), 30d);
        Assertions.assertEquals(egg.getProducer(), bunny);
    }

    @Test
    void eggsStressTest() {
        IntStream.range(0, 1_000_000).parallel().forEach((iter) -> {
            EasterEgg egg = bunny.produce(iter);
            Assertions.assertEquals(egg.getWeight(), iter);
        });
    }

    @Test
    void eatingTest() {
        EasterEgg egg = bunny.produce(11);
        Assertions.assertFalse(egg.isEaten());
        egg.eat();
        Assertions.assertTrue(egg.isEaten());
    }

    @Test
    void superStressTest() {
        IntStream.range(0, 1_234_567).parallel().forEach((iter) -> {
            EasterEgg egg = ((iter & 1) == 0) ? bunny.produce(iter) : otherBunny.produce(iter >> 1);
            Assertions.assertFalse(egg.isEaten());
            Assertions.assertEquals(egg.getWeight(), ((iter & 1) == 0) ? iter : iter >> 1);
            Assertions.assertEquals(egg.getProducer(), ((iter & 1) == 0) ? bunny : otherBunny);
            egg.eat();
            Assertions.assertTrue(egg.isEaten());
        });
    }
}
