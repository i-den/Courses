using System;

class Program
{
    public static void Main()
    {
        var n = int.Parse(Console.ReadLine());
        var prime = (n > 1);

        for (int i = 2; i <= Math.Sqrt(n); i++)
        {
            if (n % i == 0)
            {
                prime = false;
                break;
            }
        }
        if (prime)
            Console.WriteLine("Prime");
        else
            Console.WriteLine("Not Prime");
    }
}