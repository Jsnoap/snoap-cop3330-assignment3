/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jordan Snoap
 */

package ex45;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    // promptAnCreateOutputFile() scans for a name for a file and creates empty file.
    @Test
    public void testFileIsReturned() throws IOException
    {
        File test = new File("src/test/java/ex45/test.txt");
        // Test that file is returned
        assertNotNull(App.changeUtilizeToUse(test));
    }
}
