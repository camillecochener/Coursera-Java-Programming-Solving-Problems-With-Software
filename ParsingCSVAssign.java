
/**
 * This class contains methods that allows to describe a CSV files.
 *
 * @camillecochener
 * @21 septembre 2019
 */

import edu.duke.*;
import org.apache.commons.csv.*;

public class ParsingCSVAssign {
    
    public void countryInfo(CSVParser parser, String country){
        for (CSVRecord record : parser){
            String pays = record.get("Country");
            if (pays.contains(country)){
                String export = record.get("Exports");
                String value = record.get("Value (dollars)");
                System.out.println(country + " : " + export + " : " + value);
            }
        }
    }
    
    public void listExportersTwoProducts(CSVParser parser, 
                                String exportitem1, String exportitem2){
        for (CSVRecord record : parser){
            String export = record.get("Exports");
            if (export.contains(exportitem1) && export.contains(exportitem2)){
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportitem){
        int count = 0;
        for (CSVRecord record : parser){
            String export = record.get("Exports");
            if (export.contains(exportitem)){
                count = count + 1;
            }
        }
        return count;
    }
    
    public void bigExporters(CSVParser parser, String amount){
        for (CSVRecord record : parser) {
            String value = record.get("Value (dollars)");
            if (value.length() > amount.length()){
                String pays = record.get("Country");
                System.out.println(pays + " " + value);
            }
        }
    }
    
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //countryInfo(parser, "Nauru");
        //listExportersTwoProducts(parser, "cotton", "flowers");
        //int nb = numberOfExporters(parser, "cocoa");
        //System.out.println("Number of exporters : " + nb);
        bigExporters(parser, "$999,999,999,999");
    }
}
