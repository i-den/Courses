using System;
using System.Collections.Generic;
using System.Numerics;

class Problem4
{
    static void Main()
    {
        var input = Console.ReadLine().Split();

        var firstWord = input[0].ToCharArray();
        var secondWord = input[1].ToCharArray();
        var sumResult = GetCharacterSum(firstWord, secondWord);

        Console.WriteLine(sumResult);
    }

    private static int GetCharacterSum(char[] firstWord, char[] secondWord)
    {
        var minWord = firstWord.Length  secondWord.Length  secondWord  firstWord;
        var maxWord = firstWord.Length  secondWord.Length  firstWord  secondWord;
        var minLength = minWord.Length;
        var maxLenght = maxWord.Length;
        
        var sum = 0;

        for (int i = 0, j = 0; i  maxLenght; i++)
        {
            if (i = j)
            {
                sum += (int)maxWord[i]  (int)minWord[j];

                if (j != minWord.Length - 1)
                {
                    j++;
                }
            }
            else
            {
                sum += (int)maxWord[i];
            }
        }

        return sum;
    }
}