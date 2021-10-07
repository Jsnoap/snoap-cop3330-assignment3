/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jordan Snoap
 */

// MUST INCLUDE PSEUDOCODE AS COMMENTS

// DONT FORGET TEST CASES AND PLANTUML CLASS DIAGRAM

/* PSUEDOCODE General Idea:
Initially prompt user for site name, author, if they want a JS folder, and if they want a CSS folder and store these answers.

 */

package ex43;

import java.util.Scanner;

public class App 
{
    // Prompt user for name of site, author, if they want a JS folder, and if they want a CSS folder
    // Store these answers
    public static void main( String[] args )
    {
        String site, author, js, css;

        System.out.println("Site name: ");
        Scanner siteInput = new Scanner(System.in);
        site = siteInput.nextLine();

        System.out.println("Author: ");
        Scanner authorInput = new Scanner(System.in);
        author = authorInput.nextLine();

        System.out.println("Do you want a folder for JavaScript? (y or n)");
        Scanner jsInput = new Scanner(System.in);
        js = jsInput.nextLine();

        System.out.println("Do you want a folder for CSS? (y or n)");
        Scanner cssInput = new Scanner(System.in);
        css = cssInput.nextLine();
    }
}
