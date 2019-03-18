import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {

    private static final String STR_TO_END_INPUT = "Revision";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, Double>> shopProductsPrice = new TreeMap<>();

        String input;
        while (!STR_TO_END_INPUT.equals((input = scanner.nextLine()))) {
            String[] shopProductPriceTokens = input.split("[\\s,]+");

            shopProductsPrice.putIfAbsent(shopProductPriceTokens[0], new LinkedHashMap<>());
            LinkedHashMap<String, Double> currShopProductsPrice = shopProductsPrice.get(shopProductPriceTokens[0]);

            currShopProductsPrice.put(shopProductPriceTokens[1], Double.parseDouble(shopProductPriceTokens[2]));
        }

        for (String shop : shopProductsPrice.keySet()) {
            LinkedHashMap<String, Double> currShopProductsPrice = shopProductsPrice.get(shop);

            System.out.printf("%s->%s", shop, System.lineSeparator());
            for (String product : currShopProductsPrice.keySet()) {
                System.out.printf(
                        "Product: %s, Price: %.1f%s",
                        product,
                        currShopProductsPrice.get(product),
                        System.lineSeparator()
                );
            }
        }
    }
}