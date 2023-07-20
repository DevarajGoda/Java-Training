package UserManagementSystem.SecurityConfigurition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//            .antMatchers("/api/**").hasRole("ADMIN")
//            .antMatchers(HttpMethod.POST, "/api/**").hasRole("USER") // Allow users to create
//            .antMatchers(HttpMethod.PUT, "/api/**").hasRole("USER")  // Allow users to update
//            .anyRequest().authenticated()
//            .and()
//        .httpBasic() 
//            .and()
//        .csrf().disable();
     
    
    http.authorizeRequests()
    .antMatchers("/admin/**").hasRole("ADMIN")
    .antMatchers("/employee/**").hasAnyRole("ADMIN", "EMPLOYEE")
    .anyRequest().authenticated()
  .and()
  .formLogin()
    .permitAll()
  .and()
  .logout()
    .permitAll();
    }
    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//            .antMatchers("/api/**").hasRole("ADMIN") // Only users with "ADMIN" role can access URLs starting with "/api/admin/"
//            .anyRequest().permitAll() // Any other request is permitted without authentication
//            .and().httpBasic() 
//            .and().csrf().disable(); // Disable Cross-Site Request Forgery (CSRF) protection
//    }

    @Bean
    public static BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("admin")
            .password(bCryptPasswordEncoder().encode("admin123")) // Encoded password using BCryptPasswordEncoder
            .roles("ADMIN")
            .and()
            .withUser("user")
            .password(bCryptPasswordEncoder().encode("user123")) // Encoded password using BCryptPasswordEncoder
            .roles("USER");
    }
}
