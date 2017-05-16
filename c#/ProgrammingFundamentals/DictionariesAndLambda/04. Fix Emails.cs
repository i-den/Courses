using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    public static void Main()
    {
        var emailList = new Dictionary<string, string>();
        var canContinue = true;

        while (canContinue)
        {
            var input = Console.ReadLine();

            if (input == "stop")
            {
                canContinue = false;
                break;
            }

            var name = input;
            var email = Console.ReadLine();
            var emailDomain = email.Substring(email.Length - 2);

            if (emailDomain != "uk" && emailDomain != "us")
            {
                emailList[name] = email;
            }
        }

        foreach (var userEmailAddressPair in emailList)
        {
            var userName = userEmailAddressPair.Key;
            var emailAddress = userEmailAddressPair.Value;

            Console.WriteLine($"{userName} -> {emailAddress}");
        }
    }
}