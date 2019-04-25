package com.sanluna.tenant.model;

import com.sanluna.commons.model.BaseDTO;
import com.sanluna.tenant.model.entity.GWRDatabaseInfoEntity;

import static com.sanluna.commons.util.Converter.toEntity;


public class GWRDatabaseInfo extends BaseDTO<GWRDatabaseInfo> {

    private String tenant;
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "DatabaseConnectionInfo{" +
                "driverClassName='" + driverClassName + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public String getTenant() {
        return tenant;
    }

    public GWRDatabaseInfo setTenant(String tenant) {
        this.tenant = tenant;
        return this;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public GWRDatabaseInfo setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public GWRDatabaseInfo setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public GWRDatabaseInfo setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public GWRDatabaseInfo setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public GWRDatabaseInfoEntity convertToEntity() {
        return toEntity(this, new GWRDatabaseInfoEntity())
                .setDriverClassName(getDriverClassName())
                .setPassword(getPassword())
                .setTenant(getTenant())
                .setUrl(getUrl())
                .setUsername(getUsername());
    }
}
