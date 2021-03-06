﻿using System;
using System.Numerics;


public class Program
{
    public static void Main()
    {
        var centuries = int.Parse(Console.ReadLine());
        var years = centuries * 100;
        var days = (int)(years * 365.2422);
        var hours = days * 24;
        ulong minutes = (ulong)hours * 60;
        ulong seconds = minutes * 60;
        BigInteger milliseconds = seconds * 1000;
        BigInteger microseconds = milliseconds * 1000;
        BigInteger nanoseconds = microseconds * 1000;

        Console.WriteLine($"{centuries} centuries = {years} years = {days} days = {hours} hours = {minutes} minutes = {seconds} seconds = {milliseconds} milliseconds = {microseconds} microseconds = {nanoseconds} nanoseconds");
    }
}