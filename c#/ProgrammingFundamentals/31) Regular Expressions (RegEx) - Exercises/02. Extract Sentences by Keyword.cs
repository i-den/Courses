using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

class Program
{
    static void Main()
    {
        var strToLookFor = @"\b" + Console.ReadLine() + @"\b";

        var inputText = Console.ReadLine()
            .Split(new[] { '.', '!', '?' }, StringSplitOptions.RemoveEmptyEntries)
            .ToArray();

        var validOutput = new List<string>();

        foreach (var sentence in inputText
            .Where(s => Regex.IsMatch(s, strToLookFor))
            .Select(s => s.Trim()))
        {
            validOutput.Add(sentence);
        }

        foreach (var sentence in validOutput)
        {
            Console.WriteLine(sentence);
        }
    }
}