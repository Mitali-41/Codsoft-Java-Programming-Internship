import java.util.Scanner;

public class CurrencyConverter {

   
    public static double getExchangeRate(String baseCurrency, String targetCurrency) {
        // Mock exchange rates
        if (baseCurrency.equals("USD") && targetCurrency.equals("INR")) {
            return 82.50; // Example: 1 USD = 82.50 INR
        } else if (baseCurrency.equals("INR") && targetCurrency.equals("USD")) {
            return 0.012; // Example: 1 INR = 0.012 USD
        } else if (baseCurrency.equals("USD") && targetCurrency.equals("EUR")) {
            return 0.92; // Example: 1 USD = 0.92 EUR
        } else {
            return 1.0; // Default (for same currency)
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Currency Selection
        System.out.println("Welcome to the Currency Converter!");
        System.out.print("Enter the base currency (e.g., USD, INR): ");
        String baseCurrency = scanner.nextLine().toUpperCase();
        System.out.print("Enter the target currency (e.g., USD, INR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        // Step 2: Amount Input
        System.out.print("Enter the amount in " + baseCurrency + ": ");
        double amount = scanner.nextDouble();

        // Step 3: Fetch Exchange Rate and Perform Conversion
        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);
        double convertedAmount = amount * exchangeRate;

        // Step 4: Display Result
        System.out.printf("Converted amount: %.2f %s%n", convertedAmount, targetCurrency);

        scanner.close();
    }
}
