using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var userIPAccessLogs = new SortedDictionary<string, Dictionary<string, int>>();
        var canContinue = true;

        while (canContinue)
        {
            var input = Console.ReadLine().Split();

            if (input[0].ToLower() == "end")
            {
                canContinue = false;
                break;
            }

            var currentIPAddress = input[0].Substring(3);
            var currentMessage = input[1].Substring(8);
            var currentUseName = input[2].Substring(5);

            if (!userIPAccessLogs.ContainsKey(currentUseName))
            {
                userIPAccessLogs[currentUseName] = new Dictionary<string, int>();
            }

            if (!userIPAccessLogs[currentUseName].ContainsKey(currentIPAddress))
            {
                userIPAccessLogs[currentUseName][currentIPAddress] = 0;
            }

            userIPAccessLogs[currentUseName][currentIPAddress]++;
        }

        foreach (var userIPLogs in userIPAccessLogs)
        {
            var currentUserName = userIPLogs.Key;
            var currentUserNameLogs = userIPLogs.Value;
            var totalIPAddresses = currentUserNameLogs.Keys.Count;
            var count = 1;

            Console.WriteLine($"{currentUserName}: ");

            foreach (var IPAddressOccurencePair in currentUserNameLogs)
            {
                var currentIPAddress = IPAddressOccurencePair.Key;
                var currentIPAddressOccurences = IPAddressOccurencePair.Value;

                if (count != currentUserNameLogs.Count)
                {
                    Console.Write($"{currentIPAddress} => {currentIPAddressOccurences}, ");
                }
                else
                {
                    Console.Write($"{currentIPAddress} => {currentIPAddressOccurences}.");
                }

                count++;
            }

            Console.WriteLine();
        }
    }
}