/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jordan Snoap
 */

// MUST INCLUDE PSEUDOCODE AS COMMENTS

// DONT FORGET TEST CASES AND PLANTUML CLASS DIAGRAM

/* PSUEDOCODE General Idea:
Read input file from the same package
Create an initial statement in the output with a header for the categories (Last      First     Salary)
Create a loop to read the file into an array and add these values to the output statement
End with printing output statement
 */
package ex42;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App
{
    // main method runs through correct order of calls while holding "table" value
    public static void main( String[] args ) throws IOException
    {
        String table;

        table = readAndParseFile();

        printTable(table);
    }

    // Function to add to the output statement by reading and parsing the input file (with BufferedReader + split)
    public static String readAndParseFile() throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("src/main/java/ex42/exercise42_input.txt"));
        String line;
        StringBuilder outputTable = new StringBuilder();

        // Prints table header
        outputTable.append("Last      First     Salary\n--------------------------\n");

        // While loop parses through file and creates an array of each of the value sets for each loop. Adds these to output file
        while((line = br.readLine()) != null)
        {
            // Split is key to the CSV parser by identifying where each comma is located
            String[] info = line.split(",");
            outputTable.append(String.format("%-10s", info[0])).append(String.format("%-10s", info[1])).append(String.format("%-6s", info[2])).append("\n");
        }

        return outputTable.toString();
    }

    // Short function to print table content
    public static void printTable(String tableContent)
    {
        System.out.println(tableContent);
    }
}
