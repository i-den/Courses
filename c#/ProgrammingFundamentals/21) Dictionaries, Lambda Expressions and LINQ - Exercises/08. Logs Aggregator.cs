using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var n = int.Parse(Console.ReadLine());
        var userSess = new Dictionary<string, long>();
        var userIPs = new Dictionary<string, HashSet<string>>();

        for (int i = 0; i < n; i++)
        {
            var input = Console.ReadLine().Split();

            var currUser = input[1];
            var currIP = input[0];
            var currSession = long.Parse(input[2]);

            if (!userSess.ContainsKey(currUser))
            {
                userSess[currUser] = 0L;
            }

            if (!userIPs.ContainsKey(currUser))
            {
                userIPs[currUser] = new HashSet<string>();
            }

            userSess[currUser] += currSession;
            userIPs[currUser].Add(currIP);
        }

        foreach (var kvp in userSess.OrderBy(x => x.Key))
        {
            var currUser = kvp.Key;
            var totalSess = kvp.Value;

            Console.Write($"{currUser}: {totalSess} [");

            Console.WriteLine(string.Join(", ", userIPs[currUser].OrderBy(x => x)) + "]");

        }
    }
}