package test.site.kason.ksh;

import org.apache.commons.cli.ParseException;
import org.junit.Assert;
import org.junit.Test;
import site.kason.ksh.CliOptions;

public class CliOptionsTest {

    @Test
    public void test() throws ParseException {
        CliOptions options = new CliOptions()
            .add("h","help",false,"print help message")
            .add("p","path",true,"specify path");
        String help = options.format("CliOptionTest [options]","CliOption Test","Good luck!");
        //System.out.printf(help);
        Assert.assertEquals("usage: CliOptionTest [options]\n" +
                "CliOption Test\n" +
                " -h,--help         print help message\n" +
                " -p,--path <arg>   specify path\n" +
                "Good luck!\n",help.replace("\r\n","\n"));
        CliOptions.ParseResult result = options.parse(new String[]{"--help", "-p", "test","hello"});
        Assert.assertTrue(result.hasOption("h"));
        Assert.assertTrue(result.hasOption("help"));
        Assert.assertTrue(result.hasOption("p"));
        Assert.assertEquals("test",result.getOptionValue("path"));
        Assert.assertTrue(result.hasArgument(0));
        Assert.assertFalse(result.hasArgument(1));
        Assert.assertEquals("hello",result.getArgument(0));
    }

}
