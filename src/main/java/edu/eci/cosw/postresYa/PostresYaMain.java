package edu.eci.cosw.postresYa;

import edu.eci.cosw.postresYa.model.Usuario;
import edu.eci.cosw.postresYa.repositories.UserRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;


@SpringBootApplication
@EnableJpaRepositories("edu.eci.cosw.postresYa.repositories")
@EntityScan("edu.eci.cosw.postresYa.model")
public class PostresYaMain {

	public static void main(String[] args) {
		SpringApplication.run(PostresYaMain.class, args);
	}
        
        
        /**
         * 
         */ 
        @Configuration
        @EnableGlobalMethodSecurity(prePostEnabled = true)
        @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
        protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
            @Autowired
            UserRepository userRepository;
            
            @Override
            protected void configure(AuthenticationManagerBuilder builder) throws Exception {
                builder.authenticationProvider(new AuthenticationProvider() {
                    @Override
                    public Authentication authenticate(Authentication a) throws AuthenticationException {
                        System.out.println(a.getDetails()+" user  "+a.getName()+" pas "+a.getCredentials().toString()+"  otros "+ a.getAuthorities());
                        if (a.getName().equals("validarINVIMA")){
                            return new UsernamePasswordAuthenticationToken(a.getName(),"",null);
                           
                        }else{
                            Usuario usuario=userRepository.Login(a.getName(), a.getCredentials().toString());
                            if(usuario!=null){
                                List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                                authorities.add(new SimpleGrantedAuthority(usuario.getRol()));
                                return new UsernamePasswordAuthenticationToken(a.getName(), a.getCredentials().toString(), authorities);

                            }

                           return null;
                        }
                    }

                    @Override
                    public boolean supports(Class<?> type) {
                        return type.equals(UsernamePasswordAuthenticationToken.class);
                    }
                });
                
            }
            /**
             * 
             * @param http
             * @throws Exception 
             */
            @Override
            protected void configure(HttpSecurity http) throws Exception {
                http
                        .httpBasic()
                        .and()
                        .authorizeRequests()
                        .antMatchers("/app/**","/logout","/login","/reposterias/registroINVIMA/**","/reposterias/**").permitAll()
                        .anyRequest().authenticated().and()
                        .logout().logoutSuccessUrl("/")
                        .and().csrf().disable();
                        //.csrfTokenRepository(csrfTokenRepository()).and()
                        //.addFilterAfter(csrfHeaderFilter(), CsrfFilter.class);
            }
            
            /**
             * 
             * @return OncePerRequestFilter
             */
            private Filter csrfHeaderFilter() {
                return new OncePerRequestFilter() {
                    @Override
                    protected void doFilterInternal(HttpServletRequest request,
                            HttpServletResponse response, FilterChain filterChain)
                            throws ServletException, IOException {
                        CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class
                                .getName());
                        if (csrf != null) {
                            Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
                            String token = csrf.getToken();
                            if (cookie == null || token != null
                                    && !token.equals(cookie.getValue())) {
                                cookie = new Cookie("XSRF-TOKEN", token);
                                cookie.setPath("/");
                                response.addCookie(cookie);
                            }
                        }
                        filterChain.doFilter(request, response);
                    }
                };
            }
            /**
             * 
             * @return respository 
             */
            private CsrfTokenRepository csrfTokenRepository() {
                HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
                repository.setHeaderName("X-XSRF-TOKEN");
                return repository;
            }
         

}
        
        
}
