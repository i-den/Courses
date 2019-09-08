using System;

public class Program
{
    public static void Main()
    {
        for (int i = 0; i < 7; i++)
        {
            var input = Console.ReadLine();

            byte byteParse = 0;
            short shortParse = 0;
            int intParse = 0;
            long longParse = 0;

            if (byte.TryParse(input, out byteParse))
            {
                Console.WriteLine(byteParse);
                continue;
            }
            else if (short.TryParse(input, out shortParse))
            {
                Console.WriteLine(shortParse);
                continue;
            }
            else if (int.TryParse(input, out intParse))
            {
                Console.WriteLine(intParse);
                continue;
            }
            else if (long.TryParse(input, out longParse))
            {
                Console.WriteLine(longParse);
                continue;
            }
        }
    }
}