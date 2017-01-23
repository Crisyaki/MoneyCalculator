package moneycalculator.persistence.files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import moneycalculator.model.Currency;
import moneycalculator.persistence.CurrencyListLoader;

public class FileCurrencyListLoader implements CurrencyListLoader{
    
    private final String filename;

    public FileCurrencyListLoader(String filename) {
        this.filename = filename;
    }
    
    @Override
    public Currency[] load() {
        List<Currency> currencies = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                String[] split = line.split(",");
                currencies.add(new Currency(split[0], split[1], split[2]));
            }
        } 
        catch (IOException ex) {
        }
        return currencies.toArray(new Currency[0]);
    }
    
}
