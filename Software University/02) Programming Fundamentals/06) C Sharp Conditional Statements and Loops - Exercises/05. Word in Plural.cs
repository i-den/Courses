using System;

public class Program
{
    public static void Main()
    {
        var inputWord = Console.ReadLine();

        if (inputWord.EndsWith("y"))
        {
            inputWord = inputWord.TrimEnd('y');
            inputWord += "ies";
        }
        else if (inputWord.EndsWith("o") || inputWord.EndsWith("ch") || inputWord.EndsWith("s") || inputWord.EndsWith("sh") || inputWord.EndsWith("x") || inputWord.EndsWith("z"))
        {
            inputWord += "es";
        }
        else
        {
            inputWord += "s";
        }

        Console.WriteLine(inputWord);
    }
}