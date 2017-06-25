using System;
using System.Collections.Generic;
using System.Linq;

namespace Andre
{
    class Program
    {
        static void Main()
        {
            var productCount = int.Parse(Console.ReadLine());
            var products = new Dictionary<string, decimal>();
            var customersList = new List<Customer>();

            for (int i = 0; i < productCount; i++)
            {
                var input = Console.ReadLine().Split('-');
                var product = input[0];
                var price = decimal.Parse(input[1]);

                if (!products.ContainsKey(product))
                {
                    products[product] = 0M;
                }

                products[product] = price;
            }

            while (true)
            {
                var input = Console.ReadLine();

                if (input == "end of clients")
                {
                    break;
                }

                var tokens = input.Split(new[] { '-', ',' });
                var currName = tokens[0];
                var currProduct = tokens[1];
                var currQuantity = int.Parse(tokens[2]);

                if (!products.ContainsKey(currProduct))
                {
                    continue;
                }

                var currCustomer = new Customer
                {
                    Name = currName,
                    ShopList = new Dictionary<string, int>() { { currProduct, currQuantity } }
                };

                if (customersList.Any(c => c.Name == currName))
                {
                    var existingCustomer = customersList.First(c => c.Name == currName);

                    if (!existingCustomer.ShopList.ContainsKey(currProduct))
                    {
                        existingCustomer.ShopList[currProduct] = 0;
                    }

                    existingCustomer.ShopList[currProduct] += currQuantity;
                }
                else
                {
                    customersList.Add(currCustomer);
                }
            }

            foreach (var currCustomer in customersList)
            {
                var bill = 0M;

                foreach (var kvp in currCustomer.ShopList)
                {
                    var currProduct = kvp.Key;
                    var currProductQuantity = kvp.Value;
                    var totalPriceForCurrProduct = products[currProduct] * currProductQuantity;
                    bill += totalPriceForCurrProduct;
                }

                currCustomer.Bill = bill;
                Customer.TotalBill += bill;
            }

            foreach (var currCustomer in customersList.OrderBy(c => c.Name))
            {
                Console.WriteLine($"{currCustomer.Name}");

                foreach (var kvp in currCustomer.ShopList)
                {
                    var currProduct = kvp.Key;
                    var currProductQuantity = kvp.Value;

                    Console.WriteLine($"-- {currProduct} - {currProductQuantity}");
                }

                var currCustomerBill = currCustomer.Bill;
                Console.WriteLine($"Bill: {currCustomerBill:F2}");
            }

            Console.WriteLine($"Total bill: {Customer.TotalBill:F2}");
        }
    }

    class Customer
    {
        public string Name { get; set; }

        public Dictionary<string, int> ShopList { get; set; }

        public decimal Bill { get; set; }

        public static decimal TotalBill { get; set; }
    }
}