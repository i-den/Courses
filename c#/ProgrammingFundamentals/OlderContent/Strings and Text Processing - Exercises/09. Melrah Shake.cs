using System;

public class Program
{
    public static void Main()
    {
        var inputString = Console.ReadLine();
        var patternToRemove = Console.ReadLine();

        while (true)
        {
            var firstIndex = inputString.IndexOf(patternToRemove);
            var lastIndex = inputString.LastIndexOf(patternToRemove);

            if (firstIndex == lastIndex || firstIndex < 0)
            {
                Console.WriteLine("No shake.");
                break;
            }

            inputString = inputString.Remove(firstIndex, patternToRemove.Length);
            inputString = inputString.Remove(lastIndex - patternToRemove.Length, patternToRemove.Length);

            patternToRemove = patternToRemove.Remove((patternToRemove.Length / 2), 1);

            Console.WriteLine("Shaked it.");

            if (patternToRemove.Length == 0)
            {
                Console.WriteLine("No shake.");
                break;
            }
        }

        Console.WriteLine(inputString);
    }
}