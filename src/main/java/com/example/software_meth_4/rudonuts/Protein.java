package com.example.software_meth_4.rudonuts;

public enum Protein {
    BEEF(12.99),
    CHICKEN(10.99),
    SALMON(14.99);

    private final double price;

    Protein(double price){
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    /**
     * Parses a string into its corresponding Protein value (case-insensitive).
     *
     * @param proteinStr the protein string to parse
     * @return the matching Protein constant if found; null if no match exists
     */
    public static Protein parseProtein(String proteinStr) {
        Protein[] allProteins = Protein.values();
        for (int i = 0; i < allProteins.length; i++) {
            if (allProteins[i].name().equalsIgnoreCase(proteinStr)) {
                return allProteins[i];
            }
        }
        return null;
    }
}
