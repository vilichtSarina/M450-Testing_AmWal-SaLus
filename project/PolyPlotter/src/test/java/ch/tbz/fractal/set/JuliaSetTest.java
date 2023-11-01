package ch.tbz.fractal.set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JuliaSetTest {

    // Using this julia set, since those starting coordinates are the only ones used
    // within this application. Therefore, since usage is indefinitely one-sided, the unit tests can be made
    // working with fixated test cases.
    // To to the requirements of the application, no further testing is needed.
    private static JuliaSet juliaSet;

    @BeforeAll
    public static void init() {
        juliaSet = new JuliaSet(800, 800, 1.0, 70, -0.5, 0.6);
    }

    @Test
    public void testCalcJuliaSet_CoordinatesOutsideOfSetReturnBelowMaxIterations() {
        int outOfScopeYaxisValue = 100;
        int outOfScopeXaxisValue = -34;

        // Points are so far out of scope for the julia set that it can be determined within the first iteration
        // that the point is not part of the set.
        assertEquals(juliaSet.calcJuliaSet(outOfScopeXaxisValue, outOfScopeYaxisValue), 1);
    }

    @Test
    public void testCalcJuliaSet_CoordinatesWithinSetReturnsMaxIterations() {
        // Center point of the complex plane (given the Julia sets starting coordinates) indefinitely belongs to the
        // set, can therefore be used for testing.
        int inScopeYaxisValue = 0;
        int inScopeXaxisValue = 0;

        assertEquals(juliaSet.calcJuliaSet(inScopeXaxisValue, inScopeYaxisValue), juliaSet.getMaxIteration());
    }
}
