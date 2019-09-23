/**
 * This code has been created to answer the quizz of the week 2 about Strings in Java.
 * 
 * Program that reads the lines from the file at this URL location, 
 * http://www.dukelearntoprogram.com/course2/data/manylinks.html, 
 * and prints each URL on the page that is a link to youtube.com.
 *
 * @author camillecochener
 * @date 20 septembre 2019
 */

import edu.duke.URLResource;

public class Week2Part4YoutubeURL {
    
    public void findYoutubeURL(String url) {
        URLResource ur = new URLResource(url);
        for (String s : ur.lines()) {
            //System.out.println(s);
            int findYoutube = s.indexOf("youtube.com");
            if (findYoutube != -1) {
                int firstDQ = s.lastIndexOf("\"", findYoutube);
                int secondDQ = s.indexOf("\"", findYoutube);
                System.out.println(s.substring(firstDQ, secondDQ+1));
            }
        }
    }
    
    public void testing() {
        String url = "http://www.dukelearntoprogram.com/course2/data/manylinks.html";
        findYoutubeURL(url);
    }
}
