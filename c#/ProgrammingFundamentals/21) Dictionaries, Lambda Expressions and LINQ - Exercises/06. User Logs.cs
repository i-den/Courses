using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var userIPCount = new Dictionary<string, Dictionary<string, int>>();

        while (true)
        {
            var input = Console.ReadLine();

            if (input == "end")
            {
                break;
            }

            var currIP = input.Split()[0].Substring(3);
            var currUser = input.Split()[2].Substring(5);

            if (!userIPCount.ContainsKey(currUser))
            {
                userIPCount[currUser] = new Dictionary<string, int>();
            }

            if (!userIPCount[currUser].ContainsKey(currIP))
            {
                userIPCount[currUser][currIP] = 0;
            }

            userIPCount[currUser][currIP]++;
        }

        foreach (var kvp in userIPCount.OrderBy(x => x.Key).ThenByDescending(x => x.Value))
        {
            var currUser = kvp.Key;
            var currInfo = kvp.Value;
            var counter = 1;

            Console.WriteLine($"{currUser}:");

            foreach (var item in currInfo)
            {
                var currIP = item.Key;
                var currIPCount = item.Value;
                var charToPrint = counter < currInfo.Keys.Count()
                    ? ','
                    : '.';

                Console.Write($"{currIP} => {currIPCount}{charToPrint} ");
                counter++;
            }

            Console.WriteLine();
        }
    }
}