public class FindSubstrings {

//Return substring: closest relevant gene from a given string;
    public String findGene(String dna, int startFrom) {
        int startIndex = dna.indexOf("ATG", startFrom);
        if (startIndex == -1) return "";

    //find all three closest genes
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");

    //find closest of them
        int tempIndex = Math.min(taaIndex, tgaIndex);
        int minStopIndex = Math.min(tempIndex, tagIndex);
        
        if (minStopIndex == dna.length()) return "";
        return dna.substring(startIndex, minStopIndex+3);
    }

//take a string (dna), return index of a substring (stopCodon) with a certain position conditions, starting from (startIndex).
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int currIndex = dna.indexOf(stopCodon, startIndex+3);
        //while the codon's instances are present in a string
        while (currIndex != -1) {
            if ((currIndex - startIndex) % 3 == 0) {
                return currIndex;
            }
        //if not found, update area of search
            currIndex = dna.indexOf(stopCodon, currIndex+1);
        }
        return dna.length();
    }

//Print all genes present in a string
    public void printAllGenes(String dna) {
        int startIndex = 0;
        String currGene = "";
        while (true) {
            currGene = findGene(dna, startIndex);
            if (currGene.isEmpty()) {
                break;
            }
            System.out.println(currGene);

            startIndex = dna.indexOf(currGene, startIndex) + currGene.length();
        }
    }

    public void testFindGene() {
        System.out.println("In xxxxxxyyyzzzTAA there is no ATG, findGene() should return empty str. \nIt returns: " + findGene("xxxxxxyyyzzzTAA", 0));
        
        System.out.println("In xxxATGxxxyyyzzzTAA ATGxxxyyyzzzTAA is valid, \nfindGene() returns: " + findGene("xxxATGxxxyyyzzzTAA", 0));
        
        System.out.println("In ATGxxxTAGzzzTAAxxxTGAyy all 3 are valid, should return up to first (ATGxxxTAG). \nIt returns: " + findGene("ATGxxxTAGzzzTAAxxxTGAyy", 0));
        
        System.out.println("In ATGxxTAGxyyyzzTAA there are no valid codons. Should return empty string. \nIt returns: " + findGene("ATGxxTAGxyyyzzTAA", 0));
        
        System.out.println("In \"\" findGene() should returns empty str. \nIt returns: " + findGene("", 0));
    }

    public void testFindStopCodon() {
        System.out.println("In a string xxxATGxxxyyyzzzTAA stop codon is at " + findStopCodon("xxxATGxxxyyyzzzTAA", 3, "TAA") + "th index (15).");
        System.out.println("In a string xxxATGxxTAAxTAA stop codon is at " + findStopCodon("xxxATGxxTAAxTAA", 3, "TAA") + "th index (12).");
        System.out.println("In a string ATGxxxyyy stop codon is absent (" + findStopCodon("ATGxxxyyy", 0, "TAA") + "th index - length of string) (9).");
        System.out.println("In a string \"\" stop codon is absent (" + findStopCodon("", 0, "TAA") + "th index - length of string) (0).");
    }
    public void testPrintAllGenes() {
        printAllGenes("xxxATGxxxyyyzzzTAAyyyATGxxxTAGzzzxxxATGTGA");
        printAllGenes("");
        printAllGenes("yyyATGATGyyyTAAyyy");
    }

    public static void main(String[] args) {
        FindSubstrings obj1 = new FindSubstrings();
        obj1.testFindStopCodon();
    }
}