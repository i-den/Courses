using System;
using System.Collections.Generic;

public class Program
{
    public static void Main()
    {
        var inputNumber = Console.ReadLine();
        var resultList = new List<string>();

        var longParse = true;
        var uintParse = true;
        var intParse = true;
        var ushortParse = true;
        var shortParse = true;
        var byteParse = true;
        var sbyteParse = true;
        
            try
            {
                var longParsed = long.Parse(inputNumber);
            }
            catch (Exception)
            {
                longParse = false;
            }
            try
            {
                var uintParsed = uint.Parse(inputNumber);
            }
            catch (Exception)
            {
                uintParse = false;
            }
            try
            {
                var intParsed = int.Parse(inputNumber);
            }
            catch (Exception)
            {
                intParse = false;
            }
            try
            {
                var ushortParsed = ushort.Parse(inputNumber);
            }
            catch (Exception)
            {
                ushortParse = false;
            }
            try
            {
                var shortParsed = short.Parse(inputNumber);
            }
            catch (Exception)
            {
                shortParse = false;
            }
            try
            {
                var bytePrsed = byte.Parse(inputNumber);
            }
            catch (Exception)
            {
                byteParse = false;
            }
            try
            {
                var sbyteParsed = sbyte.Parse(inputNumber);
            }
            catch (Exception)
            {
                sbyteParse = false;
            }

        if (sbyteParse)
        {
            resultList.Add("sbyte");
        }
        if (byteParse)
        {
            resultList.Add("byte");
        }
        if (shortParse)
        {
            resultList.Add("short");
        }
        if (ushortParse)
        {
            resultList.Add("ushort");
        }
        if (intParse)
        {
            resultList.Add("int");
        }
        if (uintParse)
        {
            resultList.Add("uint");
        }
        if (longParse)
        {
            resultList.Add("long");
        }


        if (resultList.Count != 0)
        {
            Console.WriteLine($"{inputNumber} can fit in: ");
            foreach (var str in resultList)
            {
                    Console.WriteLine($"* {str}");
            }
        }
        else
        {
            Console.WriteLine($"{inputNumber} can't fit in any type");
        }
    }
}