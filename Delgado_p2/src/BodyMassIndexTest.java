import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {

    @org.junit.jupiter.api.Test
    void bmiScore() {
        BodyMassIndex test = new BodyMassIndex(72,150);

        assertEquals(20.341435185185187, test.bmiScore());
    }

    @org.junit.jupiter.api.Test
    void underweight() {
        BodyMassIndex test = new BodyMassIndex(72,100);

        assertEquals("Underweight", test.bmiCategory());
    }

    @org.junit.jupiter.api.Test
    void normalweight() {
        BodyMassIndex test = new BodyMassIndex(72,150);

        assertEquals("Normal weight", test.bmiCategory());
    }

    @org.junit.jupiter.api.Test
    void overweight() {
        BodyMassIndex test = new BodyMassIndex(72,200);

        assertEquals("Overweight", test.bmiCategory());
    }

    @org.junit.jupiter.api.Test
    void obesity() {
        BodyMassIndex test = new BodyMassIndex(72,300);

        assertEquals("Obesity", test.bmiCategory());
    }

}
