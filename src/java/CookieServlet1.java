
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pak1.Pom;

/**
 * Použití cookies pro počítání přístupů daného klienta na webový server.
 *
 * @author Stefan Veres
 */
public class CookieServlet1 extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException,
        IOException {

        String font_col, back_col, font_size;
        Pom pom = new Pom();
        
        //nacitanie vlastnosti z cookies:
        Cookie[] mySiteCookies = request.getCookies();
        pom.spracujCookies(mySiteCookies, response);
        
        font_col = pom.font_col;
        back_col = pom.back_col;
        font_size = pom.font_size;
		
        
        // příprava odpovědi pro klienta
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        
        //tvorba těla odpovědi
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<body bgcolor=\"" + back_col + "\">");
        out.println("<font size=\"" + font_size + "\" color=\"" + font_col + "\">");      
        
        out.printf("<p>Toto je prva stranka.<br/>" +      
        " Farba písma: " + font_col + ", Farba pozadia: " + back_col + ", Velkost písma: " + font_size
            + "</p><br/>");
                    
        //odakz na stranku zpet:
        out.println("</font>");
        
        //nasledovny riadok tu mam miesto komentara:
        //out.println("<a href=\"http://localhost:8080/DU5/\">ZPĚT</a>");
        out.println("<a href=\"/DU5/\">ZPĚT</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
