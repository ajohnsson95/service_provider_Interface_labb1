package Interface.Impl;

import Interface.CurrencyConverter;

public class DynamicCurrencyConverter implements CurrencyConverter {
    @Override
    public double convert(double amount, String fromCurrency, String toCurrency) {
        if (fromCurrency.equals("USD") && toCurrency.equals("SEK")) {
            double rate = Math.random() * (10 - 6) + 6;
            return amount * rate;
        } else if (fromCurrency.equals("SEK") && toCurrency.equals("USD")) {
            double rate = Math.random() * (10 - 6) + 6;
            return amount / rate;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("SEK")) {
            double rate = Math.random() * (11 - 7) + 7;
            return amount * rate;
        } else if (fromCurrency.equals("SEK") && toCurrency.equals("EUR")) {
            double rate = Math.random() * (11 - 7) + 7;
            return amount / rate;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("USD")) {
            double rate = Math.random() * (1.3 - 1.1) + 1.1;
            return amount * rate;
        } else if (fromCurrency.equals("USD") && toCurrency.equals("EUR")) {
            double rate = Math.random() * (1.3 - 1.1) + 1.1;
            return amount / rate;
        } else {
            throw new IllegalArgumentException("Ogiltligt val: " + fromCurrency + " till " + toCurrency);
        }
    }
}