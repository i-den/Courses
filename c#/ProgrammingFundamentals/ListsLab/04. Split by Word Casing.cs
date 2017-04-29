using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        char[] separators = { ',', ';', ':', '.', '!', '(', ')', '"', '\'', '/', '\\', '[', ']', ' ' };

        var myList = Console.ReadLine().Split(separators).ToList();

        var lowerCaseList = new List<string>();
        var mixedCaseList = new List<string>();
        var upperCaseList = new List<string>();

        for (int i = 0; i < myList.Count; i++)
        {
            string currentWord;

            if (myList[i] != string.Empty)
            {
                currentWord = myList[i];
            }
            else
            {
                continue;
            }

            bool isLowerCase = false;
            bool isMixedCase = false;
            bool isUpperCase = false;

            CheckCasing(currentWord, ref isLowerCase, ref isMixedCase, ref isUpperCase);

            AddToListDependingOnCasing(lowerCaseList, mixedCaseList, upperCaseList, currentWord, isLowerCase, isMixedCase, isUpperCase);
        }

        Console.WriteLine("Lower-case: {0}", lowerCaseList.Count > 0 ? string.Join(", ", lowerCaseList) : string.Empty);
        Console.WriteLine("Mixed-case: {0}", mixedCaseList.Count > 0 ? string.Join(", ", mixedCaseList) : string.Empty);
        Console.WriteLine("Upper-case: {0}", upperCaseList.Count > 0 ? string.Join(", ", upperCaseList) : string.Empty);
    }

    public static void CheckCasing(string currentWord, ref bool isLowerCase, ref bool isMixedCase, ref bool isupperCase)
    {
        int lowerSum = 0;
        int upperSum = 0;

        for (int j = 0; j < currentWord.Length; j++)
        {
            if (char.IsLower(currentWord[j]))
            {
                lowerSum++;
            }
            else if (char.IsUpper(currentWord[j]))
            {
                upperSum++;
            }
        }

        if (lowerSum == currentWord.Length)
        {
            isLowerCase = true;
        }
        else if (upperSum == currentWord.Length)
        {
            isupperCase = true;
        }
        else
        {
            isMixedCase = true;
        }
    }

    public static void AddToListDependingOnCasing(List<string> lowerCaseList, List<string> mixedCaseList, List<string> upperCaseList, string currentWord, bool isLowerCase, bool isMixedCase, bool isupperCase)
    {
        if (isLowerCase)
        {
            lowerCaseList.Add(currentWord);
        }
        else if (isMixedCase)
        {
            mixedCaseList.Add(currentWord);
        }
        else if (isupperCase)
        {
            upperCaseList.Add(currentWord);
        }
    }
}