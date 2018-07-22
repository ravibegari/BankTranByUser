package com.persistent.bankmetadata.Dao;





import org.springframework.data.repository.CrudRepository;

import com.persistent.bankmetadata.security.Role;



public interface RoleDao extends CrudRepository<Role, Integer> {

    Role findByName(String name);
}
