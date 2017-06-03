using System;

public class Program
{
    public static void Main()
    {
        while (true)
        {
            var inputNumber = int.Parse(Console.ReadLine());

            if (inputNumber % 2 == 0)
            {
                Console.WriteLine("Please write an odd number.");
            }
            else
            {
                var absNumber = Math.Abs(inputNumber);

                Console.WriteLine($"The number is: {absNumber}");
                break;
            }
        }
    }
}