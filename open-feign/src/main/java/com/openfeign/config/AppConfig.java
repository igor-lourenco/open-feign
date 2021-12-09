package com.openfeign.config;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Component  // classe pra pegar o token vindo do front-end pra enviar junto na requisição
public class AppConfig implements RequestInterceptor{ 

	  private static final String AUTHORIZATION_HEADER = "Authorization";

      public static String getBearerTokenHeader() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization");
      }
    
      @Override
      public void apply(RequestTemplate requestTemplate) {
          requestTemplate.header(AUTHORIZATION_HEADER, getBearerTokenHeader());
      }
}
