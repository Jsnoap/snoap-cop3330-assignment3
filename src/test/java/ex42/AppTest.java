/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jordan Snoap
 */

package ex42;


import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertNull;

public class AppTest 
{
    // "createOutputFileWithHeader()" simply just creates output file
    @Test
    public void checkParseThroughWholeFile() throws IOException
    {
        FileWriter outputCheck = new FileWriter("src/main/java/ex42/exercise42_output.txt");
        outputCheck.write("Last      First     Salary\n--------------------------\n");

        // Check that whole file was read through
        assertNull(App.readAndParseFile(outputCheck));
    }
}
