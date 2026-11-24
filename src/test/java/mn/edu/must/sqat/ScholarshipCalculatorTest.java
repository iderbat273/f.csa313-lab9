package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    // Part B: Structural coverage tests

    @Test
    void letterGradeReturnsD() {
        assertEquals("D", calculator.letterGrade(65));
    }

    @Test
    void letterGradeReturnsF() {
        assertEquals("F", calculator.letterGrade(55));
    }

    @Test
    void letterGradeRejectsNegativeScore() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.letterGrade(-1)
        );
    }

    @Test
    void letterGradeRejectsScoreAbove100() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.letterGrade(101)
        );
    }

    @Test
    void gpaCoversRemainingGrades() {
        assertEquals(
                1.0,
                calculator.gpa(new double[]{75, 65, 55}),
                0.0001
        );
    }

    @Test
    void gpaRejectsNullArray() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.gpa(null)
        );
    }

    @Test
    void gpaRejectsEmptyArray() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.gpa(new double[]{})
        );
    }

    @Test
    void scholarshipRejectsNegativeGpa() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.scholarship(-0.1, 16, false)
        );
    }

    @Test
    void scholarshipRejectsGpaAboveFour() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.scholarship(4.1, 16, false)
        );
    }

    @Test
    void scholarshipRejectsNegativeCredits() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.scholarship(3.9, -1, false)
        );
    }

    @Test
    void scholarshipReturnsZeroForViolation() {
        assertEquals(
                0,
                calculator.scholarship(3.9, 16, true)
        );
    }

    @Test
    void scholarshipFallsBackTo70WhenCreditsBelow15() {
        assertEquals(
                70,
                calculator.scholarship(3.9, 14, false)
        );
    }

    @Test
    void scholarshipFallsBackTo50WhenCreditsBelow12() {
        assertEquals(
                50,
                calculator.scholarship(3.6, 11, false)
        );
    }

    @Test
    void scholarshipReturnsZeroForLowGpa() {
        assertEquals(
                0,
                calculator.scholarship(2.9, 16, false)
        );
    }
}
