using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

class Program
{
    static void Main()
    {
        var inputNums = Console.ReadLine()
            .Split()
            .Select(int.Parse)
            .ToArray();

        var inputText = Console.ReadLine();

        var skipNum = inputNums.First();
        var takeNum = inputNums.Skip(1).First();

        var regexPattern = @"(?<=\|<)[^|<]{" + $"{skipNum}" + @"}([^|<]{" + $"0,{takeNum}" + @"})";

        var matches = Regex.Matches(inputText, regexPattern)
            .Cast<Match>()
            .Select(s => s.Groups[1].Value)
            .ToArray();

        Console.WriteLine(string.Join(", ", matches));
    }
}