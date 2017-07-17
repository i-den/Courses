using System;

public class Program
{
    public static void Main()
    {
        var inputArr = new char[3];

        for (int i = 0; i < 3; i++)
        {
            inputArr[i] = char.Parse(Console.ReadLine());
        }

        for (int i = inputArr.Length - 1; i >= 0; i--)
        {
            Console.Write(inputArr[i]);
        }
    }
}