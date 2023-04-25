package house.lower;

import house.lower.argumentresolver.LoginUserArgumentResolver;
import house.lower.interceptor.LogInterceptor;
import house.lower.interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig  implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new LoginUserArgumentResolver());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LogInterceptor())
                        .order(1)
                        .addPathPatterns("/**")
                        .excludePathPatterns("/css/**","/*.ico");


        registry.addInterceptor(new LoginCheckInterceptor())
                .order(2)
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/logout","/css/**","/*.ico","/user/save","/vendor/**","/img/**","/js/**");

    }
}
