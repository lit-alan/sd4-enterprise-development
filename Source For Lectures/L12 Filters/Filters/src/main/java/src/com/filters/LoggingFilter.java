package src.com.filters;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import java.io.IOException;

//@Component
public class LoggingFilter implements Filter {

    //Cache duration in seconds (e.g., 3600 seconds = 1 hour)
    private static final int CACHE_DURATION_IN_SECONDS = 3600;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        /*
        Browsers automatically request /favicon.ico to display the website's favicon in the browser tab or bookmarks.
        This request occurs even if no favicon is explicitly defined in the website.
        To avoid processing or logging this request unnecessarily, I am checking if the request URI is /favicon.ico
        and skip the filter logic by immediately continuing the filter chain.
       */

        if (httpRequest.getRequestURI().equals("/favicon.ico")) {
            chain.doFilter(request, response); // Continue the filter chain without logging
            return;
        }

        System.out.println("Request URI: " + httpRequest.getRequestURI());
        System.out.println("Request Method: " + httpRequest.getMethod());
        System.out.println("Client IP: " + httpRequest.getRemoteAddr());

        String userAgent = httpRequest.getHeader("User-Agent");

        if (userAgent != null) {
            System.out.println("User-Agent: " + userAgent);
            System.out.println("Browser: " + determineBrowser(userAgent));
        }
        else {
            System.out.println("User-Agent header is missing.");
        }

        System.out.println("--------------------------------------------------");

        //Set Cache-Control header on the response
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        setCacheHeader(httpResponse);

        //Proceed with the next filter or request
        chain.doFilter(request, response);

    }

    private void setCacheHeader(HttpServletResponse response) {
        //Calculate the cache duration in seconds
        // "public" allows the response to be cached by browsers, proxies (servers), and CDNs (Content Delivery Network).
        String cacheControlValue = "public, max-age=" + CACHE_DURATION_IN_SECONDS;

        //Add Cache-Control header to the response
        response.setHeader("Cache-Control", cacheControlValue);
        System.out.println("Cache-Control set to: " + cacheControlValue);

    }

    private String determineBrowser(String userAgent) {

            // Identify the browser from the User-Agent string
            if (userAgent.contains("Edg"))
                return "Microsoft Edge";
            else if (userAgent.contains("Chrome")) 
                return "Google Chrome";
            else if (userAgent.contains("Firefox")) 
                return "Mozilla Firefox";
            else if (userAgent.contains("Safari")) 
                return "Safari";
            else 
                return "Unknown";
    }



    @Override
    public void destroy() {
        // Cleanup logic if needed
    }
}//end class
