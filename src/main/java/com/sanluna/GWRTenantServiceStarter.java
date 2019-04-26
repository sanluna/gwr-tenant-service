package com.sanluna;

import com.sanluna.commons.BeansAndConfigurations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import sanluna.gwr.security.SecurityConfiguration;

@SpringBootApplication
@EnableResourceServer
@Import({BeansAndConfigurations.class, SecurityConfiguration.class})
public class GWRTenantServiceStarter {

    public static void main(String[] args) {
        SpringApplication.run(GWRTenantServiceStarter.class, args);
    }

    @Configuration
    public class HealthCheckSecurityConfigurer extends ResourceServerConfigurerAdapter {

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers(HttpMethod.GET, "/status/**").permitAll()
                    .antMatchers(HttpMethod.POST, "/teanants/").permitAll()
                    .antMatchers(HttpMethod.POST, "/teanants").permitAll()
                    .anyRequest().authenticated();
        }
    }

}
