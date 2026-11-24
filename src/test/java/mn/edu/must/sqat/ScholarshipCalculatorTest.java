package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScholarshipCalculatorTest {

    private final ScholarshipCalculator calculator =
            new ScholarshipCalculator();

    // Part A: Happy path tests

    @Test
    void letterGradeReturnsA() {
        assertEquals("A", calculator.letterGrade(95));
    }

    @Test
    void letterGradeReturnsC() {
        assertEquals("C", calculator.letterGrade(75));
    }

    @Test
    void gpaReturnsAverage() {
        assertEquals(
                3.5,
                calculator.gpa(new double[]{95, 85}),
                0.0001
        );
    }

    @Test
    void scholarshipReturns100Percent() {
        assertEquals(
                100,
                calculator.scholarship(3.9, 16, false)
        );
    }

    @Test
    void scholarshipReturns70Percent() {
        assertEquals(
                70,
                calculator.scholarship(3.6, 13, false)
        );
    }
}
