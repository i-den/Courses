using System;
using System.Collections.Generic;

public class Program
{
    public static void Main()
    {
        var input = Console.ReadLine().Split();

        var minWord = input[0].Length > input[1].Length ? input[1] : input[0];
        var maxWord = input[0].Length > input[1].Length ? input[0] : input[1];
        var usedCharactersDictionary = new Dictionary<char, char>();
        var canExchange = true;

        for (int i = 0; i < minWord.Length; i++)
        {
            var minWordChar = minWord[i];
            var maxWordChar = maxWord[i];

            if (!usedCharactersDictionary.ContainsKey(minWordChar))
            {
                if (!usedCharactersDictionary.ContainsValue(maxWordChar))
                {
                    usedCharactersDictionary[minWordChar] = maxWordChar;
                }
                else
                {
                    canExchange = false;
                    break;
                }
            }
            else
            {
                if (usedCharactersDictionary[minWordChar] != maxWordChar)
                {
                    canExchange = false;
                    break;
                }
            }
        }

        if (minWord.Length != maxWord.Length && canExchange)
        {
            var remainingChars = maxWord.Substring(minWord.Length);

            foreach (var remainingChar in remainingChars)
            {
                if (!usedCharactersDictionary.ContainsKey(remainingChar) && !usedCharactersDictionary.ContainsValue(remainingChar))
                {
                    canExchange = false;
                    break;
                }
            }
        }

        Console.WriteLine(canExchange.ToString().ToLower());
    }
}