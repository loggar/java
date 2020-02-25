package com.loggar.json.gson;

import java.util.Arrays;

public class UserGson {

    public String name;
    public String email;
    private String[] roles;
    private boolean admin;

    public UserGson() {
    }

    public UserGson(String name, String email, String[] roles, boolean admin) {
        this.name = name;
        this.email = email;
        this.roles = roles;
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserGson [name=")
                .append(name)
                .append(", email=")
                .append(email)
                .append(", roles=")
                .append(Arrays.toString(roles))
                .append(", admin=")
                .append(admin)
                .append("]");
        return builder.toString();
    }

}
