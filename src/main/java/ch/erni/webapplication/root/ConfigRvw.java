package ch.erni.webapplication.root;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


/**
 * @author mburkert
 *
 */

@Profile("rvw")
@Configuration
public class ConfigRvw {
//  
//  @Bean(name= "host")
//  public String getHost() {
//    String host = "";
//    return host;
//  }
//  
//  @Bean(name= "to")
//  public String[] getTo(){
//    String[] to = {""};
//    return to;
//  }
//  
//  @Bean(name= "from")
//  public String getFrom() {
//    String from = "";
//    return from;
//  }
//  
//  @Bean(name= "subject")
//  public String getSubject() {
//    String subject = "webapplication Information";
//    return subject;
//  }
//  
  @Bean(name= "localisationVariable")
  public String getLocalisationVariable() {
    String localisationVariable = "";
    return localisationVariable;
  }
  
  @Bean(name= "profileVariable")
  public String getprofileVariable() {
    String profileVariable = "dynamic_web_application-rvw";
    return profileVariable;
  }
  
  
}
  

