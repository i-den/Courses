using System;

class Program
{
    static void Main()
    {
        var text = Console.ReadLine();

        var index = 0;
        var power = 0;
        var oldPower = 0;

        while ((index = text.IndexOf('>', index)) > 0)
        {
            power = int.Parse(text[index + 1].ToString()) + oldPower;
            oldPower = power;
            var currPower = 0;

            for (int i = 0; i < power; i++)
            {
                var currIndex = index + 1 + i;

                try
                {
                    if (text[currIndex] != '>')
                    {
                        oldPower--;
                        currPower++;
                    }
                    else
                    {
                        break;
                    }
                }
                catch (Exception)
                {
                    continue;
                } 
            }

            text = text.Remove(index + 1, currPower);

            index++;
        }

        Console.WriteLine(text);
    }
}