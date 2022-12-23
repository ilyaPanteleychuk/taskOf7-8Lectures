package ilya.profitsoft.service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * This filter is created to give access
 * for authorized users only
 *
 * @author ilyaPanteleychuk
 * */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession httpSession = req.getSession(false);
        if (httpSession != null){
            httpSession.removeAttribute("LOGGED_USER");
            httpSession.invalidate();
        }
        RequestDispatcher requestDispatcher = req
                .getRequestDispatcher("/WEB-INF/view/loginPage.jsp");
        requestDispatcher.forward(req, resp);
    }
}
