package com.sanluna.tenant.service;

import com.sanluna.commons.service.GenericService;
import com.sanluna.tenant.model.entity.GWRDatabaseInfoEntity;
import com.sanluna.tenant.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantService extends GenericService<GWRDatabaseInfoEntity> {

    @Autowired
    private TenantRepository repository;

    public GWRDatabaseInfoEntity getByTenant(String tenantId){
        return repository.getByTenant(tenantId);
    }

}
