using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var userSessionIPList = new Dictionary<string, Dictionary<string, int>>();
        var numberOfRequests = int.Parse(Console.ReadLine());

        for (int i = 0; i < numberOfRequests; i++)
        {
            var input = Console.ReadLine().Split();

            var currentUserName = input[1];
            var currentUserIP = input[0];
            var currentUserSessionTime = int.Parse(input[2]);

            if (!userSessionIPList.ContainsKey(currentUserName))
            {
                userSessionIPList[currentUserName] = new Dictionary<string, int>();
            }

            if (!userSessionIPList[currentUserName].ContainsKey(currentUserIP))
            {
                userSessionIPList[currentUserName][currentUserIP] = 0;
            }

            userSessionIPList[currentUserName][currentUserIP] += currentUserSessionTime;
        }

        foreach (var userIPSessionData in userSessionIPList.OrderBy(x => x.Key))
        {
            var currUserName = userIPSessionData.Key;
            var currUserIPData = userIPSessionData.Value;

            var currentTotalSessionTime = userIPSessionData.Value.Values.Sum();
            var totalIPs = userIPSessionData.Value.Keys.Count();
            var counter = 1;

            Console.Write($"{currUserName}: {currentTotalSessionTime} [");

            foreach (var IPs in currUserIPData.OrderBy(x => x.Key))
            {
                var currentIP = IPs.Key;

                if (counter != totalIPs)
                {
                    Console.Write($"{currentIP}, ");
                }
                else
                {
                    Console.WriteLine($"{currentIP}]");
                }

                counter++;
            }
        }
    }
}