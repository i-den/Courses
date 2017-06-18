using System;
using System.Collections.Generic;

public class Program
{
    public static void Main()
    {
        var contactDict = new Dictionary<string, string>();

        while (true)
        {
            var input = Console.ReadLine();

            if (input == "stop")
            {
                break;
            }

            var currName = input;
            var currEmail = Console.ReadLine();

            if (currEmail.EndsWith(".us") || currEmail.EndsWith(".uk"))
            {
                continue;
            }

            if (!contactDict.ContainsKey(currName))
            {
                contactDict[currName] = string.Empty;
            }

            contactDict[currName] = currEmail;
        }

        foreach (var kvp in contactDict)
        {
            var currUser = kvp.Key;
            var currEmail = kvp.Value;

            Console.WriteLine($"{currUser} -> {currEmail}");
        }
    }
}