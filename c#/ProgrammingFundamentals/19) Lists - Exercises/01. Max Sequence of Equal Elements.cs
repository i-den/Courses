using System;
using System.Linq;

class Program
{
	static void Main()
	{
        var input = Console.ReadLine().Split().Select(int.Parse).OrderBy(x => x).ToList();
        var bestLength = 0;
        var indexToStart = 0;

        for (int i = 0; i < input.Count(); i++)
        {
            var currLength = 1;

            for (int j = i + 1; j < input.Count(); j++)
            {
                if (input[i] == input[j])
                {
                    currLength++;

                    if (currLength >= bestLength)
                    {
                        bestLength = currLength;
                        indexToStart = i;
                    }
                }
                else
                {
                    i = j - 1;
                    break;
                }
            }
        }

        for (int i = indexToStart; i < indexToStart + bestLength; i++)
        {
            Console.Write($"{input[i]} ");
        }
    }
}