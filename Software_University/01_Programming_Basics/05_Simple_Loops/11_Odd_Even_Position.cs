using System;

class Program
{
    public static void Main()
    {
        int n = int.Parse(Console.ReadLine());
        double OddSum = 0;
        double OddMin = double.MaxValue;
        double OddMax = double.MinValue;
        double EvenSum = 0;
        double EvenMin = double.MaxValue;
        double EvenMax = double.MinValue;
        bool OddNo = false;
        bool EvenNo = false;

        for (int i = 1; i <= n; i++)
        {
            double iNum = double.Parse(Console.ReadLine());
            if (i % 2 != 0)
            {
                OddSum += iNum;
                if (iNum < OddMin) { OddMin = iNum; OddNo = true; }
                if (iNum > OddMax) { OddMax = iNum; OddNo = true; }
            }
            else
            {
                EvenSum += iNum;
                if (iNum < EvenMin) { EvenMin = iNum; EvenNo = true; }
                if (iNum > EvenMax) { EvenMax = iNum; EvenNo = true; }
            }
        }

        Console.WriteLine($"OddSum={OddSum},");

        if (!OddNo)
        {
            Console.WriteLine("OddMin=No,");
            Console.WriteLine("OddMax=No,");
        }
        else
        {
            Console.WriteLine($"OddMin={OddMin},");
            Console.WriteLine($"OddMax={OddMax},");
        }

        Console.WriteLine($"EvenSum={EvenSum},");

        if (!EvenNo)
        {
            Console.WriteLine("EvenMin=No,");
            Console.WriteLine("EvenMax=No");
        }
        else
        {
            Console.WriteLine($"EvenMin={EvenMin},");
            Console.WriteLine($"EvenMax={EvenMax}");
        }
    }
}