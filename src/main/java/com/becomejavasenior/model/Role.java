package com.becomejavasenior.model;

/**
 * Created by Roman on 29.01.2016.
 */
public enum Role {
    ADMIN("ADMIN"),

    CLIENT("CLIENT"),

    PAYMASTER("PAYMASTER");

    private String role;

    Role(String role) {
        this.role = role;
    }

    public static Role fromString(String role) {
        if (role != null) {
            for (Role ro : Role.values()) {
                if (role.equalsIgnoreCase(ro.role)) {
                    return ro;
                }
            }
        }
        return CLIENT;
    }

    @Override
    public String toString() {
        return role;
    }
}
