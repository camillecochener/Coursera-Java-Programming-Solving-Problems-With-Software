/**
 * This code has been created to answer the quizz of the week 2 about Strings in Java.
 * The method named twoOccurrences that has two String parameters named stringa and stringb. This method returns true if stringa appears at least twice in stringb, otherwise it returns false. 
 *
 * @author camillecochener
 * @date 20 septembre 2019
 */

public class Week2Part3FindingGene {
    boolean twoOccurrences(String stringa, String stringb){
        boolean res = false;
        int findString = stringb.indexOf(stringa);
        if (findString == -1) {
            res = false;
        }
        if (stringb.indexOf(stringa, findString + 1) != -1) {
            res = true;
        }
        return res;
    }
    
    String lastPart(String stringa, String stringb) {
        int firstOc = stringb.indexOf(stringa);
        int lengthStA = stringa.length();
        String lastPart = stringb;
        if (firstOc != -1) {
            lastPart = stringb.substring(firstOc+lengthStA,stringb.length());
        }
        return lastPart;
    }
    
    public void testing() {
        String test1 = "A story by Abby Long";
        String test2 = "You know that the sun will raise every morning";
        String test3 = "bla bla bla uhuhuhuhuh bla";
        System.out.println("result : " + twoOccurrences("story",test1));
        System.out.println("result : " + twoOccurrences("t",test2));
        System.out.println("result : " + twoOccurrences("bla",test3));
        System.out.println(lastPart("an","banana"));
        System.out.println(lastPart("zoo","forest"));
    }
}
