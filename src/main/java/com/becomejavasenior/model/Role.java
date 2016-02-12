package com.becomejavasenior.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Roman on 29.01.2016.
 */
public enum Role {
    ADMIN("ADMIN"),

    CLIENT("CLIENT"),

    PAYMASTER("PAYMASTER");

    static final Logger logger = LogManager.getRootLogger();
    private String role;

    Role(String role) {
        this.role = role;
    }

    public static Role fromString(String role) {
        if (role != null) {
            logger.info("Заходим в метод");
            for (Role ro : Role.values()) {

                if (role.equalsIgnoreCase(ro.toString())) {
                    return ro;
                }
                logger.info("Перебираем значения");
            }
        }
          return CLIENT;
      //  throw new IllegalArgumentException("No such value");
    }

    @Override
    public String toString() {
        return role;
    }

}
