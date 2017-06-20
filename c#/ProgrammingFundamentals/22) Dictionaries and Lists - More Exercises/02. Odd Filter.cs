using System;
using System.Linq;

class Program
{
    static void Main()
    {
        var inputList = Console.ReadLine().Split().Select(int.Parse).Where(x => x % 2 == 0).ToList();
        var avg = inputList.Average();

        for (int i = 0; i < inputList.Count(); i++)
        {
            if (inputList[i] > avg)
            {
                inputList[i]++;
            }
            else if (inputList[i] < avg)
            {
                inputList[i]--;
            }
        }

        Console.WriteLine(string.Join(" ", inputList));
    }
}