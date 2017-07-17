using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var myList = Console.ReadLine().Split().Select(double.Parse).ToList();

        if (myList.Count != 0)
        {
            for (int i = 1; i < myList.Count; i++)
            {
                if (myList[i - 1] == myList[i])
                {
                    myList[i] *= 2;
                    myList.RemoveAt(i - 1);
                    if (i > 1)
                    {
                        i -= 2;
                    }
                    else
                    {
                        i--;
                    }
                }
            }
        }

        Console.WriteLine(string.Join(" ", myList));
    }
}