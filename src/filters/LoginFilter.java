package filters;

import Service.UserService;
import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest httpReq = (HttpServletRequest)req;
        if (httpReq.getUserPrincipal()!=null && httpReq.getSession().getAttribute("user")==null)
        {
            saveUserInSession(httpReq);
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }
    private void saveUserInSession (HttpServletRequest request) throws IOException
    {
        UserService userService = new UserService();
        String username = request.getUserPrincipal().getName();
        User userByName = userService.getUserByUsername(username);
        request.getSession(true).setAttribute("user", userByName);
    }


}
