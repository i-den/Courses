using System;

public class Program
{
    public static void Main()
    {
        var intCounter = 0;

        while (true)
        {
            var currentInput = Console.ReadLine();
            var dummyInt = 0;

            var isParsed = int.TryParse(currentInput, out dummyInt);

            if (isParsed)
            {
                intCounter++;
            }
            else
            {
                break;
            }
        }

        Console.WriteLine(intCounter);
    }
}