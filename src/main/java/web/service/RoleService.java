package web.service;

import web.model.Role;

public interface RoleService {

    Role getById(Long id);

    Role getRoleByName (String name);
}
