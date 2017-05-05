using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var words = Console.ReadLine().ToLower().Split(' ');

        var wordsCount = new Dictionary<string, int>();

        foreach (var word in words)
        {
            if (!wordsCount.ContainsKey(word))
            {
                wordsCount[word] = 0;
            }

            wordsCount[word]++;
        }

        var wordsListResult = new List<string>();

        foreach (var word in wordsCount)
        {
            if (word.Value % 2 != 0)
            {
                wordsListResult.Add(word.Key);
            }
        }

        Console.WriteLine(string.Join(", ", wordsListResult));
    }
}