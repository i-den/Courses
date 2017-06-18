using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var myList = Console.ReadLine().Split().Select(int.Parse).ToList();

        myList.Sort();
        CountNumberOccurances(myList);
    }

    public static void CountNumberOccurances(List<int> myList)
    {
        for (int i = 0; i < myList.Count; i++)
        {
            int currNumberOccurances = 0;
            var indexAnchor = 0;

            for (int j = i; j < myList.Count; j++)
            {
                if (myList[i] == myList[j])
                {
                    currNumberOccurances++;
                }
                else
                {
                    break;
                }

                indexAnchor = j;
            }

            Console.WriteLine("{0} -> {1}", myList[i], currNumberOccurances);
            i = indexAnchor;
        }
    }
}