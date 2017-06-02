using System;


class Program
{
    static void Main()
    {
        var n = int.Parse(Console.ReadLine());

        for (int i = 1; i <= n; i++)
        {
            bool checkSpecial = false;
            int sum = 0;
            int digit = i;
            while (digit != 0)
            {
                sum += digit % 10;
                digit /= 10;
            }
            if (sum == 5 || sum == 7 || sum == 11) checkSpecial = true;
            Console.WriteLine("{0} -> {1}", i, checkSpecial);
        }

    }
}

