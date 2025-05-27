package com.application.config;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvLoader {
    static {
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

        setSystemProperty("spring.data.mongodb.uri", dotenv.get("MONGODB_URI"));
        setSystemProperty("spring.data.mongodb.database", dotenv.get("MONGODB_DATABASE"));
        setSystemProperty("jwt.secret", dotenv.get("JWT_SECRET"));
        setSystemProperty("JWT_EXPIRATION", dotenv.get("JWT_EXPIRATION"));
    }

    private static void setSystemProperty(String key, String value) {
        if (value != null) {
            System.setProperty(key, value);
        }
    }
}
