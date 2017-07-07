using System;


class Program
{
    public static void Main()
    {
        var h = int.Parse(Console.ReadLine());
        var x = int.Parse(Console.ReadLine());
        var y = int.Parse(Console.ReadLine());

        var xminlower = 0;
        var xmaxlower = h * 3;
        var yminlower = 0;
        var ymaxlower = h;

        var xminupper = h;
        var xmaxupper = h * 2;
        var yminupper = h;
        var ymaxupper = h * 4;


        if (x >= xminupper + 0.1 && x <= xmaxupper - 0.1 && y == ymaxlower)
        {
            Console.WriteLine("inside");
        }
        else if (x >= xminlower + 0.1 && x <= xmaxlower - 0.1 && y >= yminlower + 0.1 && y <= ymaxlower - 0.1)
        {
            Console.WriteLine("inside");
        }
        else if (x >= xminupper + 0.1 && x <= xmaxupper - 0.1 && y >= yminupper + 0.1 && y <= ymaxupper - 0.1)
        {
            Console.WriteLine("inside");
        }
        else if (x >= xminlower && x <= xmaxlower && y == 0)
        {
            Console.WriteLine("border");
        }
        else if (x == 0 && y >= yminlower && y <= ymaxlower)
        {
            Console.WriteLine("border");
        }
        else if (x >= xminlower && x <= xminupper && y == h)
        {
            Console.WriteLine("border");
        }
        else if (x == xminupper && y >= yminupper && y <= ymaxupper)
        {
            Console.WriteLine("border");
        }
        else if (x >= xminupper && x <= xmaxupper && y == ymaxupper)
        {
            Console.WriteLine("border");
        }
        else if (x == xmaxupper && y >= yminupper && y <= ymaxupper)
        {
            Console.WriteLine("border");
        }
        else if (x >= xmaxupper && x <= xmaxlower && y == ymaxlower)
        {
            Console.WriteLine("border");
        }
        else if (y >= 0 && y <= h && x == h * 3)
        {
            Console.WriteLine("border");
        }
        else
        {
            Console.WriteLine("outside");
        }
    }
}