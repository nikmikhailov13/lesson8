package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

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

        Computer pc = new Computer(16, 4, "Acer", Computer.OperatingSystem.Windows);

        //shouldOn
        pc.turnOn();
        assertEquals(true, pc.isOn());

        //shouldStartGame
        pc.runMyFavoriteGame();
        assertEquals(true, pc.isFreeze());

        //shouldOff
        pc.shutdown();
        assertEquals(false, pc.isOn());

    }


}
