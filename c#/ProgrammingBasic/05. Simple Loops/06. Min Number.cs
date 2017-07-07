using System;

class Program
{
    public static void Main()
    {
        int num = int.Parse(Console.ReadLine());
        int firstSum = 0;
        int secondSum = 0;

        for (int i = 0; i < num; i++)
        {
            int firstNum = int.Parse(Console.ReadLine());
            firstSum += firstNum;
        }
        for (int i = 0; i < num; i++)
        {
            int firstNum = int.Parse(Console.ReadLine());
            secondSum += firstNum;
        }
        if (firstSum == secondSum)
            Console.WriteLine("Yes, sum = {0}", firstSum);
        else
            Console.WriteLine("No, diff = {0}", Math.Abs(firstSum - secondSum));
    }
}