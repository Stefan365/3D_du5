package pak1;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Stefan Veres
 */
public class Pom {

    public String font_col = "BLACK", back_col = "WHITE", font_size = "8";
    
    /**
     * Spracuje zoznam cookies a nastavi farbu pisma, pozadia a velkost pisma.
     *
     * @param mySiteCookies cookies od klienta.
     * @param response pripravovana odpoved.
     * 
     */
    public void spracujCookies(Cookie[] mySiteCookies, HttpServletResponse response) {
    
        for (int i = 0; i < mySiteCookies.length; i++) {
            Cookie c = mySiteCookies[i];
            if (c.getName().equals("font_color")) {
                font_col = c.getValue().equals("") ? font_col : c.getValue();
                response.addCookie(c);
            } else if (c.getName().equals("background_color")) {
                back_col = c.getValue().equals("") ? back_col : c.getValue();
                response.addCookie(c);
            } else if (c.getName().equals("font_size")) {
                font_size = c.getValue().equals("") ? font_size : c.getValue();
                response.addCookie(c);
            }
        }
    }
}
