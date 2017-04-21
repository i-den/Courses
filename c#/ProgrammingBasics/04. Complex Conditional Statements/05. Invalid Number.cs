using System;

namespace _05.Invalid_Number
{
    class Program
    {
        static void Main()
        {
            var num = int.Parse(Console.ReadLine());
            bool isInvalid = num >= 100 && num <= 200 || num == 0;

            if (isInvalid)
                return;
            else
                Console.WriteLine("invalid");
        }
    }
}
