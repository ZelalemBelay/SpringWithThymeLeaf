package cont;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Zelalem Belay on 12/29/2016.
 */

@Configuration
@EnableWebMvc
@ComponentScan("cont")
public class Config extends WebMvcConfigurerAdapter
{
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
    {
        super.configureDefaultServletHandling(configurer);
        configurer.enable();
    }

    @Bean
    public SpringTemplateEngine templateEngine()
    {
        Set<IDialect> dialects = new HashSet<>();
        dialects.add(new LayoutDialect());

        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver());
        engine.setAdditionalDialects(dialects);

        return engine;
    }

    @Bean
    private ServletContextTemplateResolver templateResolver()
    {
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setTemplateMode("HTML5");

        return resolver;
    }

    @Bean
    public ThymeleafViewResolver viewResolver()
    {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setOrder(1);
        resolver.setViewNames(new String[]{"*", "js/*", "template/*"});

        return resolver;
    }


}
