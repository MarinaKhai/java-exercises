import edu.duke.*;
public class FindSubstrings {

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

//Print all genes present in a string
    public StorageResource getAllGenes(String dna) {
        StorageResource sr = new StorageResource();
        int startIndex = 0;
        String currGene = "";
        while (true) {
            currGene = findGene(dna, startIndex);
            if (currGene.isEmpty()) {
                break;
            }
            sr.add(currGene);
            startIndex = dna.indexOf(currGene, startIndex) + currGene.length();
        }
        return sr;
    }

        // Returns a ratio of letters "C" and "G" in a given string to the string's length
    public double cgRatio(String dna) {
        int counter = 0;
        dna = dna.toUpperCase();
        int currIndexC = dna.indexOf("C");
        int currIndexG = dna.indexOf("G");
        while (true) {
            /*actually there is no sense in this case to use infinite loop, because first "if" comes at the very beginning of iteration. But the topic is infinite loops, let's use them at least once. It would make sense if we swap "ifs", but I think it's not big deal for now. */
            if (currIndexC != -1 && currIndexG != -1) {
                counter += 2;
                currIndexC = dna.indexOf("C", currIndexC+1);
                currIndexG = dna.indexOf("G", currIndexG+1);
            }
            if (currIndexC == -1 || currIndexG == -1) {
                while (currIndexC != -1) 
                {
                    counter += 1;
                    currIndexC = dna.indexOf("C", currIndexC+1);
                }
                while (currIndexG != -1) {
                    counter += 1;
                    currIndexG = dna.indexOf("G", currIndexG+1);
                }
                break;
            }
        }
        return (float) counter / dna.length();
    }

    // Returns number of times substring occurs in the given string according to given condition that index of each substring minus startIndex should always be divisible by 3; 
    public int countCTG(String dna) {
        //set currIndex to index of codon firstly found
        int currIndex = dna.indexOf("CTG");
        int startIndex = currIndex;
        //set counter to 0;
        int counter = 0;
        // while currIndex is not -1
        while (currIndex != -1 && (currIndex - startIndex) % 3 == 0) {
            // update it with new value, each time search for codon srarting from currindex + codon.length();
            counter++;
            currIndex = dna.indexOf("CTG", currIndex+3);
        }
        return counter;
    }

    // Makes some string manipulations in a given StorageResource
    public void processGenes(StorageResource sr) {
        int nineLongLines = 0;
        int cgRatioLines = 0;
        int longestLine = 0;
        int howManyGenes = 0;
        int CTGnumber = 0;
        for (String line : sr.data()) {
            if (line.length() > 60) {
                System.out.println(line);
                nineLongLines++;
            }
            if (cgRatio(line) > 0.35) {
                System.out.println(line);
                cgRatioLines++;
            }
            if (line.length() > longestLine) {
                longestLine = line.length();
            }
            howManyGenes++;
            CTGnumber += countCTG(line);
        }

        System.out.println("Lines longer than 60: " + nineLongLines);
        System.out.println("CG ratio more than 0.35: " + cgRatioLines);
        System.out.println("Longest line: " + longestLine);
        System.out.println("Number of genes: " + howManyGenes);
        System.out.println("Number of CTG codons: " + CTGnumber);
    }


// Test methods

    public void testFindStopCodon() {
        System.out.println("In a string xxxATGxxxyyyzzzTAA stop codon is at " + findStopCodon("xxxATGxxxyyyzzzTAA", 3, "TAA") + "th index (15).");
        System.out.println("In a string xxxATGxxTAAxTAA stop codon is at " + findStopCodon("xxxATGxxTAAxTAA", 3, "TAA") + "th index (12).");
        System.out.println("In a string ATGxxxyyy stop codon is absent (" + findStopCodon("ATGxxxyyy", 0, "TAA") + "th index - length of string) (9).");
        System.out.println("In a string \"\" stop codon is absent (" + findStopCodon("", 0, "TAA") + "th index - length of string) (0).");
    }
    public void testFindGene() {
        System.out.println("In xxxxxxyyyzzzTAA there is no ATG, findGene() should return empty str. \nIt returns: " + findGene("xxxxxxyyyzzzTAA", 0));
        
        System.out.println("In xxxATGxxxyyyzzzTAA ATGxxxyyyzzzTAA is valid, \nfindGene() returns: " + findGene("xxxATGxxxyyyzzzTAA", 0));
        
        System.out.println("In ATGxxxTAGzzzTAAxxxTGAyy all 3 are valid, should return up to first (ATGxxxTAG). \nIt returns: " + findGene("ATGxxxTAGzzzTAAxxxTGAyy", 0));
        
        System.out.println("In ATGxxTAGxyyyzzTAA there are no valid codons. Should return empty string. \nIt returns: " + findGene("ATGxxTAGxyyyzzTAA", 0));
        
        System.out.println("In \"\" findGene() should returns empty str. \nIt returns: " + findGene("", 0));
    }
    public void testGetAllGenes() {
        String dna = "xxxATGxxxyyyzzzTAAyyyATGxxxTAGzzzxxxATGTGAyyyATGATGyyyTAAyyy";
        StorageResource sr = getAllGenes(dna);
        for (String gene : sr.data()) {
            system.out.println(gene);
        }
        String empty = "";
        StorageResource sr2 = getAllGenes(empty);
        for (String gene : sr2.data()) {
            system.out.println(gene);
        } 
    }
    public void testProcessGenes() {
        StorageResource source = new StorageResource();
        FileResource fr = new FileResource("brca1line.fa");
        String dna = fr.asString();
        source = getAllGenes(dna);
        processGenes(source);
    }


    public static void main(String[] args) {
        FindSubstrings obj1 = new FindSubstrings();
        obj1.testFindStopCodon();
    }
}