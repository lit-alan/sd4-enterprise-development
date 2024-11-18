package src.com.filters;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

//@Component
public class IPRestrictionFilter implements Filter {

    private Set<String> allowedHosts = new HashSet<>();

    @Value("${allowed.ips.file}")
    private Resource allowedIpsFile;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;


        if (allowedIpsFile == null) {
            throw new IllegalStateException("File not found : allowed_ips.txt");
        }

      try (BufferedReader reader = new BufferedReader(new InputStreamReader(allowedIpsFile.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    allowedHosts.add(line.trim());
                }
            }
        }
        System.out.println("Allowed IPs loaded: " + allowedHosts);


        //Get IP address of client
        String remoteAddress = httpRequest.getRemoteAddr();
        System.out.println("Incoming request from IP: " + remoteAddress);

        if (allowedHosts.contains(remoteAddress)) {
            //If IP is allowed, continue the filter chain
            chain.doFilter(request, response);
        } else {
            //If IP is not allowed, log and reject the request
            System.out.println("Unauthorised access attempt from IP: " + remoteAddress);

            //httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Access denied");

            //Consider returning a 404 Not Found error instead or a 403 as a bit of misdirection.
            httpResponse.sendError(HttpServletResponse.SC_NOT_FOUND, "Resource Could Not Be Found");

        }
    }
}
