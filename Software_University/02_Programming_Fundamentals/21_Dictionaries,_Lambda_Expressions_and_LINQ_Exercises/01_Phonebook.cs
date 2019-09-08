using System;
using System.Collections.Generic;

public class Program
{
    public static void Main()
    {
        var phoneBook = new Dictionary<string, string>();

        while (true)
        {
            var input = Console.ReadLine().Split();

            if (input[0] == "END")
            {
                break;
            }

            var command = input[0];
            var currName = input[1];

            switch (command)
            {
                case "A":
                    AddContact(phoneBook, currName, input[2]);
                    break;
                case "S":
                    ShowContact(phoneBook, currName);
                    break;
            }
        }

    }

    public static void ShowContact(Dictionary<string, string> phoneBook, string currName)
    {
        Console.WriteLine(phoneBook.ContainsKey(currName) 
            ? $"{currName} -> {phoneBook[currName]}"
            : $"Contact {currName} does not exist.");
    }

    public static void AddContact(Dictionary<string, string> phoneBook, string currName, string currNum)
    {
        if (!phoneBook.ContainsKey(currName))
        {
            phoneBook[currName] = string.Empty;
        }

        phoneBook[currName] = currNum;
    }
}