/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jordan Snoap
 */

// MUST INCLUDE PSEUDOCODE AS COMMENTS

// DONT FORGET TEST CASES AND PLANTUML CLASS DIAGRAM

/* PSUEDOCODE General Idea:
Start by creating json parser and converting values within to a JSONArray (Using a FileReader, Object, and JSONObject)
Continue by asking question to user with a Scanner and use a while loop to repeat question until a valid product is entered.
Create function to print output based on chosen product.
 */

// Video used to learn JSON: https://www.youtube.com/watch?v=U-5VHRvOFpA

package ex44;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    // Begins by calling the method to parse the Json file
    public static void main( String[] args ) throws IOException, ParseException
    {
        parseJsonFile();
    }

    // Used to tell user to enter another item
    public static void printInvalid()
    {
        System.out.println("Sorry, that product was not found in our inventory.");
    }

    // Creates and uses a json parser to convert the input json file and read through
    public static void parseJsonFile() throws IOException, ParseException
    {
        // parser created to go through file
        JSONParser jsonParser = new JSONParser();

        // Used to read json file
        FileReader reader = new FileReader("src/main/java/ex44/exercise44_input.json");

        // Used to parse through file and store as a normal java object
        Object obj = jsonParser.parse(reader);

        // Typecast to make it a jsonObj
        JSONObject validProducts = (JSONObject)obj;

        // Need to extract JSONArray from the JSONObject
        JSONArray array = (JSONArray)validProducts.get("products");

        String chosenProduct = askForProduct();

        printProduct(chosenProduct, array);
    }

    // Prints out the correct output with the product from the user and a JSONArray
    public static String printProduct(String productInJSON, JSONArray arrayOfProducts)
    {
        int i;

        for (i = 0; i < arrayOfProducts.size(); i++)
        {
            JSONObject products = (JSONObject) arrayOfProducts.get(i);
            String name = (String)products.get("name");

            if (name.equals(productInJSON))
            {
                System.out.println("Name: " + name);
                System.out.println("Price: " + String.format("%.2f", products.get("price")));
                System.out.println("Quantity: " + (long)products.get("quantity"));

                return name;
            }
        }

        return "";
    }

    // Function to see if the user input is in the JSON file. Asks until it is.
    public static String askForProduct()
    {
        String product;

        System.out.println("What is the product name?");
        Scanner inputProduct = new Scanner(System.in);

        while (true)
        {
            product = inputProduct.nextLine();

            if (product.equals("Widget") || product.equals("Thing") || product.equals("Doodad"))
            {
                return product;
            }

            printInvalid();
            System.out.println("What is the product name?");
        }
    }


}
