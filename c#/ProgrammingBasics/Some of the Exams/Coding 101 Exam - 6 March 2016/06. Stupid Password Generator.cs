using System;

class Program
{
    public static void Main()
    {
        var n = int.Parse(Console.ReadLine());
        var l = int.Parse(Console.ReadLine());

        for (int i = 1; i <= n; i++)
        {
            for (int b = 1; b < n; b++)
            {
                for (int c = 97; c < 97 + l; c++)
                {
                    for (int d = 97; d < 97 + l; d++)
                    {
                        for (int e = 1; e <= n; e++)
                        {
                            if (e > i && e > b)
                                Console.Write("{0}{1}{2}{3}{4} ", i, b, (char)c, (char)d, e);
                        }
                    }
                }
            }
        }
    }
}