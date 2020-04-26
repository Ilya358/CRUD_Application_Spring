package web.dao;

import lombok.ToString;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;

import java.util.List;

@Repository
@ToString
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Role getById(Long id) {
        return sessionFactory.getCurrentSession().get(Role.class, id);
    }

    @Override
    public Role getRoleByName(String name) {
        Role role1 = null;
        List<Role> roleList = sessionFactory.getCurrentSession().createQuery("from Role").getResultList();
        for(Role role : roleList){
            if(role.getName().equals(name)){
                role1 = role;
            }
        }
        return role1;
//        Role role = null;
//        Query query = sessionFactory.getCurrentSession().createQuery("from Role where name = :name");
//        query.setParameter("name", name);
//        role = (Role) query.getSingleResult();
//        return role;
    }
}
