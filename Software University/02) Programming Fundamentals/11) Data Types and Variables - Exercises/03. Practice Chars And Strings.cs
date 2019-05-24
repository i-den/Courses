using System;

public class Program
{
    public static void Main()
    {
        for (int i = 0; i < 5; i++)
        {
            var input = Console.ReadLine();

            

            if (input.Length > 1)
            {
                var result = input;
                Console.WriteLine(result);
                continue;
            }
            else if (input.Length == 1)
            {
                var result = char.Parse(input);
                Console.WriteLine(result);
                continue;
            }
        }
    }
}