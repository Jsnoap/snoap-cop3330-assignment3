/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jordan Snoap
 */

// MUST INCLUDE PSEUDOCODE AS COMMENTS

// DON'T FORGET TEST CASES AND PLANTUML CLASS DIAGRAM

/* PSUEDOCODE General Idea:
Start by reading the input file and creating lists of the words in it and their occurrences.
Add these two lists to a HashMap so that the amount of occurrences is tagged to the respective word.
From here, sort the HashMap with the integer value.
Create a separate method to print the amount of stars depending on the integer value.
Print output text (with proper spacing) to the system.
 */

package ex46;


import java.io.*;
import java.util.*;

public class App
{
    // Begins calling the first method to count words and occurences
    public static void main( String[] args ) throws IOException
    {
        countWordOccurences();
    }

    // Method runs through the input file and creates two ArrayLists of the words and their occurrences
    // Passes these ArrayLists into method to create a HashMap from them
    public static ArrayList<String> countWordOccurences() throws IOException
    {
        File inputFile = new File("src/main/java/ex46/exercise46_input.txt");
        Scanner input = new Scanner(inputFile);
        String fileWord;
        int i;
        // Create word list and count list to store the words in the file
        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();

        while(input.hasNext())
        {
            fileWord = input.next();

            if(words.contains(fileWord))
            {
                // Gets the index of the word in the "words" list
                i = words.indexOf(fileWord);
                count.set(i, count.get(i) + 1);
            }
            else
            {
                words.add(fileWord);
                count.add(1);
            }
        }

        createHashMap(words, count);

        return words;
    }

    // Creates HashMap to link the words to their occurrences
    public static HashMap<String, Integer> createHashMap(ArrayList<String> wordsInFile, ArrayList<Integer> occurences)
    {
        HashMap<String, Integer> mapWordtoCount = new HashMap<>();
        int i;

        for (i = 0; i < wordsInFile.size(); i++)
        {
            mapWordtoCount.put(wordsInFile.get(i), occurences.get(i));
        }

        sortAndPrintHashMap(mapWordtoCount);

        return mapWordtoCount;
    }

    // Takes in the HashMap and sorts the values so that the largest one prints first.
    // It calls the "printStars" function as well to get the correct number of stars printed
    public static String sortAndPrintHashMap(HashMap<String, Integer> mapOfFileWords)
    {
        Object[] a = mapOfFileWords.entrySet().toArray();
        StringBuilder output = new StringBuilder();


        // Looked into Comparators to help sort a HashMap
        Arrays.sort(a, new Comparator()
        {
            public int compare(Object o1, Object o2)
            {
                return ((Map.Entry<String, Integer>) o2).getValue()
                        .compareTo(((Map.Entry<String, Integer>) o1).getValue());
            }
        });
        for (Object e : a)
        {
            output.append(String.format("%-10s", (((Map.Entry<String, Integer>) e).getKey()) + ": ")).append(printStars(((Map.Entry<String, Integer>) e).getValue())).append("\n");
        }

        System.out.println(output);

        return output.toString();
    }

    // Prints the amount of stars depending on the integer passed in
    public static String printStars(int numStars)
    {
        StringBuilder stars = new StringBuilder();
        int i;

        for(i = 0; i < numStars; i++)
        {
            stars.append("*");
        }

        return stars.toString();
    }
}
