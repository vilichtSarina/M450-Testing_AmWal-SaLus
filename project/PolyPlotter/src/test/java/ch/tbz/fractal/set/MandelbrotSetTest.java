package ch.tbz.fractal.set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MandelbrotSetTest {

    private MandelbrotSet mandelBrot;


    @BeforeEach
    public void init() {
        mandelBrot = new MandelbrotSet(800, 800, 1.0, 100);
    }

    @Test
    public void testCalcSet_WithCoordinatesNotInSet() {
        int outOfScopeYaxisValue = 10;
        int inScopeXaxisValue = 0;

        // Given coordinates are so far off of the set that it will take one iteration for
        // the point to be rules out of the mandelbrot set.
        assertEquals(mandelBrot.calcSet(inScopeXaxisValue, outOfScopeYaxisValue), 1);
    }

    @Test
    public void testCalcSet_ValidCoordinatesReturnMaxIterations() {
        // coordinates (0/0) are indeinitely part of the set. As a result calcSet only terminates when
        // the number of iterations has reached maxIterations.
        int inScopeYaxisValue = 0;
        int inScopeXaxisValue = 0;

        assertEquals(mandelBrot.calcSet(inScopeXaxisValue, inScopeYaxisValue), mandelBrot.getMaxIteration());
    }
}
