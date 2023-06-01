package com.example.security.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class EmpSecurityConfig extends WebSecurityConfigurerAdapter{

	
	
	@Autowired
	// DataSource dataSource;
	UserDetailsService userDetailsService;

//@Autowired
//	JwtRequestFilter jwtRequestFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService); 

	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {

		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.
		csrf().
		disable().
		authorizeRequests()
		.antMatchers("/authenticate").
		permitAll().
		anyRequest().
		authenticated()
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		//http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

	
	
	
	
	
	
	
	
//	@Override
//	
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("bond").password("james").roles("USER").and().withUser("poo")
//				.password("bear").roles("ADMIN");
//	}
//
//	 @Bean
//	    public AuthenticationManager getAuthenticationManager() throws Exception { //new code added, due to which code runs
//	        return super.authenticationManagerBean();
//	    }
//	
//	@Bean
//	@SuppressWarnings("deprecation")
//	public PasswordEncoder getPasswordEncoder() {
//
//		return NoOpPasswordEncoder.getInstance();
//	}
//
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN")//only admin can access / admin endpoint
//		.antMatchers("/user").hasAnyRole("USER")
//				.antMatchers("/").permitAll().and().formLogin();//user endpoint can be accessed by both user and admin
//
//	}

}
