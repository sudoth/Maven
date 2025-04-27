import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EasterBunnyTests {
    @Test
    void greetingTest() {
        EasterBunny bunny = new EasterBunny("George");
        Assertions.assertEquals("Hi, I'm George", bunny.sayHi());
    }
}
