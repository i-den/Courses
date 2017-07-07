using System;
class Program
{
    public static void Main()
    {
        var n = int.Parse(Console.ReadLine()); //Брой товара

        var mBus = 200;
        var Truck = 175;
        var Train = 120;

        var BusCount = 0;
        var TruckCount = 0;
        var TrainCount = 0;

        var totalWeight = 0;

        for (int count = 0; count < n; count++)
        {
            var weight = int.Parse(Console.ReadLine());

            totalWeight += weight;

            if (weight <= 3) BusCount += weight;
            else if (weight <= 11) TruckCount += weight;
            else TrainCount += weight;
        }

        var Price = BusCount * mBus + TruckCount * Truck + TrainCount * Train;
        var PriceAVG = (double)Price / (double)totalWeight;

        var busPercent = BusCount / (double)totalWeight * 100;
        var truckPercent = TruckCount / (double)totalWeight * 100;
        var trainPercent = TrainCount / (double)totalWeight * 100;

        Console.WriteLine("{0:f2}", PriceAVG);
        Console.WriteLine("{0:f2}%", busPercent);
        Console.WriteLine("{0:f2}%", truckPercent);
        Console.WriteLine("{0:f2}%", trainPercent);
    }
}