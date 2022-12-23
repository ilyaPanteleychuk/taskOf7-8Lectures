package ilya.profitsoft.service;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * This filter is created to give access
 * for authorized users only
 *
 * @author ilyaPanteleychuk
 * */
@WebFilter(urlPatterns = {"/*"})
public class AuthenticationFilter implements Filter {
    
    @Override
    public void init(FilterConfig fConfig) {
        ServletContext context = fConfig.getServletContext();
        context.log("AuthenticationFilter initialized");
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);
        boolean isLoggedIn = (session != null && session
                .getAttribute("LOGGED_USER") != null);
        String loginURI = httpRequest.getContextPath() + "/login";
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
        if (isLoggedIn || isLoginRequest) {
            chain.doFilter(request, response);
        }else {
            RequestDispatcher dispatcher = request
                    .getRequestDispatcher("/WEB-INF/view/loginPage.jsp");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Authenticate first</font>");
            dispatcher.include(request, response);
            out.close();
        }
    }
}
