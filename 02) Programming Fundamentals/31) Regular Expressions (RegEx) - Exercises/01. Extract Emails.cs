using System;
using System.Text.RegularExpressions;

class Program
{
    static void Main()
    {
        var inputText = Console.ReadLine();
        var a = new Regex(@"(?<=\s)[a-z0-9]+([-.]\w+)*@([a-z]+[-]?)+([.]\w+)+");

        var matches = a.Matches(inputText);

        foreach (Match match in matches)
        {
            Console.WriteLine($"{match}");
        }
    }
}