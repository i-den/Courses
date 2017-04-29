using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var myList = Console.ReadLine().Split('|').ToList();

        for (int i = myList.Count - 1; i >= 0; i--)
        {
            var currentList = myList[i].Split();

            foreach (var item in currentList)
            {
                if (item != "")
                {
                    Console.Write("{0} ", item);
                }
            }
        }
    }
}