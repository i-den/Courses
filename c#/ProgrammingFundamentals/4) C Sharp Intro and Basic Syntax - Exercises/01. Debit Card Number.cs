using System;

public class Program
{
    public static void Main()
    {
        var numberArray = new int[4];

        for (int i = 0; i < 4; i++)
        {
            numberArray[i] = int.Parse(Console.ReadLine());
        }

        for (int i = 0; i < numberArray.Length; i++)
        {
            Console.Write($"{numberArray[i]:D4} ");
        }
    }
}