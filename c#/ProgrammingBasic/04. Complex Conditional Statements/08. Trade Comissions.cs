using System;

class Program
{
    public static void Main()
    {
        var city = Console.ReadLine().ToLower();
        var sales = double.Parse(Console.ReadLine());

        var comm = 0.0;

        if (city == "sofia")
        {
            if (sales >= 0 && sales <= 500)
            {
                comm = sales * 0.05;
            }
            if (sales > 500 && sales <= 1000)
            {
                comm = sales * 0.07;
            }
            if (sales > 1000 && sales <= 10000)
            {
                comm = sales * 0.08;
            }
            if (sales > 10000)
            {
                comm = sales * 0.12;
            }
            Console.WriteLine(comm);
        }
        else
        {
            Console.WriteLine("error");
        }

        if (city == "varna")
        {
            if (sales >= 0 && sales <= 500)
            {
                comm = sales * 0.045;
            }
            if (sales > 500 && sales <= 1000)
            {
                comm = sales * 0.075;
            }
            if (sales > 1000 && sales <= 10000)
            {
                comm = sales * 0.1;
            }
            if (sales > 10000)
            {
                comm = sales * 0.13;
            }
            Console.WriteLine(comm);
        }
        else
        {
            Console.WriteLine("error");
        }

        if (city == "plovdiv")
        {
            if (sales >= 0 && sales <= 500)
            {
                comm = sales * 0.055;
            }
            if (sales > 500 && sales <= 1000)
            {
                comm = sales * 0.08;
            }
            if (sales > 1000 && sales <= 10000)
            {
                comm = sales * 0.12;
            }
            if (sales > 10000)
            {
                comm = sales * 0.145;
            }
            Console.WriteLine(comm);
        }
        else
        {
            Console.WriteLine("error");
        }
    }
}