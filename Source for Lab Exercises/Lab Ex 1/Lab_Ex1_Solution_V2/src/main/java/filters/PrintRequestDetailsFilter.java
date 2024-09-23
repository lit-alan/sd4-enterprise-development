package filters;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

@WebFilter(filterName = "filters.PrintRequestDetailsFilter", urlPatterns = {"/*"})
public class PrintRequestDetailsFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest)request;

        // Log request method
        System.out.println("Request Method: " + req.getMethod());

        // Log request URI
        System.out.println("Request URI: " + req.getRequestURI());

        // Log query string (if present)
        String queryString = req.getQueryString();
        System.out.println("Query String: " + (queryString != null ? queryString : "None"));

        // Log remote address (client IP)
        System.out.println("Remote Address (Client IP): " + request.getRemoteAddr());

        // Log headers
        System.out.println("\nRequest Headers:");
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println(headerName + ": " + req.getHeader(headerName));
        }

        // Log request parameters
        System.out.println("\nRequest Parameters:");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            System.out.println(paramName + ": " + request.getParameter(paramName));
        }
        chain.doFilter(request,response);
    }
}
