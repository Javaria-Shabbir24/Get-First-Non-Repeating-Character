
package com.mycompany.q2assignment2scd;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

class FirstNonRepeatingStream{
    //using hashmap bcz its complexity is O(1)
    private final Map<Character,Integer> StreamData;
    //linkedlist of characters with order
    private final LinkedList<Character> Stream;
    //linkedlist of non repeating characters
    private final LinkedList<Character> NonRepeatingCharactersStream;
    //constructor
    public FirstNonRepeatingStream()
    {
     StreamData=new HashMap<>();
     Stream=new LinkedList<>();
     NonRepeatingCharactersStream=new LinkedList<>();
    }
    //add function
    void add(char c)
    {
        //returns the value associated with this character in the stream
        StreamData.put(c,StreamData.getOrDefault(c, 0) +1);//returns default value of key doesnot exist
        System.out.println(c+" added successfully");
        //add the character at the end of the linkedlist 
        Stream.addLast(c);
        System.out.println("Stream Updated");
        //check if the character is repeating or non repeating
        if(StreamData.get(c)==1)//non repeating
        {
            NonRepeatingCharactersStream.addLast(c);
        }
        else
        {
            NonRepeatingCharactersStream.removeFirstOccurrence(c);
        }
    }
    //get first non repeating character method
    public char GetFirstNonRepeating()
    {
        if(!NonRepeatingCharactersStream.isEmpty())
        {
            return NonRepeatingCharactersStream.getFirst();
        }
        return '-';
    }
    //print function
    void PrintStream()
    {
        System.out.print("The Stream is: [");
        for(char element:Stream)
        {
            System.out.print("\'"+element+"\' ");
        } System.out.println("]");
    }
}
class InvalidInputException extends Exception
{
    public InvalidInputException(String e)
    {
        super(e);
    }
}
public class Q2Assignment2SCD {
    static void menu()
    {
        System.out.println("1.Add Element in Stream\n2.Get First Non-Repeating Character from Stream");
        System.out.println("3.Print the Stream\n4.Exit");
    }
    public static void main(String[] args)
    {
        FirstNonRepeatingStream f1=new FirstNonRepeatingStream();
        Scanner input=new Scanner(System.in);
        try
        {
            while(true)
            {
                menu();
                System.out.print("Choose an option: ");
                if(input.hasNextInt())
                {
                    int option=input.nextInt();
                    if(option==1)
                    {
                        System.out.print("Enter the character: ");
                        char c=input.next().charAt(0);
                        if(!Character.isLetter(c))
                        {
                             throw new InvalidInputException("Invalid Input Exception");
                        }
                        else
                        {
                        f1.add(c);
                        }
                    }
                    else if(option==2)
                    {
                        char x=f1.GetFirstNonRepeating();
                        System.out.println("The First Non Repeating Element is : "+x);
                    }
                    else if(option==3)
                    {
                        f1.PrintStream();
                    }
                    else if(option==4)
                    {
                        System.out.println("Program Exited!");
                        break;
                    }
                    else
                    {
                         throw new InvalidInputException("Invalid Input Exception");
                    }
                }
                else
                {
                    throw new InvalidInputException("Invalid Input Exception");
                }
            }
        }
        catch(InvalidInputException e)
        {
            System.out.println("Exception Message: "+e.getMessage());
        }
    }
}
