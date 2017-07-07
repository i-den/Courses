using System;

class Program
{
    public static void Main()
    {
        var n = int.Parse(Console.ReadLine());
        var currbiggestnum = 0;
        var numsum = 0;
        for (int i = 1; i <= n; i++)
        {
            var num = int.Parse(Console.ReadLine());
            if (num > currbiggestnum)
            {
                currbiggestnum = num;
            }
            numsum += num;
        }

        if (currbiggestnum == (numsum - currbiggestnum))
        {
            Console.WriteLine("Yes, sum = " + currbiggestnum);
        }
        else
        {
            Console.WriteLine("No, diff = " + Math.Abs((currbiggestnum - (numsum - currbiggestnum))));
        }
    }
}