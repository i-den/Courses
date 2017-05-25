using System;

public class Program
{
    public static void Main()
    {
        var firstNumber = int.Parse(Console.ReadLine());
        var secondNumber = int.Parse(Console.ReadLine());

        var startingIndex = Math.Min(firstNumber, secondNumber);
        var endingIndex = Math.Max(firstNumber, secondNumber); 

        for (int i = startingIndex; i <= endingIndex; i++)
        {
            Console.WriteLine(i);
        }
    }
}