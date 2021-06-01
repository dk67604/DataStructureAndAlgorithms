package main.java.arraysstrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindErrorPricing {

    public static int priceCheck(List<String> products, List<Float> productPrices,
                                 List<String> productSold, List<Float> soldPrice
    ) {
        Map<String, Float> productPriceLookup = new HashMap<>();
        for (int i = 0; i < products.size(); i++) {
            productPriceLookup.put(products.get(i).toLowerCase(), productPrices.get(i));
        }
        int error = 0;
        for (int i = 0; i < productSold.size(); i++) {
            String product = productSold.get(i).toLowerCase();
            if (productPriceLookup.containsKey(product)) {
                if (productPriceLookup.get(product).floatValue() != soldPrice.get(i).floatValue()) {
                    error++;
                }
            }
        }
        return error;
    }

    public static void main(String[] args) {
        List<String> products = Arrays.asList("egg", "milk", "cheese");
        List<Float> productPrices = Arrays.asList(2.89f, 3.29f, 5.79f);
        List<String> productSold = Arrays.asList("egg", "egg", "cheese", "milk");
        List<Float> soldPrice = Arrays.asList(2.89f, 2.99f, 5.97f, 3.29f);
        System.out.println(priceCheck(products, productPrices, productSold, soldPrice));
        products = Arrays.asList("rice", "sugar", "wheat", "cheese");
        productPrices = Arrays.asList(16.89f, 56.92f, 20.89f, 345.99f);
        productSold = Arrays.asList("rice", "cheese");
        soldPrice = Arrays.asList(18.99f, 400.89f);
        System.out.println(priceCheck(products, productPrices, productSold, soldPrice));
        products = Arrays.asList("chocolate", "cheese", "tomato");
        productPrices = Arrays.asList(15.00f, 300.90f, 23.44f);
        productSold = Arrays.asList("chocolate", "cheese", "tomato");
        soldPrice = Arrays.asList(15f, 300.90f, 10.00f);
        System.out.println(priceCheck(products, productPrices, productSold, soldPrice));

    }
}
