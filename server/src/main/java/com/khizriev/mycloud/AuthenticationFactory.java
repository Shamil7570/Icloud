package com.khizriev.mycloud;

public class AuthenticationFactory {
    public static AuthenticationService createAuthenticationService() {
        return new SqlDaoServiceLoggingProxy();
    }
}
