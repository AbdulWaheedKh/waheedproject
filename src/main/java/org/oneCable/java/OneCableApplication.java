package org.oneCable.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@SpringBootApplication
public class OneCableApplication {

	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());	
	
	@Bean
	public CommonsRequestLoggingFilter requestLoggingFilter() {
	    CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
	    loggingFilter.setIncludeClientInfo(true);
	    loggingFilter.setIncludeQueryString(true);
	    loggingFilter.setIncludePayload(false);
	    loggingFilter.setIncludeHeaders(true);	    
	    loggingFilter.setMaxPayloadLength(10000);
	    
	    return loggingFilter;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(OneCableApplication.class, args);
		

		
		
		
		//        String s = "ali";
//		String ss = "ali";
//		System.out.println(s.equals(ss));
//		System.out.println(s == ss);
//		
//		String obj = new String("ali");
//		String obj2 = new String("ali");
//
//		System.out.println(obj.equals(obj2));
//		System.out.println(obj == obj2);
//		
//		System.out.println(s == obj2);
//		System.out.println(s.equals(obj));
		
//		   String str = "Hello Pakistan";
//		   String result = "";
// 
//		  for(int i = str.length()-1; i>=0; i--){
//		     result += str.charAt(i);
//		   	}
//		   System.out.println(result);
//
//		   String s[] = "you shall not pass".split(" "); 
//			String ans = ""; 
//			for (int i = s.length - 1; i >= 0; i--) {
//		  	ans += s[i] + " ";
//		}
//			System.out.println(ans);
//
//		 System.out.println("==================================");
			
			
		
	}

}
