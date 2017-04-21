using System;

namespace _03.Powers_of_Two
{
    class Program
    {
        static void Main()
        {
            var n = int.Parse(Console.ReadLine());
            
            for (int i = 0, num = 1; i <= n; i++, num *=2)
            {
                Console.WriteLine(num);
                
            }
        }
    }
}
