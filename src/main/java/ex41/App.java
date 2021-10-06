/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jordan Snoap
 */

// MUST INCLUDE PSEUDOCODE AS COMMENTS

// DONT FORGET TEST CASES AND PLANTUML CLASS DIAGRAM

/* PSUEDOCODE General Idea:
Read the input file into an ArrayList with each name being one index.
Sort the ArrayList
Convert the ArrayList into an output file by writing it line by line or index by index
Don't forget to add the intro statement to the output file ("Total of 7 names")
 */
package ex41;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App
{
    // Main file runs through necessary methods step by step
    public static void main( String[] args ) throws IOException {
        ArrayList<String> names;

        names = readFileIntoList();

        sortNames(names);

        createOutputFile(names);
    }

    // Method that pulls from the input .txt file and creates an ArrayList of values
    public static ArrayList<String> readFileIntoList() throws IOException
    {
        ArrayList<String> allNames = new ArrayList<>();
        File file = new File("src/main/java/ex41/exercise41_input.txt");

        Scanner scanNames = new Scanner(file);

        while (scanNames.hasNextLine())
        {
            allNames.add(scanNames.nextLine());
        }

        return allNames;
    }

    // Method needed to sort the unsorted ArrayList of names
    public static ArrayList<String> sortNames(ArrayList<String> unsortedNames)
    {
        Collections.sort(unsortedNames);

        return unsortedNames;
    }

    // Method to add the sorted names to an output file "exercise41_output.txt"
    public static void createOutputFile(ArrayList<String> sortedNames) throws IOException
    {
        int i;

        FileWriter output = new FileWriter("src/main/java/ex41/exercise41_output.txt");

        output.write("Total of " + sortedNames.size() + " names\n");
        output.write("-----------------\n");

        // Looping through and adding ArrayList values to new file
        for (i = 0; i < sortedNames.size(); i++)
        {
            output.write(sortedNames.get(i) + "\n");
        }
        // Make sure to close file after using!
        output.close();
    }
}
