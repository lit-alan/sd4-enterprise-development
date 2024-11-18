package src.com.filters;


import jakarta.servlet.DispatcherType;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.EnumSet;


@Configuration
public class FilterConfig {

    //Define the filter as a Spring Bean
    @Bean
    public IPRestrictionFilter ipRestrictionFilter() {
        return new IPRestrictionFilter();
    }

    @Bean
    public FilterRegistrationBean<IPRestrictionFilter> ipRestrictionFilterRegistration(IPRestrictionFilter ipRestrictionFilter) {
        FilterRegistrationBean<IPRestrictionFilter> registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(ipRestrictionFilter);
        registrationBean.addUrlPatterns("/admin/*"); // Apply to /admin and sub-paths
        return registrationBean;
    }

}
//    @Bean
//    public FilterRegistrationBean<LoggingFilter> loggingFilter() {
//        FilterRegistrationBean<LoggingFilter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(new LoggingFilter());
//        registrationBean.addUrlPatterns("/*"); // Apply to all URLs
//        //registrationBean.addUrlPatterns("/products/*"); //Apply to /products and its sub-paths
//
//        //Apply only to specific dispatcher types (e.g., REQUEST, FORWARD)
//        registrationBean.setDispatcherTypes(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD));
//
//        return registrationBean;
//    }
//
//}
//

//@Configuration
//public class FilterConfig {



//}

