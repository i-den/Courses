using System;
using System.Collections.Generic;
using System.Numerics;

class Problem4
{
    static void Main()
    {
        var input = Console.ReadLine().ToCharArray();

        foreach (var item in input)
        {
            var hex = ((int)item).ToString("x");
            Console.Write("\\u00{0}", hex);
        }
        
    }
}