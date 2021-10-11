/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jordan Snoap
 */

// MUST INCLUDE PSEUDOCODE AS COMMENTS

// DON'T FORGET TEST CASES AND PLANTUML CLASS DIAGRAM

/* PSUEDOCODE General Idea:
Start by prompting for name of output file and create it with a FileWriter
Pass the new created file into another method that replaces "utilize" and "utilizes" to "use" and "uses" respectively.
Uses BufferedReader and BufferedWriter for implementation
 */

package ex45;

import java.io.*;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    // Calls correct methods to create output file and then replace words.
    public static void main( String[] args ) throws IOException
    {
        File createdFile;

        createdFile = promptAnCreateOutputFile();

        changeUtilizeToUse(createdFile);
    }

    // Prompts user for name of file and creates it
    public static File promptAnCreateOutputFile()
    {
        String fileName;

        System.out.println("What would you like to call your output file? (omit the \".txt\")");
        Scanner inputFileName = new Scanner(System.in);
        fileName = inputFileName.nextLine();

        // File is created and empty
        return new File("src/main/java/ex45/" + fileName + ".txt");
    }

    // Runs through the input file and adds the same information to the output file while changing "utilize" to "use"
    public static File changeUtilizeToUse(File outputFile) throws IOException
    {
        File input = new File("src/main/java/ex45/exercise45_input.txt");
        BufferedReader reader = new BufferedReader(new FileReader(input));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        String line;

        while ((line = reader.readLine()) != null)
        {
            writer.write(line.replace("utilize","use").replace("utilizes","uses"));
            writer.newLine();
        }
        reader.close();
        writer.close();

        return outputFile;
    }

}
