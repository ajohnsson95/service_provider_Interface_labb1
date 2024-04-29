import Interface.CurrencyConverter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServiceLoader<CurrencyConverter> loader = ServiceLoader.load(CurrencyConverter.class);

        List<CurrencyConverter> converters = new ArrayList<>();
        loader.forEach(converters::add);

        while (true) {
            System.out.println("Välj en valutakonverterare (eller skriv 'exit' för att avsluta):");
            for (int i = 0; i < converters.size(); i++) {
                System.out.println(i + 1 + ". " + converters.get(i).getClass().getSimpleName());
            }

            String input = scanner.nextLine().trim();
            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("Programmet avslutas...");
                break;
            }

            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ogiltig inmatning, försök igen.");
                continue;
            }

            if (choice < 1 || choice > converters.size()) {
                System.out.println("Vald nummer är inte inom tillgänglig omfång, försök igen.");
                continue;
            }

            CurrencyConverter converter = converters.get(choice - 1);

            System.out.println("Ange belopp, frånvaluta och tillvaluta (ex. 100 USD SEK) tillåtna valutor (USD, EUR, SEK):");
            if (!scanner.hasNextDouble()) {
                System.out.println("Förväntade ett numeriskt belopp, men fick '" + scanner.nextLine() + "'");
                continue;
            }
            double amount = scanner.nextDouble();
            String fromCurrency = scanner.next().toUpperCase();
            String toCurrency = scanner.next().toUpperCase();
            scanner.nextLine();

            try {
                double convertedAmount = converter.convert(amount, fromCurrency, toCurrency);
                System.out.printf("Konverterat belopp: %.2f %s\n", convertedAmount, toCurrency);
            } catch (IllegalArgumentException e) {
                System.out.println("Ogiltig konvertering: " + e.getMessage());
            }
        }
    }
}