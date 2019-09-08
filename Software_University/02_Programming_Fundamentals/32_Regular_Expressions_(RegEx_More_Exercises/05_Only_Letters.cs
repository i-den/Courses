using System;
using System.Text.RegularExpressions;

public class Program
{
    public static void Main()
    {
        Console.WriteLine(Regex.Replace(
            Console.ReadLine(), @"[\d]+(?<lett>[a-zA-Z])",
            w => (w.Groups["lett"].Value.ToString() + w.Groups["lett"].Value.ToString())));
    }
}