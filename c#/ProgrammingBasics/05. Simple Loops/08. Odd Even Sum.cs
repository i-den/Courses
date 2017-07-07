using System;

class Program
{
    public static void Main()
    {
        var n = int.Parse(Console.ReadLine());
        var evensum = 0;
        var oddsum = 0;

        for (int i = 1; i <= n; i++)
        {

            var add = int.Parse(Console.ReadLine());

            if (i % 2 == 0)
            {
                evensum += add;
            }
            else
            {
                oddsum += add;
            }
        }

        if (evensum == oddsum)
        {
            Console.WriteLine("Yes, sum = " + evensum);
        }
        else
        {
            Console.WriteLine("No, diff = " + Math.Abs(evensum - oddsum));
        }

    }
}