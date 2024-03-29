
/**
 * This code has been created to answer the quizz of the week 2 about Strings in Java.
 * 
 * The method findSimpleGene that has one String parameter dna, representing a string of DNA. This method does the following:
 *
 * - Finds the index position of the start codon “ATG”. If there is no “ATG”, return the empty string.
 * - Finds the index position of the first stop codon “TAA” appearing after the “ATG” that was found. If there is no such “TAA”, return the empty string.
 * - If the length of the substring between the “ATG” and “TAA” is a multiple of 3, then return the substring that starts with that “ATG” and ends with that “TAA”.
 *
 * @author camillecochener
 * @date 20 septembre 2019
 */

public class Week2Part1FindingGene {
    String findSimpleGene(String dna) {
       String gene = "";
       int startIndex = dna.indexOf("ATG");
       if (startIndex == -1){
           gene = "not here";    
       }
       int stopIndex = dna.indexOf("TAA", startIndex+3);
       if (stopIndex == -1) {
           gene = "not here";
       }
       if (((stopIndex-startIndex)%3 == 0) && stopIndex != -1 && startIndex != -1){
           gene = dna.substring(startIndex, stopIndex+3);
       }
       if ((stopIndex-startIndex)%3 != 0) {
           gene = "not here";
       }
       return gene;
    }
    
    public void testSimpleGene() {
        String dna1 = "AAATGCCCTAACTAGATTAAGAAACC";
        String dna2 = "TAATTAAATAGGTAGGGTG";
        String dna3 = "TTTTATTTGGTTATGTTGAAAAGTAATTAA";
        String dna4 = "TTTTTTGGAAAA";
        String dna5 = "GGGATGGGTGAGTAA";
        System.out.println("DNA : " + dna1);
        System.out.println("gene is " + findSimpleGene(dna1));
        System.out.println("DNA : " + dna2);
        System.out.println("gene is " + findSimpleGene(dna2));
        System.out.println("DNA : " + dna3);
        System.out.println("gene is " + findSimpleGene(dna3));
        System.out.println("DNA : " + dna4);
        System.out.println("gene is " + findSimpleGene(dna4));
        System.out.println("DNA : " + dna5);
        System.out.println("gene is " + findSimpleGene(dna5));
    }
}
