package ch.erni.webapplication.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

import ch.erni.webapplication.configscanfilter.WebPackageFilter;

@EnableWebMvc
@ComponentScan(basePackages = "ch.erni.webapplication",
    excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Repository.class),
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Service.class),
        @ComponentScan.Filter(type = FilterType.CUSTOM, value = WebPackageFilter.class)})
class WebMvcConfig extends WebMvcConfigurerAdapter {
  
  
  @Bean
  public ContentNegotiatingViewResolver getViewResolver(){
      ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
      resolver.setOrder(1);
      List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
      resolvers.add(this.viewResolver());
      resolver.setViewResolvers(resolvers);
      resolver.setDefaultViews(new ArrayList<View>(){{add(new MappingJacksonJsonView());}});
      return resolver;
  }
  
  
  protected ViewResolver viewResolver() {
      UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
      viewResolver.setViewClass(TilesView.class);
      return viewResolver;
  }

  @Bean
  public TilesConfigurer tilesConfigurer(ServletContext servletContext) {
      TilesConfigurer tilesConfigurer = new TilesConfigurer();
      tilesConfigurer.setDefinitions(new String[] {
              "/WEB-INF/config/tiles/tiles.xml"});
      tilesConfigurer.setCheckRefresh(true);
      tilesConfigurer.setServletContext(servletContext);      
      return tilesConfigurer;
  }
  
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/res/**").addResourceLocations("/res/");
  }
}