using System;

public class Program
{
    public static void Main()
    {
        int firstNum = int.Parse(Console.ReadLine());
        int secondNum = int.Parse(Console.ReadLine());
        int thirdNum = int.Parse(Console.ReadLine());

        GetMaxNum(firstNum, secondNum, thirdNum);
    }

    public static void GetMaxNum(int firstNum, int secondNum, int thirdNum)
    {
        int max = int.MinValue;
        if (firstNum >= secondNum && firstNum >= thirdNum)
            max = firstNum;
        else if (secondNum >= firstNum && secondNum >= thirdNum)
            max = secondNum;
        else
            max = thirdNum;

        Console.WriteLine(max);
    }
}