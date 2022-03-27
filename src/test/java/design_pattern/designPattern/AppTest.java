package design_pattern.designPattern;

import java.util.Currency;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.apache.catalina.connector.RequestFacade;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	Currency cur = null;
    	Integer i = 0;
    	String str = null;
    	RequestFacade facade = new RequestFacade(null);
        assertTrue( true );
    }
}
