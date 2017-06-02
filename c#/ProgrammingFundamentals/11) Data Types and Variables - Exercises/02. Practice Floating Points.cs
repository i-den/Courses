using System;

public class Program
{
    public static void Main()
    {
        for (int i = 0; i < 3; i++)
        {
            var input = Console.ReadLine();

            var floatParse = 0F;
            var doubleParse = 0D;
            var decimalParse = 0M;


            
            if (decimal.TryParse(input, out decimalParse))
            {
                Console.WriteLine(decimalParse);
                continue;
            }
            else if (double.TryParse(input, out doubleParse))
            {
                Console.WriteLine(doubleParse);
                continue;
            }
            else if (float.TryParse(input, out floatParse))
            {
                Console.WriteLine(floatParse);
                continue;
            }
        }
    }
}