package com.erayt.single.configuration.spring.mvc;

import com.erayt.single.configuration.spring.wx.TokenHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author
 */

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    private final TokenHandlerInterceptor tokenHandlerInterceptor;

    @Autowired
    public WebMvcConfiguration(TokenHandlerInterceptor tokenHandlerInterceptor){
        this.tokenHandlerInterceptor = tokenHandlerInterceptor;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/main", "/main.html");
        registry.addRedirectViewController("/index", "/index.html");
    }

    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        //super.addCorsMappings(registry);
        //设置允许跨域的路径
        registry.addMapping("/**")
            //设置允许跨域请求的域名
            .allowedOrigins("*")
            .allowedHeaders("*")
//                .allowCredentials(true)//是否允许证书 不再默认开启
            //设置允许的方法
            .allowedMethods("GET", "POST", "PUT", "DELETE");
//                .maxAge(3600);//跨域允许时间
    }
/*    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(31556926);
    }*/

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenHandlerInterceptor).addPathPatterns("/**")
            .excludePathPatterns("/error/**","/","/login","/logout");
        super.addInterceptors(registry);
    }
}
