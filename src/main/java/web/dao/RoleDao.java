package web.dao;

import web.model.Role;

public interface RoleDao {
    Role getById(Long id);
    Role getRoleByName (String name);
}
