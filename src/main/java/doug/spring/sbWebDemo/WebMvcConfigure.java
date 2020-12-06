package doug.spring.sbWebDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
//@EnableWebMvc
@ComponentScan(basePackages = "doug.spring.sbWebDemo")
public class WebMvcConfigure implements WebMvcConfigurer {

  @Bean		// the function is needed for using @Value annotation
  public static PropertySourcesPlaceholderConfigurer propertySourcePlaceholderConfigurer() {
	  return new PropertySourcesPlaceholderConfigurer();
  }
  
/*public ViewResolver getViewResolver() {		// don't need this because we do not use JSP
      InternalResourceViewResolver resolver
        = new InternalResourceViewResolver();
      resolver.setPrefix("/static/");
      resolver.setPrefix("/webapp/views");
      resolver.setSuffix(".jsp");
      return resolver;
  } */
 
  @Override		// Resource location to /resources/static
  public void addResourceHandlers(final ResourceHandlerRegistry registry) {
      registry.addResourceHandler("/**")
        .addResourceLocations("classpath:/static/").setCachePeriod(3600)
        .resourceChain(true).addResolver(new PathResourceResolver());
  }
  
/*@Override		// add index page
  public void addViewControllers(ViewControllerRegistry registry) {
	  registry.addViewController("/").setViewName("forward:/index.html");
  } */
}