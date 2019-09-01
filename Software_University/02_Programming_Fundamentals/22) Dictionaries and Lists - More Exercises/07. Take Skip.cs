using System;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var str = Console.ReadLine();

        var nums = str.Where(x => char.IsDigit(x)).ToList();
        var chars = str.Where(x => !char.IsDigit(x)).ToList();
        var takeNums = nums.Where((x, index) => index % 2 == 0).Select(x => int.Parse(x.ToString())).ToList();
        var skipNums = nums.Where((x, index) => index % 2 == 1).Select(x => int.Parse(x.ToString())).ToList();

        var strToPrint = string.Empty;
        var charToSkip = 0;

        for (int i = 0; i < takeNums.Count(); i++)
        {
            strToPrint += string.Join("", chars.Skip(charToSkip).Take(takeNums[i]).ToList());
            charToSkip += takeNums[i] + skipNums[i];
        }

        Console.WriteLine(strToPrint);
    }
}