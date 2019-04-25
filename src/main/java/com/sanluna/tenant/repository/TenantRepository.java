package com.sanluna.tenant.repository;

import com.sanluna.commons.repository.AOWR_Repository;
import com.sanluna.tenant.model.entity.GWRDatabaseInfoEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends AOWR_Repository<GWRDatabaseInfoEntity> {

    GWRDatabaseInfoEntity getByTenant(String tenant);

}
