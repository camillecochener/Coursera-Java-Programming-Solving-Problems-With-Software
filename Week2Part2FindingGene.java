
/**
 * This code has been created to answer the quizz of the week 2 about Strings in Java.
 *
 * The method findSimpleGene to have three parameters, one for the DNA string, 
 * one for the start codon and one for the stop codon.
 *
 * @author camillecochener
 * @date 20 septembre 2019
 */

public class Week2Part2FindingGene {
    String findSimpleGene(String dna, int startIndex, int stopIndex) {
       String gene = "";
       if (startIndex == -1){
           gene = "not here";    
       }
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
        String dna1 = "ATTGGTFATGTGAAAGTTTGAATAATTAAGGGAT";
        String dna2 = "TAATTAAATAGGTAGGGTG";
        String dna3 = "TTTTATTTGGTTATGTTGAAAAGTAATTAA";
        String dna4 = "TTTTTTGGAAAA";
        String dna5 = "GGGATGGGTGAGTAA";
        System.out.println("DNA : " + dna1);
        System.out.println("gene is " + findSimpleGene(dna1, 7,22));
        System.out.println("DNA : " + dna2);
        System.out.println("gene is " + findSimpleGene(dna2,-1,0));
        System.out.println("DNA : " + dna3);
        System.out.println("gene is " + findSimpleGene(dna3,12,23));
        System.out.println("DNA : " + dna4);
        System.out.println("gene is " + findSimpleGene(dna4,-1,-1));
        System.out.println("DNA : " + dna5);
        System.out.println("gene is " + findSimpleGene(dna5,3,12));
    }
}
