/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jordan Snoap
 */

// MUST INCLUDE PSEUDOCODE AS COMMENTS

// DONT FORGET TEST CASES AND PLANTUML CLASS DIAGRAM

/* PSUEDOCODE General Idea:
Read input file from the same package
Create an initial statement in the output file with a header for the categories (Last      First     Salary)
Create a loop to read the file into an array and add these values to a new output file at the same time
End with output file with all the correct sorting
 */
package ex42;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App
{
    // main method runs through correct order of calls while holding out output File
    public static void main( String[] args ) throws IOException
    {
        FileWriter outputFile;

        outputFile = createOutputFileWithHeader();

        readAndParseFile(outputFile);
    }

    // Function to create the output file and add the proper header
    public static FileWriter createOutputFileWithHeader() throws IOException
    {
        FileWriter output = new FileWriter("src/main/java/ex42/exercise42_output.txt");
        output.write("Last      First     Salary\n--------------------------\n");

        return output;
    }

    // Function to add to the output file by reading and parsing the input file (with BufferedReader + split)
    public static String readAndParseFile(FileWriter output) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/ex42/exercise42_input.txt"));
        String line;

        // While loop parses through file and creates an array of each of the value sets for each loop. Adds these to output file
        while((line = br.readLine()) != null)
        {
            // Split is key to the CSV parser by identifying where each comma is located
            String[] info = line.split(",");
            output.write(String.format("%-10s", info[0]) + String.format("%-10s", info[1]) + String.format("%-6s", info[2]) + "\n");
        }

        output.close();

        return br.readLine();
    }
}
