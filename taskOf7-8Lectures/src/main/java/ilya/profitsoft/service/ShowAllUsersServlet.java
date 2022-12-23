package ilya.profitsoft.service;

import ilya.profitsoft.repository.UserDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Servlet to pass list of users
 * to the /WEB-INF/view/allUsers.jsp page
 *
 * @author ilyaPanteleychuk
 * */
@WebServlet("/allUsersTable")
public class ShowAllUsersServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("allUsers", UserDao.getUsersLogins());
        RequestDispatcher requestDispatcher = req
                .getRequestDispatcher("/WEB-INF/view/allUsers.jsp");
        requestDispatcher.forward(req, resp);
    }
}
