package moneycalculator;

import moneycalculator.control.CalculateCommand;
import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;
import moneycalculator.persistence.CurrencyListLoader;
import moneycalculator.persistence.ExchangeRateLoader;
import moneycalculator.persistence.files.FileCurrencyListLoader;

public class Main {

    public static void main(String[] args) {
        CurrencyListLoader loader = new FileCurrencyListLoader("currencies");
        MainFrame mainFrame = new MainFrame(loader.load());
        mainFrame.add(
            new CalculateCommand(
                mainFrame.getMoneyDialog(), 
                mainFrame.getMoneyDisplay(),
                loader()
            ));
    }

    private static ExchangeRateLoader loader() {
        return new ExchangeRateLoader() {

            @Override
            public ExchangeRate load(Currency from, Currency to) {
                return new ExchangeRate(from, to, 1.15);
            }
        };
    }

    
}
