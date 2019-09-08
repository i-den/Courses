using System;
using System.Collections.Generic;
using System.Text;

class Problem4
{
    static void Main()
    {
        var firstNumber = Console.ReadLine().TrimStart(new char[] { '0' });
        var secNumber = Console.ReadLine().TrimStart(new char[] { '0' }); ;
        var result = new StringBuilder();

        if (firstNumber.Length > secNumber.Length)
        {
            secNumber = secNumber.PadLeft(firstNumber.Length, '0');
        }
        else if (firstNumber.Length < secNumber.Length)
        {
            firstNumber = firstNumber.PadLeft(secNumber.Length, '0');
        }

        var n1 = firstNumber.ToCharArray();
        var n2 = secNumber.ToCharArray();


        var addition = 0;
        var remainder = 0;

        for (int i = firstNumber.Length - 1; i >= 0; i--)
        {
            var currFirstNumber = int.Parse(n1[i].ToString());
            var currSecondNumber = int.Parse(n2[i].ToString());
            currFirstNumber += addition;
            addition = 0;

            var currentNumberSum = currFirstNumber + currSecondNumber;

            if (currentNumberSum < 10)
            {
                result.Append(currentNumberSum);
            }
            else
            {
                remainder = (currentNumberSum) % 10;
                result.Append(remainder);
                addition = (currentNumberSum) / 10;
            }
        }

        if (addition != 0)
        {
            result.Append(addition);
        }

        var endResult = result.ToString().ToCharArray();
        Array.Reverse(endResult);

        Console.WriteLine(string.Join("", endResult));
    }
}