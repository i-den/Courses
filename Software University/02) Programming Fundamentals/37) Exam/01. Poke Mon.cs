namespace Problems
{
    using System;
    
    public class ProblemA
    {
        public static void Main()
        {
            var n = ulong.Parse(Console.ReadLine());
            var m = ulong.Parse(Console.ReadLine());
            var y = ulong.Parse(Console.ReadLine());

            var targetsPoked = 0;
            var fiftyValue = n / 2D;

            while (true)
            {
                n -= m;

                if (n < 0)
                {
                    break;
                }

                targetsPoked++;

                if (n == fiftyValue)
                {
                    try
                    {
                        n /= y;
                    }
                    catch (Exception)
                    {
                        continue;
                    }
                }

                if (m > n)
                {
                    break;
                }
            }

            Console.WriteLine(n);
            Console.WriteLine(targetsPoked);
        }
    }
}