using System;
using System.Collections.Generic;

class Problem4
{
    static void Main()
    {
        var input = Console.ReadLine().Split();
        var minStr = string.Empty;
        var maxStr = string.Empty;
        var result = true;
        var myDict = new Dictionary<char, char>();

        GetMinAndMaxStrings(input[0], input[1], out minStr, out maxStr);

        for (int i = 0; i < minStr.Length; i++)
        {
            var firstChar = minStr[i];
            var secChar = maxStr[i];

            if (!myDict.ContainsKey(firstChar))
            {
                if (!myDict.ContainsValue(secChar))
                {
                    myDict.Add(firstChar, secChar);
                }
                else
                {
                    result = false;
                    break;
                }
            }
            else
            {
                if (myDict[firstChar] != secChar)
                {
                    result = false;
                    break;
                }
            }
        }

        if (minStr.Length != maxStr.Length & result)
        {
            string restChars = maxStr.Substring(minStr.Length);

            foreach (var charA in restChars)
            {
                if (!myDict.ContainsValue(charA) && !myDict.ContainsKey(charA))
                {
                    result = false;
                    break;
                }
            }
        }

        Console.WriteLine("{0}", result ? "true" : "false");
    }

    private static void GetMinAndMaxStrings(string v1, string v2, out string minStr, out string maxStr)
    {
        if (v1.Length > v2.Length)
        {
            minStr = v2;
            maxStr = v1;
        }
        else
        {
            minStr = v1;
            maxStr = v2;
        }
    }
}