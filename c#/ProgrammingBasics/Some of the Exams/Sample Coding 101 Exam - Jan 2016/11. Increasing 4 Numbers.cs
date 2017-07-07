using System;

class Program
{
    public static void Main()
    {
        int a = int.Parse(Console.ReadLine());
        int b = int.Parse(Console.ReadLine());

        var count = 0;

        for (int q = a; q <= b; q++)
        {
            for (int w = a; w <= b; w++)
            {
                for (int e = a; e <= b; e++)
                {
                    for (int r = a; r <= b; r++)
                    {
                        if (w > q && e > w && r > e)
                        {
                            Console.WriteLine($"{q} {w} {e} {r}");
                            count++;
                        }

                    }
                }
            }
        }

        if (count == 0)
            Console.WriteLine("No");
    }
}