package webbook.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ApiConfiguration extends WebMvcConfigurerAdapter {
    @Autowired
    AuthApiInterceptor authApiInterceptor;

    @Autowired
    CorsApiInterceptor corsApiInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(corsApiInterceptor);
        registry.addInterceptor(authApiInterceptor);
    }
}
