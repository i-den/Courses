using System;

public class Program
{
    public static void Main()
    {
        var inputWords = Console.ReadLine().Split();
        var firstWord = inputWords[0];
        var secWord = inputWords[1];

        var shorterWord = firstWord.Length > secWord.Length ? secWord : firstWord;
        var longerWord = firstWord.Length > secWord.Length ? firstWord : secWord;
        var sum = 0;

        for (int i = 0, j = 0; i < longerWord.Length; i++)
        {
            if (i <= j)
            {
                sum += (int)(shorterWord[j] * longerWord[i]);

                if (j < shorterWord.Length - 1)
                {
                    j++;
                }
            }
            else
            {
                sum += (int)longerWord[i];
            }
        }

        Console.WriteLine(sum);
    }
}