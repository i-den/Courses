using System;
using System.Text;

public class Program
{
    public static void Main()
    {
        var firstNum = Console.ReadLine().TrimStart(new char[] { '0' });
        var secNum = Console.ReadLine().TrimStart(new char[] { '0' });

        var endResult = new StringBuilder();

        if (firstNum.Length > secNum.Length)
        {
            secNum = secNum.PadLeft(firstNum.Length, '0');
        }
        else if (firstNum.Length < secNum.Length)
        {
            firstNum = firstNum.PadLeft(secNum.Length, '0');
        }

        var remainderToAdd = 0;

        for (int i = firstNum.Length - 1; i >= 0; i--)
        {
            var firstChar = int.Parse(firstNum[i].ToString());
            var secChar = int.Parse(secNum[i].ToString());

            var currentResult = firstChar + secChar + remainderToAdd;
            remainderToAdd = 0;

            if (currentResult >= 10)
            {
                remainderToAdd = currentResult / 10;
                currentResult %= 10;
            }

            endResult.Insert(0, currentResult);
        }

        if (remainderToAdd == 1)
        {
            endResult.Insert(0, "1");
        }

        Console.WriteLine(endResult);
    }
}