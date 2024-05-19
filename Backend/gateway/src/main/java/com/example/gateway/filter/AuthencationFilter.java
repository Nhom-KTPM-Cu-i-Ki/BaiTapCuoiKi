package com.example.gateway.filter;

import com.example.gateway.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

public class AuthencationFilter extends AbstractGatewayFilterFactory<AuthencationFilter.Config> {
    @Autowired
    private RouteValidator routeValidator;
//    @Autowired
//    private RestTemplate template;
    @Autowired
    private JwtUtil jwtUtil;
    public AuthencationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (((exchange, chain) -> {
            if(routeValidator.isSecured.test(exchange.getRequest())) {
                //header contains token or not
                if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw  new RuntimeException("missing authorization header");
                }

                String authHeaders = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if (authHeaders !=null && authHeaders.startsWith("Bearer ")) {
                    authHeaders = authHeaders.substring(7);
                }
                try {
                    // REST call to AUTH service
//                    template.getForObject("http://AUTHENTICATION//validate?token"+authHeaders,String.class);
                    jwtUtil.validateToken(authHeaders);
                }catch (Exception e) {
                    System.out.println("Invalid access!!!");
                    throw new RuntimeException("Unauthorized access to application");
                }
            }
            return chain.filter(exchange);
        }));
    }

    public static class Config {

    }
}
