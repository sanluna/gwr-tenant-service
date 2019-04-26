package com.sanluna.tenant.controller;

import com.sanluna.tenant.model.GWRDatabaseInfo;
import com.sanluna.tenant.model.entity.GWRDatabaseInfoEntity;
import com.sanluna.tenant.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "tenants", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @PostMapping("")
    public GWRDatabaseInfo save(@RequestBody GWRDatabaseInfo dto) {
        return tenantService.save(dto.convertToEntity()).convertToDTO();
    }

    @GetMapping("")
    public List<GWRDatabaseInfo> fetchAll() {
        return tenantService.fetchAll().stream().map(GWRDatabaseInfoEntity::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("{tenantId}")
    public GWRDatabaseInfo getByTenant(@PathVariable("tenantId") String ID) {
        System.out.println("fetching tenant with id: " + ID);
        return tenantService.getByTenant(ID).convertToDTO();
    }

    @DeleteMapping("")
    public void delete(@RequestBody GWRDatabaseInfo dto) {
        tenantService.delete(dto.convertToEntity());
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") String ID) {
        tenantService.deleteById(ID);
    }


}
