package com.example.demo.security;

import com.example.demo.SpringApplicationContext;

class  SecurityConstants {

    static final long EXPIRATION_TIME = 864000000;

    static final String TOKEN_PREFIX = "Bearer ";

    static final String HEADER_STRING = "Authorization";

    static final String SIGN_UP_URL = "/users";

    static String getTokenSecret() {
        AppProperties appProperties = (AppProperties) SpringApplicationContext.getBean("appProperties");
        return appProperties.getTokenSecret();
    }
}
