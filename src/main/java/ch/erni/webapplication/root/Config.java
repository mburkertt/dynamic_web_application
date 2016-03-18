package ch.erni.webapplication.root;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.cloud.app.ApplicationInstanceInfo;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.config.java.ServiceScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;

@Configuration
@EnableScheduling
@ComponentScan(basePackages = "ch.erni.webapplication", excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class) })
public class Config  {
  
  @Bean(name= "locale")
  public Locale getLocale() {
    Locale locale = new Locale("de", "de");
    return locale;
  }
  
  @Bean(name= "scanUrl")
  public List<String> getScanUrl() {
	  List<String> scanUrl = new ArrayList<String>();
	  scanUrl.add("https://sps2010.erninet.ch/news/Pages/NewsHome.aspx");
	  scanUrl.add("https://sps2010-secure.erninet.ch/Projects/Pages/default.aspx");
	  scanUrl.add("http://jsoup.org/cookbook/introduction/");
    return scanUrl;
  }
  
  @Bean(name= "searchWords")
  public List<String> getSearchWords() {
	  List<String> searchWords = new ArrayList<String>();
	  searchWords.add("Matthias Burkert");
    return searchWords;
  }
    
//  @Resource(name = "host")
//  public String host;
//  
//  @Resource(name = "from")
//  public String from;
//  
//  @Resource(name = "subject")
//  public String subject;
//  
//  @Resource(name = "to")
//  public String[] to;
//  
//  @Bean(name= "notAvailable")
//  public String getNotAvailable() {
//    return "NOT.AVAILABLE";
//  }
//    
//  @Bean(name= "mailSender")
//  public JavaMailSender javaMailService() {
//      JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
//      javaMailSender.setHost(host);
//      return javaMailSender;
//  }
//
//  @Bean(name= "templateMessage")
//  public SimpleMailMessage simpleMailMessage() {
//    
//     SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//     simpleMailMessage.setFrom(from);
//     simpleMailMessage.setTo(to);
//     simpleMailMessage.setSubject(subject);
//     return simpleMailMessage;
//  }
  
}
