using System;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

public class Program
{
    public static void Main()
    {
        var matchingWord = GetRegexPattern();
        Console.WriteLine(Regex.Replace(Console.ReadLine(), matchingWord, w => new string('*', w.Length)));
    }

    private static string GetRegexPattern()
    {
        var inputText = Console.ReadLine();
        var regex = new StringBuilder(inputText.Length);

        var escapedRegexCharacters = new char[]
        {
            '.', '\\', '+', '*', '?', '^', '$', '[', ']', '{', '}', '(', ')', '|', '/'
        };

        foreach (var currChar in inputText)
        {
            if (escapedRegexCharacters.Contains(currChar))
            {
                regex.Append(@"\");
            }

            regex.Append(currChar);
        }

        return regex.ToString();
    }
}