package interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class interceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response ,Object handle) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object username = session.getAttribute("username");
        if(username != null)
        {
            return true;
        }else{
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }
    }
}
