package com.team.workout.config;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class HeaderConfig {

    public Map<String, String> getRequestHeaders() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        return request != null ? Collections.list(request.getHeaderNames())
                .stream()
                .collect(Collectors.toMap(headerName -> headerName, request::getHeader)) : Collections.emptyMap();
    }

    public String getId(){
        return this.getRequestHeaders().get("id");
    }
}
