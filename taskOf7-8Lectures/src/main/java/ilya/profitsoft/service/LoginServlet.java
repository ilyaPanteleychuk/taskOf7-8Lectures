package ilya.profitsoft.service;

import ilya.profitsoft.repository.UserDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


/**
 * Servlet to validate users` credentials
 * and dispatch to the greeting page
 *
 * @author ilyaPanteleychuk
 * */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Map<String, String> users = UserDao.getUsersCredentials();
        String username = req.getParameter("username");
        String password = req.getParameter("pass");
        if (users.containsKey(username) && users.get(username).equals(password)){
            req.getSession().setAttribute("LOGGED_USER", username);
            RequestDispatcher requestDispatcher = getServletContext()
                    .getRequestDispatcher("/WEB-INF/view/menu.jsp");
            requestDispatcher.forward(req, resp);
        }else {
            RequestDispatcher requestDispatcher = getServletContext()
                    .getRequestDispatcher("/WEB-INF/view/loginPage.jsp");
            PrintWriter out = resp.getWriter();
            out.println("<font color=red>Either username or password is wrong.</font>");
            requestDispatcher.include(req, resp);
            out.close();
        }
    }
}
