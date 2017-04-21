using System;

namespace _05.Max_Number
{
    class Program
    {
        static void Main(string[] args)
        {
            int num = int.Parse(Console.ReadLine());
            int biggestNum = int.MinValue;
            for (int i = 0; i < num; i++)
            {
                int entryNum = int.Parse(Console.ReadLine());
                if (entryNum > biggestNum)
                    biggestNum = entryNum;
            }
            Console.WriteLine(biggestNum);
        } 
    }
}
