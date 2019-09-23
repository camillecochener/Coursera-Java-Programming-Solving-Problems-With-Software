/**
 * BabyNames Mini Project for the Java Programming: Solving Problem class (Duke University)
 * on Coursera
 *
 * @author camillecochener
 * @version 23/09/2019
 */

import edu.duke.*;
import java.io.File;
import org.apache.commons.csv.*;

public class BabyBirths {
    public void printNames(){
        FileResource fr = new FileResource();
        for (CSVRecord rec : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
            if (numBorn <= 100) {
                System.out.println("Name " + rec.get(0) +
                                    " Gender " + rec.get(1) +
                                    " Num Born " + rec.get(2));
            }
        }
    }
    
    public void totalBirths (FileResource fr){
        int totalBirths = 0;
        int nbGirlsNames = 0;
        int nbBoysNames = 0;
        int nbNames = 0;
        for (CSVRecord rec : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            String nameType = rec.get(1);
            if (nameType.equals("F")){
                nbGirlsNames = nbGirlsNames + 1;
                //System.out.println(rec.get(1));
            }
            if (nameType.equals("M")){
                nbBoysNames = nbBoysNames + 1;
            }
        }
        nbNames = nbGirlsNames + nbBoysNames;
        System.out.println("total births = " + totalBirths);
        System.out.println("number of girls names = " + nbGirlsNames);
        System.out.println("number of boys names = " + nbBoysNames);
        System.out.println("total names = " + nbNames);
    }
    
    private int getRank(int year, String name, String gender){
        String filename = "us_babynames/us_babynames_by_year/yob"+year+".csv";
        FileResource fr = new FileResource(filename);
        int rank = 0;
        int tempRank = 0;
        for (CSVRecord rec : fr.getCSVParser(false)){
           if (rec.get(1).equals(gender)){
               tempRank += 1;
               if (rec.get(0).equals(name)){
                   rank = tempRank;
                   break;
                }
           }
        }
        if (tempRank == 0){
            rank = -1;
        }
        return rank;
    }
    
    private int getRank(FileResource fr, String name, String gender){
        int rank = 0;
        int tempRank = 0;
        for (CSVRecord rec : fr.getCSVParser(false)){
           if (rec.get(1).equals(gender)){
               tempRank += 1;
               if (rec.get(0).equals(name)){
                   rank = tempRank;
                   break;
                }
           }
        }
        if (tempRank == 0){
            rank = -1;
        }
        return rank;
    }
    
    public String getName(int year, int rank, String gender){
        String filename = "us_babynames/us_babynames_by_year/yob"+year+".csv";
        FileResource fr = new FileResource(filename);
        String name = "";
        int tempRank = 0;
        for (CSVRecord rec : fr.getCSVParser(false)){
            if (rec.get(1).equals(gender)){
                tempRank += 1;
                if (tempRank == rank){
                    name = rec.get(0);
                    break;
                }
            }
        }
        if (name.equals("")){
            name = "NO NAME";
        }
        return name;
    }
    
    public void whatIsNameInYear(String name, int year, int newYear, String gender){
        int lastRank = getRank(year,name,gender);
        String newName = getName(newYear,lastRank,gender);
        if (gender.equals("F")){
            System.out.println(name + " born in " + year + " would be " + newName + 
                                    " if she was born in " + newYear);
        }
        if (gender.equals("M")){
            System.out.println(name + " born in " + year + " would be " + newName + 
                                    " if he was born in " + newYear);
        }
    }
    
    public int yearOfHighestRank(String name, String gender){
        DirectoryResource dr = new DirectoryResource();
        int yearHighestRank = 0;
        int currMaxRank = 0;
        for (File f : dr.selectedFiles()){
            String filename = f.getName();
            int currYear = Integer.parseInt(filename.substring(3,7));
            FileResource fr = new FileResource(f);
            int tempRank = 0;
            int rank = -1;
            for (CSVRecord rec : fr.getCSVParser(false)){
                if (rec.get(1).equals(gender)){
                    tempRank += 1;
                    if (rec.get(0).equals(name)){
                        rank = tempRank;
                        break;
                    }
                }
            }
            if (currMaxRank == 0 && rank != -1){
                currMaxRank = rank;
                yearHighestRank = currYear;
            } else if (rank < currMaxRank && rank != -1){
                currMaxRank = rank;
                yearHighestRank = currYear;
            }
        }
        return yearHighestRank;
    }
    
    private double getAverageRank(String name, String gender){
        DirectoryResource dr = new DirectoryResource();
        double resAvg = 0.0;
        double resSum = 0.0;
        double countYear = 0.0;
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            countYear += 1.0;
            int tempRank = 0;
            int rank = getRank(fr, name, gender);
            if (rank != -1){
                resSum += (double)rank;
            }
        }
        if (resSum != 0.0){
            resAvg = resSum/countYear;
        }
        return resAvg;
    }
    
    public int getTotalBirthsRankedHigher(int year, String name, String gender){
        String filename = "us_babynames/us_babynames_by_year/yob"+year+".csv";
        FileResource fr = new FileResource(filename);
        int tempRank = 0;
        int sumBirths = 0;
        int rankName = getRank(fr, name, gender);
        for (CSVRecord rec : fr.getCSVParser(false)){
            if (rec.get(1).equals(gender)){
                tempRank += 1;
                if (tempRank < rankName){
                    sumBirths += Integer.parseInt(rec.get(2));
                }
            }
        }
        return sumBirths;
    }
    
    public void testTotalBirths (){
        FileResource fr = new FileResource();
        totalBirths(fr);
    }
    
    public void testGetRank() {
        //int Result = getRank(2012,"Mason", "M");
        //System.out.println(Result);
        //int Result2 = getRank(2012, "Mason", "F");
        //System.out.println(Result2);
        int Result3 = getRank(1960, "Emily", "F");
        System.out.println(Result3);
        int Result4 = getRank(1971, "Frank", "M");
        System.out.println(Result4);
    }
    
    public void testGetName(){
        //String Result = getName(2012, 7, "M");
        //System.out.println(Result);
        String Result2 = getName(1980, 350, "F");
        System.out.println(Result2);
        String Result3 = getName(1982, 450, "M");
        System.out.println(Result3);
    }
    
    public void testWhatIsNameInYear(){
        //whatIsNameInYear("Isabella",2012,2014,"F");
        whatIsNameInYear("Susan",1972,2014,"F");
        whatIsNameInYear("Owen",1974,2014,"M");
    }
    
    public void testYearOfHighestRank(){
        //int Result = yearOfHighestRank("Mason", "M");
        //System.out.println(Result);
        int Result2 = yearOfHighestRank("Genevieve", "F");
        System.out.println(Result2);
        int Result3 = yearOfHighestRank("Mich", "M");
        System.out.println(Result3);
    }
    
    public void testGetAverageRank(){
        //double Result = getAverageRank("Mason", "M");
        //System.out.println(Result);
        //double Result2 = getAverageRank("Jacob", "M");
        //System.out.println(Result2);
        double Result3 = getAverageRank("Susan", "F");
        System.out.println(Result3);
        double Result4 = getAverageRank("Robert", "M");
        System.out.println(Result4);
    }
    
    public void testGetTotalBirthsRankedHigher(){
        //int Result = getTotalBirthsRankedHigher(2012, "Ethan", "M");
        //System.out.println(Result);
        int Result2 = getTotalBirthsRankedHigher(1990, "Emily", "F");
        System.out.println(Result2);
        int Result3 = getTotalBirthsRankedHigher(1990, "Drew", "M");
        System.out.println(Result3);
    }
    
}
