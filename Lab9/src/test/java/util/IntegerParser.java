package util;

public class IntegerParser {
    public static int parse(String priceStr){
        return Integer.parseInt(priceStr.replaceAll("[^\\d]", ""));
    }
}
