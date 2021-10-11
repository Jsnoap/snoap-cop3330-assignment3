/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jordan Snoap
 */

package ex46;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;



public class AppTest 
{
    @Test
    public void checkProperWordsList() throws IOException
    {
        ArrayList<String> words = new ArrayList<>();
        words.add("badger");
        words.add("mushroom");
        words.add("snake");

        assertEquals(words, App.countWordOccurences());
    }

    @Test
    public void checkHashMapCreation()
    {
        HashMap<String, Integer> wordsAndCount = new HashMap<>();
        wordsAndCount.put("snake", 1);
        wordsAndCount.put("mushroom", 2);
        wordsAndCount.put("badger", 7);

        ArrayList<String> words = new ArrayList<>();
        words.add("badger");
        words.add("mushroom");
        words.add("snake");

        ArrayList<Integer> count = new ArrayList<>();
        count.add(7);
        count.add(2);
        count.add(1);

        assertEquals(wordsAndCount, App.createHashMap(words, count));
    }

    @Test
    public void checkSortAndPrint()
    {
        HashMap<String, Integer> wordsAndCount = new HashMap<>();
        wordsAndCount.put("snake", 1);
        wordsAndCount.put("mushroom", 2);
        wordsAndCount.put("badger", 7);

        assertEquals("badger:   *******\n" + "mushroom: **\n" + "snake:    *\n", App.sortAndPrintHashMap(wordsAndCount));
    }
    @Test
    public void checkPrintStars()
    {
        assertEquals("*****",App.printStars(5));
        assertEquals("",App.printStars(0));
        assertEquals("**********",App.printStars(10));
    }
}
