import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    private Animal animal;

    @Test
    public void testAnimalGetAge() {
        animal = new Animal("Kojootti", 6);

        int expected = 6;
        int actual = animal.getAge();

        assertEquals(expected, actual);
    }

    @Test
    public void testAnimalGetName() {
        animal = new Animal("Kojootti", 6);

        String expected = "Kojootti";
        String actual = animal.getName();

        assertEquals(expected, actual);
    }

    @Test
    public void testAnimalShout() {
        animal = new Animal("Kojootti", 6);

        String expected = "<default shout>";
        String actual = animal.shout();

        assertEquals(expected, actual);
    }

    @Test
    public void testAnimalInvalidAge() {
        animal = new Animal("Kojootti", -6);

        int expected = 0;
        int actual = animal.getAge();

        assertEquals(expected, actual);
    }

    @Test
    public void testAnimalInvalidName() {
        animal = new Animal(null, 6);

        String expected = "Undefined";
        String actual = animal.getName();

        assertEquals(expected, actual);
    }
}
