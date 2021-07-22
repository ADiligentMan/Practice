package problem.solution;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class RegularExpressionMatchingTest {
    RegularExpressionMatching instance = new RegularExpressionMatching();

    @Test
    public void test1() {
        String s = "aaaa";
        String p = ".*";
        boolean match = instance.isMatch(s, p);
        Assert.assertTrue(match);
    }

    @Test
    public void test2() {
        String s = "aaaa";
        String p = "b*";
        boolean match = instance.isMatch(s, p);
        Assert.assertTrue(!match);
    }

    @Test
    public void test3() {
        String s = "ab";
        String p = ".*c";
        boolean match = instance.isMatch(s, p);
        Assert.assertTrue(!match);
    }


    @Test
    public void test4() {
        String s = "aa";
        String p = "a*";
        boolean match = instance.isMatch(s, p);
        Assert.assertTrue(match);
    }

    @Test
    public void test5() {
        String s = "aaa";
        String p = "a*a";
        boolean match = instance.isMatch(s, p);
        Assert.assertTrue(match);
    }


}