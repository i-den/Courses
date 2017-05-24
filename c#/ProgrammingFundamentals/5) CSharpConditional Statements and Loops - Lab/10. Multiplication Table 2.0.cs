using System;

public class Program
{
    public static void Main()
    {
        var inputNumber = int.Parse(Console.ReadLine());
        var inputPower = int.Parse(Console.ReadLine());

        if (inputPower > 10)
        {
            var multipliedNumber = inputNumber * inputPower;

            Console.WriteLine($"{inputNumber} X {inputPower} = {multipliedNumber}");
        }
        else
        {
            for (int i = inputPower; i <= 10; i++)
            {
                var multipliedNumber = inputNumber * i;

                Console.WriteLine($"{inputNumber} X {i} = {multipliedNumber}");
            }
        }
        
    }
}