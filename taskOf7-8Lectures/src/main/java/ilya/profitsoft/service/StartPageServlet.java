package ilya.profitsoft.service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Servlet to dispatch to login form
 * in WEB-INF/view/loginPage.jsp
 *
 * @author ilyaPanteleychuk
 * */
@WebServlet("/")
public class StartPageServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req
                .getRequestDispatcher("WEB-INF/view/loginPage.jsp");
        requestDispatcher.forward(req, resp);
    }
}
