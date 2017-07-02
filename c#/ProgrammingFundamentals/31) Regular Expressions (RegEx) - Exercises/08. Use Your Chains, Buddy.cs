using System;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

class Program
{
    static void Main()
    {
        Console.SetIn(new StreamReader(Console.OpenStandardInput(8192)));

        var codedText = new StringBuilder(
            string.Join("",
            Regex.Matches(Console.ReadLine(), @"(?<=\<p\>)(.*?)(?=\<\/p\>)")
            .Cast<Match>()
            .Select(match => match.Value)
            .Select(match => Regex.Replace(match, @"[^a-z0-9]", w => " "))
            .Select(text => Regex.Replace(text, @"\s+", w => " "))
            .ToArray()));

        var decodedText = DecodeText(codedText.ToString());

        Console.WriteLine(decodedText);
    }

    public static string DecodeText(string codedText)
    {
        var decodedText = new StringBuilder(codedText.Length);

        foreach (var currCharacter in codedText)
        {
            decodedText.Append(DecodeCharacter(currCharacter));
        }

        return decodedText.ToString();
    }

    public static char DecodeCharacter(char currCharacter)
    {
        var charToReturn = currCharacter;

        if (currCharacter >= 'a' && currCharacter < 'n')
        {
            charToReturn = (char)(currCharacter + 13);
        }
        else if (currCharacter >= 'n' && currCharacter <= 'z')
        {
            charToReturn = (char)(currCharacter - 13);
        }

        return charToReturn;
    }
}