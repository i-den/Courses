using System;

class Program
{
    public static void Main()
    {
        var n = 0;

        while (true)
        {
            Console.WriteLine("Enter even number: ");
            try
            {
                n = int.Parse(Console.ReadLine());
                
                if (n % 2 == 0)
                {
                    Console.WriteLine(n);
                    break;
                }
            }
            catch
            {
                Console.WriteLine("Invalid number!");
            }
        }
    }
}
