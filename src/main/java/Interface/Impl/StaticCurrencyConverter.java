package Interface.Impl;

import Interface.CurrencyConverter;

public class StaticCurrencyConverter implements CurrencyConverter {
    @Override
    public double convert(double amount, String fromCurrency, String toCurrency) {
        if (fromCurrency.equals("USD") && toCurrency.equals("SEK")) {
            return amount * 8.5;
        } else if (fromCurrency.equals("SEK") && toCurrency.equals("USD")) {
            return amount / 8.5;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("SEK")) {
            return amount * 10;
        } else if (fromCurrency.equals("SEK") && toCurrency.equals("EUR")) {
            return amount / 10;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("USD")) {
            return amount * 1.15;
        } else if (fromCurrency.equals("USD") && toCurrency.equals("EUR")) {
            return amount / 1.15;
        } else {
            throw new IllegalArgumentException("Ogiltlig valuta omvandling: " + fromCurrency + " till " + toCurrency);
        }
    }
}