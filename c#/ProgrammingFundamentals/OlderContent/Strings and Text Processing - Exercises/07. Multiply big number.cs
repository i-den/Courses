using System;
using System.Text;

public class Program
{
    public static void Main() //Tova boleshe
    {
        var firstNum = Console.ReadLine().TrimStart('0');
        var secNum = Console.ReadLine();
        
        var smallNum = firstNum.Length > secNum.Length ? secNum : firstNum;
        var bigNum = firstNum.Length > secNum.Length ? firstNum : secNum;
        var tempResultNums = new StringBuilder();
        var totalSum = string.Empty;


        if (firstNum == "0" || secNum == "0")
        {
            Console.WriteLine(0);
            return;
        }

        var naUm = 0;
        var add = 0;

        for (int firstIndex = bigNum.Length - 1, power = 0; firstIndex >= 0; firstIndex--, power++)
        {
            for (int secIndex = smallNum.Length - 1; secIndex >= 0; secIndex--)
            {
                var currFirstNum = int.Parse(firstNum[firstIndex].ToString());
                var currSecNum = int.Parse(secNum[secIndex].ToString());

                var currResult = naUm + (currFirstNum * currSecNum);
                naUm = currResult / 10;
                add = currResult % 10;

                tempResultNums.Insert(0, add);
            }

            if (naUm != 0)
            {
                tempResultNums.Insert(0, naUm.ToString());
            }

            var currentNumber = tempResultNums.ToString() + new string('0', power);
            totalSum = GetStringSum(totalSum, currentNumber);
            tempResultNums.Clear();
            naUm = 0;
        }

        Console.WriteLine(totalSum);
    }

    public static string GetStringSum(string firstStr, string secStr)
    {
        var firstNum = firstStr.TrimStart(new char[] { '0' });
        var secNum = secStr.TrimStart(new char[] { '0' });

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

        return endResult.ToString();
    }
}