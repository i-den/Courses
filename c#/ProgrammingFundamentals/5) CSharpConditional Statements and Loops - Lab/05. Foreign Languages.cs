using System;
using System.Collections.Generic;

public class Program
{
    public static void Main()
    {
        var country = Console.ReadLine();
        var language = string.Empty;

        switch (country)
        {
            case "USA":
            case "England":
                language = "English"; break;

            case "Spain":
            case "Argentina":
            case "Mexico":
                language = "Spanish"; break;

            default:
                language = "unknown"; break;
        }

        Console.WriteLine(language);
    }
}