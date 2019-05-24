using System;


class Program
{
    static void Main()
    {
        var n = int.Parse(Console.ReadLine());

        for (int firstNum = 97; firstNum < 97 + n; firstNum++)
        {
            for (int secondNum = 97; secondNum < 97 + n; secondNum++)
            {
                for (int thirdNum = 97; thirdNum < 97 + n; thirdNum++)
                {
                    Console.WriteLine("{0}{1}{2}", (char)firstNum, (char)secondNum, (char)thirdNum);
                }
            }
        }
    }
}

