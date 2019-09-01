using System;
using System.Collections.Generic;

public class Program
{
    public static void Main()
    {
        var phoneBook = new SortedDictionary<string, string>();

        while (true)
        {
            var input = Console.ReadLine().Split();

            if (input[0] == "END")
            {
                return;
            }

            switch (input[0])
            {
                case "A":
                    AddContact(phoneBook, input[1], input[2]);
                    break;
                case "S":
                    ShowContact(phoneBook, input[1]);
                    break;
                case "ListAll":
                    ListPhoneBook(phoneBook);
                    break;
            }
        }
    }

    private static void ShowContact(SortedDictionary<string, string> phoneBook, string currName)
    {
            Console.WriteLine(phoneBook.ContainsKey(currName)
                ? $"{currName} -> {phoneBook[currName]}"
                : $"Contact {currName} does not exist.");
        
    }

    public static void ListPhoneBook(SortedDictionary<string, string> phoneBook)
    {
        foreach (var kvp in phoneBook)
        {
            var currName = kvp.Key;
            var currPhoneNum = kvp.Value;

            Console.WriteLine($"{currName} -> {currPhoneNum}");
        }
    }

    public static void AddContact(SortedDictionary<string, string> phoneBook, string currName, string currPhoneNum)
    {
        phoneBook[currName] = currPhoneNum;
    }
}