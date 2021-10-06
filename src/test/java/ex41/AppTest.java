/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jordan Snoap
 */

package ex41;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.IOException;
import java.util.ArrayList;

public class AppTest 
{
    @Test
    public void checkReadFileIntoList() throws IOException {
        ArrayList<String> namesCheck = new ArrayList<>();

        namesCheck.add("Ling, Mai");
        namesCheck.add("Johnson, Jim");
        namesCheck.add("Zarnecki, Sabrina");
        namesCheck.add("Jones, Chris");
        namesCheck.add("Jones, Aaron");
        namesCheck.add("Swift, Geoffrey");
        namesCheck.add("Xiong, Fong");

        assertEquals(namesCheck, App.readFileIntoList());
    }

    @Test
    public void checkSortNames()
    {
        ArrayList<String> namesCheck = new ArrayList<>();
        ArrayList<String> sortNamesCheck = new ArrayList<>();

        namesCheck.add("Ling, Mai");
        namesCheck.add("Johnson, Jim");
        namesCheck.add("Zarnecki, Sabrina");
        namesCheck.add("Jones, Chris");
        namesCheck.add("Jones, Aaron");
        namesCheck.add("Swift, Geoffrey");
        namesCheck.add("Xiong, Fong");

        sortNamesCheck.add("Johnson, Jim");
        sortNamesCheck.add("Jones, Aaron");
        sortNamesCheck.add("Jones, Chris");
        sortNamesCheck.add("Ling, Mai");
        sortNamesCheck.add("Swift, Geoffrey");
        sortNamesCheck.add("Xiong, Fong");
        sortNamesCheck.add("Zarnecki, Sabrina");

        assertEquals(sortNamesCheck, App.sortNames(namesCheck));
    }
}
