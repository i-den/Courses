using System;

public class Program
{
    public static void Main()
    {
        var input = char.Parse(Console.ReadLine());

        if (char.IsDigit(input))
        {
            Console.WriteLine("digit");
        }
        else if (input == 'w' || input == 'e' || input == 'y' || input == 'u' || input == 'i' || input == 'o' || input == 'a')
        {
            Console.WriteLine("vowel");
        }
        else
        {
            Console.WriteLine("other");
        }
    }
}