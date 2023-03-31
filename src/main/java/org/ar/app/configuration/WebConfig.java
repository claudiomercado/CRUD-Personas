package org.ar.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	 @Bean
	    public ViewResolver viewResolver() {
	        final ThymeleafViewResolver resolver = new ThymeleafViewResolver();
	        resolver.setTemplateEngine(templateEngine());
	        resolver.setCharacterEncoding("UTF-8");
	        resolver.setCache(false); // Deshabilitar la cache de Thymeleaf
	        return resolver;
	    }

	    @Bean
	    public SpringTemplateEngine templateEngine() {
	        final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	        templateEngine.setEnableSpringELCompiler(true);
	        templateEngine.setTemplateResolver(templateResolver());
	        return templateEngine;
	    }

	    private ITemplateResolver templateResolver() {
	        final ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
	        templateResolver.setPrefix("templates/");
	        templateResolver.setSuffix(".html");
	        templateResolver.setTemplateMode(TemplateMode.HTML);
	        templateResolver.setCharacterEncoding("UTF-8");
	        return templateResolver;
	    }
	
	
	
}
