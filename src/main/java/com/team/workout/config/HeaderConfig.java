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
        // 여기서 헤더를 가져와서 필요한 처리를 하면 됩니다.
        // 예를 들어, request.getHeader("headerName")을 사용하여 특정 헤더 값을 가져올 수 있습니다.
        return request != null ? Collections.list(request.getHeaderNames())
                .stream()
                .collect(Collectors.toMap(headerName -> headerName, request::getHeader)) : Collections.emptyMap();
    }

    public String getId(){
        return this.getRequestHeaders().get("id");
    }
}
