using System;
using System.Linq;


namespace test
{
    class Program
    {
        static void Main()
        {
            //Get distance
            double distance = double.Parse(Console.ReadLine());
            //Get day / night
            string solus = Console.ReadLine().ToLower();

            //Define transport rates. Set to MaxValues to get the lowest amongst afterwards in case any of them
            //isn't included
            double taxiFee = double.MaxValue;
            double busFee = double.MaxValue;
            double trainFee = double.MaxValue;

            //Setting fee rates and taking in consideration whether a transport option is available
            if (solus == "day") //defining taxi fee at all times
                taxiFee = 0.70 + 0.79 * distance;
            else
                taxiFee = 0.70 + 0.9 * distance;

            if (distance >= 20) //defining bus fee only when distance is 20 or greater, otherwise it's MaxValue
                busFee = 0.09 * distance;

            if (distance >= 100) //defining train fee only when distance is 100 or greater, otherwise it's MaxValue
                trainFee = 0.06 * distance;

            //Printing the lowest price, if any isn't included due to the distance it's MaxValue
            Console.WriteLine(Math.Min(Math.Min(taxiFee, busFee), trainFee));
        }
    }
}
