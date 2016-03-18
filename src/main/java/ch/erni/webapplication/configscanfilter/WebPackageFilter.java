/**
 * 
 */
package ch.erni.webapplication.configscanfilter;

import java.util.regex.Pattern;

import org.springframework.core.type.filter.RegexPatternTypeFilter;


/**
 * @author mburkert
 *
 */
public class WebPackageFilter extends RegexPatternTypeFilter{
  public WebPackageFilter() {
      super(Pattern.compile("ch\\.erni\\.webapplication\\.root\\..*"));
  }
}
