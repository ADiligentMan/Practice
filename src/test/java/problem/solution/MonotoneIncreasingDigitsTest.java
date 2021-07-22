package problem.solution;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class MonotoneIncreasingDigitsTest {
    private MonotoneIncreasingDigits starter = new MonotoneIncreasingDigits();

    @Before
    public void init() {
        this.starter = new MonotoneIncreasingDigits();
    }

    @Test
    public void test1() {
        testing(1234, 1234);
    }


    @Test
    public void test2() {
        testing(332, 299);
    }

    @Test
    void test3() {
        testing(10, 9);
    }

    private void testing(int input, int expect) {
        int actual = starter.monotoneIncreasingDigits(input);
        Assert.assertEquals(expect, actual);
    }

}