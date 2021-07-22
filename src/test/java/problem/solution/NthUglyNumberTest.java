package problem.solution;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * TODO describe
 *
 * @author wangpeng
 * @since 2021-04-11
 */
public class NthUglyNumberTest {

    @Test
    public void nthUglyNumber() {
        NthUglyNumber nthUglyNumber = new NthUglyNumber();
        int result = nthUglyNumber.nthUglyNumber(10);
        Assert.assertEquals(12, result);
    }

    @Test
    public void nthUglyNumber1352() {
        NthUglyNumber nthUglyNumber = new NthUglyNumber();
        int result = nthUglyNumber.nthUglyNumber(1352);
        System.out.println(result);
    }
}