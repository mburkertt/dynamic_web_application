package ch.erni.webapplication.root;


import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class LocalizationConfig {

  @Bean
  public MessageSourceAccessor messageSourceAccessor() {
    MessageSourceAccessor messageSourceAccessor = new MessageSourceAccessor(messageSource());
    return messageSourceAccessor;
  }

  @Bean
  public ReloadableResourceBundleMessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setFallbackToSystemLocale(false);
    messageSource.setUseCodeAsDefaultMessage(true);
    messageSource.setBasenames("/WEB-INF/config/messages/message");
    return messageSource;
  }

  @Bean
  public SessionLocaleResolver localeResolver() {
    SessionLocaleResolver localeResolver = new SessionLocaleResolver();
    localeResolver.setDefaultLocale(locale());
    return localeResolver;
  }

  @Bean
  public Locale locale() {
    Locale locale = new Locale("en", "GB");
    return locale;
  }

}