using System;

class Program
{
    public static void Main()
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