/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jordan Snoap
 */

package ex43;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

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
        assertEquals("src/main/java/ex43/website/coolWebsite", App.createDirectories("coolWebsite", 'n', 'n', "Jordan"));
    }

    @Test
    public void checkDirectoryIndexHTML() throws IOException
    {
        assertEquals("src/main/java/ex43/website/coolWebsite/index.html", App.createIndexHTML("src/main/java/ex43/website/coolWebsite", "coolWebsite", "jordan"));
    }

    // Other method simply prints
}
