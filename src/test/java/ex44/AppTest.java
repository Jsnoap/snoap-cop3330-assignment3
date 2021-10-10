/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jordan Snoap
 */

package ex44;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class AppTest 
{
    // parseJsonFile() simply creates file and get it in a JSONArray form
    // printInvalid() and askForProduct() only scan and print
    @Test
    public void checkPrintingProductAskedFor() throws IOException, ParseException
    {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/main/java/ex44/exercise44_input.json");
        Object obj = jsonParser.parse(reader);
        JSONObject validProducts = (JSONObject)obj;
        JSONArray array = (JSONArray)validProducts.get("products");

        assertEquals("Widget", App.printProduct("Widget", array));
        assertEquals("Thing", App.printProduct("Thing", array));
        assertEquals("Doodad", App.printProduct("Doodad", array));
    }

    @Test
    public void checkBadPrintingProductAskedFor() throws IOException, ParseException
    {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/main/java/ex44/exercise44_input.json");
        Object obj = jsonParser.parse(reader);
        JSONObject validProducts = (JSONObject)obj;
        JSONArray array = (JSONArray)validProducts.get("products");

        assertEquals("", App.printProduct("Helloooooo", array));
    }
}
