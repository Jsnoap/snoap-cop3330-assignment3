/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jordan Snoap
 */

// MUST INCLUDE PSEUDOCODE AS COMMENTS

// DONT FORGET TEST CASES AND PLANTUML CLASS DIAGRAM

/* PSUEDOCODE General Idea:
Initially prompt user for site name, author, if they want a JS folder, and if they want a CSS folder and store these answers.
Create the correct directories with these stored names (will need to write to a file for index.html)
    -> Create these directories within the "ex43" package
Print out what was created
 */

package ex43;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App 
{
    // Prompt user for name of site, author, if they want a JS folder, and if they want a CSS folder
    // Store these answers and pass to respective functions
    public static void main( String[] args ) throws IOException {
        String site, author;
        char js, css;

        System.out.println("Site name: ");
        Scanner siteInput = new Scanner(System.in);
        site = siteInput.nextLine();

        System.out.println("Author: ");
        Scanner authorInput = new Scanner(System.in);
        author = authorInput.nextLine();

        System.out.println("Do you want a folder for JavaScript? (y or n)");
        Scanner jsInput = new Scanner(System.in);
        js = jsInput.nextLine().charAt(0);

        System.out.println("Do you want a folder for CSS? (y or n)");
        Scanner cssInput = new Scanner(System.in);
        css = cssInput.nextLine().charAt(0);

        createDirectories(site, js, css, author);

        printCreations(site , js, css);
    }

    // Method that creates the proper directories for the program and uses the names from the Scanner
    public static String createDirectories(String siteName, char jsFolder, char cssFolder, String authorName) throws IOException
    {
        jsFolder = Character.toUpperCase(jsFolder);
        cssFolder = Character.toUpperCase(cssFolder);

        String mainPath = "src/main/java/ex43/website/" + siteName;

        // "mkdirs()" or "mkdir()" is used to create these directories in the package
        File file = new File(mainPath);
        file.mkdirs();

        // Pass over to function to create the index.html file
        createIndexHTML(mainPath, siteName, authorName);

        // Make the proper js and css directories if user prompted with affirmative
        if (jsFolder == 'Y')
        {
            File file3 = new File(mainPath + "/js");
            file3.mkdir();
        }

        if (cssFolder == 'Y')
        {
            File file4 = new File(mainPath + "/css");
            file4.mkdir();
        }

        return mainPath;
    }

    // Create the proper code to set up the beginning of an HTML file with the user input from Scanners
    // Googled "HTML Boilerplate" code to help with this step for realism
    public static String createIndexHTML(String pathPlacement, String website, String creator) throws IOException
    {
        String path = pathPlacement + "/index.html";
        FileWriter writeIndex = new FileWriter(path);

        writeIndex.write("<!DOCTYPE html>\n<html>\n\n<head>\n");
        writeIndex.write("\t<meta author=\"" + creator + "\">\n");
        writeIndex.write("\t<title>" + website + "</title>\n");
        writeIndex.write("</head>\n\n<body>\n</body>\n\n</html>");

        writeIndex.close();

        return path;
    }

    // Prints out what files were created
    public static void printCreations(String webName, char jsDirectory, char cssDirectory)
    {
        System.out.println("Created ./website/" + webName);
        System.out.println("Created ./website/" + webName + "/index.html");

        // If statements used to make sure these only print if user prompts for a js or css folder
        if (jsDirectory == 'y' || jsDirectory == 'Y')
        {
            System.out.println("Created ./website/" + webName + "/js");
        }

        if (cssDirectory == 'y' || cssDirectory == 'Y')
        {
            System.out.println("Created ./website/" + webName + "/css");
        }
    }
}
