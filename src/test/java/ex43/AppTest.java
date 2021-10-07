/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jordan Snoap
 */

package ex43;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void checkDirectoriesCreated() throws IOException
    {
        assertTrue(String.valueOf(true), App.createDirectories("coolWebsite", 'n', 'n', "Jordan"));
    }

    // Other two methods simply print or create a file
}
