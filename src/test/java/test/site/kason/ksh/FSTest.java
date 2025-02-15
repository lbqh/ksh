package test.site.kason.ksh;

import org.junit.Assert;
import org.junit.Test;
import site.kason.ksh.FS;

public class FSTest {

    @Test
    public void testWildcardMatch() {
        Assert.assertTrue(FS.wildcardMatch("hello.kls","*.kls"));
        Assert.assertTrue(FS.wildcardMatch("hello.kls","he??o.kls"));
        Assert.assertFalse(FS.wildcardMatch("test.kls","*.java"));
    }

}
