package com.sanluna.tenant.model.entity;

import com.sanluna.commons.model.entity.BaseEntity;
import com.sanluna.commons.util.Converter;
import com.sanluna.tenant.model.GWRDatabaseInfo;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class GWRDatabaseInfoEntity extends BaseEntity<GWRDatabaseInfoEntity> {

    @Column(name = "tenant", unique = true)
    private String tenant;
    @Column(name = "driver")
    private String driverClassName;
    @Column(name = "url")
    private String url;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
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

    public GWRDatabaseInfoEntity setTenant(String tenant) {
        this.tenant = tenant;
        return this;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public GWRDatabaseInfoEntity setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
        return this;
    }

    public String getUrl() {
        return "jdbc:mysql://" + url + "?useSSL=false&serverTimezone=UTC";
    }

    public GWRDatabaseInfoEntity setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public GWRDatabaseInfoEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public GWRDatabaseInfoEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public GWRDatabaseInfo convertToDTO() {
        return Converter.toDTO(this, new GWRDatabaseInfo())
                .setDriverClassName(getDriverClassName())
                .setPassword(getPassword())
                .setTenant(getTenant())
                .setUrl(getUrl())
                .setUsername(getUsername());
    }

    @Override
    public GWRDatabaseInfoEntity updateEntity(GWRDatabaseInfoEntity newEntity) {
        if(newEntity.getUsername() != null) setUsername(newEntity.getUsername());
        if(newEntity.getPassword() != null) setPassword(newEntity.getPassword());
        if(newEntity.getTenant() != null) setTenant(newEntity.getTenant());
        if(newEntity.getDriverClassName() != null) setDriverClassName(newEntity.getDriverClassName());
        if(newEntity.getUrl() != null) setUrl(newEntity.getUrl());
        return this;
    }
}
