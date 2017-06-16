using System;
using System.Linq;

class Program
{
    static void Main()
    {
        var inputList = Console.ReadLine().Split().ToList();
        var nums = Console.ReadLine().Split().Select(int.Parse).ToList();

        Console.WriteLine(inputList.Take(nums[0]).Skip(nums[1]).Where(x => x == nums[2].ToString()).Any()
            ? "YES!"
            : "NO!");
    }
}