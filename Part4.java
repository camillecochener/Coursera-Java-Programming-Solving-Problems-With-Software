import edu.duke.URLResource;
/**
 * Program that reads the lines from the file at this URL location, 
 * http://www.dukelearntoprogram.com/course2/data/manylinks.html, 
 * and prints each URL on the page that is a link to youtube.com.
 *
 * @camillecochener
 * @v20 septembre 2019
 */

public class Part4 {
    
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
