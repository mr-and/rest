package testproject.restApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Ivan").password("p").roles("USER");
        auth.inMemoryAuthentication().withUser("Admin").password("p").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/deldoc/**").access("hasRole('ADMIN')")
                .antMatchers("/adddoc/**").access("hasRole('USER')")
                .antMatchers("/doclist/**").access("hasRole('ADMIN') or hasRole('USER')" )
                .and().formLogin()
                .and().exceptionHandling().accessDeniedPage("/Access_Denied");

    }
}
