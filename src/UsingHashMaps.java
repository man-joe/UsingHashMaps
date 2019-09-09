/*
Your Assignment:
Create a map and store integers and their word values.
HashMap<Integer, String> myMap = new HashMap<Integer, String>();
Prompt user to enter a number and print out the word value.
Example:

Prompt: Enter a number: 10 Response: You entered ten.

If number is not found (use myMap.containsKey(10) then prompt user to tell the map to add that to the map.

Add the key and value to the map with the following line of code:

myMap.put(10,"ten");

Retrieve the value with

String value = myMap.get(10)

Next: Save the values to a file in the format:

10 ten
11 eleven
12 twelve
Then modify your program to load the class and populate the hashmap from the file. That way the user will
not have to enter a key/value pair twice.

Use the Scanner.nextInt() and Scanner.next() methods to return values in your file.

            File file = new File();
            scannerInput = new Scanner(file);//note that Scanner can read from a file!
            while (scannerInput.hasNextLine()) {
                String line = scannerInput.nextLine();
                System.out.println(line);
            }


One way of iterating through a HashMap....

Map map = new HashMap();

//iterating over keys only
for (Integer key : map.keySet()) {
    System.out.println("Key = " + key);
}

//iterating over values only
for (Integer value : map.values()) {
    System.out.println("Value = " + value);
}
Finally, your program should prompt the user for the value and print out the text.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class UsingHashMaps {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\GBTC440018ur\\IdeaProjects\\UsingHashMaps\\OneThroughTen.txt");
        Scanner scFile = new Scanner(file);
        Scanner sc = new Scanner(System.in);
        int userInt;
        String keyValue = "";
        HashMap<Integer,String> myMap = new HashMap<Integer, String>();


        // Read From File and add to myMap
        while(scFile.hasNextLine()) {
            myMap.put(scFile.nextInt(),scFile.next());
        }

        System.out.println("Printing All Keys and Values");

        for(Integer key : myMap.keySet())
            System.out.println("Key: " + key + " Value: " + myMap.get(key));

        System.out.println("-----------------------------------------------------");

        //User's input
        while(true) {
            System.out.print("Enter a number(-1 to quit): ");
            userInt = sc.nextInt();
            if(userInt == -1)
                break;
            else if (myMap.containsKey(userInt))
                System.out.print("You entered " + myMap.get(userInt) + ".");
            else {
                System.out.print("No key found. Adding key to map... Please provide value: ");
                keyValue = sc.next();
                myMap.put(userInt, keyValue);
                System.out.println("You entered " + myMap.get(userInt) + ".");
            }
        }

        System.out.println("Printing All Keys and Values");

        for(Integer key : myMap.keySet())
            System.out.println("Key: " + key + " Value: " + myMap.get(key));
    }
}
