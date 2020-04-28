package web.dao;

import lombok.ToString;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;
import web.model.User;
import web.service.RoleService;

import javax.persistence.TypedQuery;
import java.sql.PreparedStatement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@ToString
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private RoleService roleService;

    @Override
    public void add(User user) {
//        user.setRoles(getSetRole(user));
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User getUserById(Long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = sessionFactory.getCurrentSession().load(User.class, id);
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public User getUserByName(String name) {
        User user = null;
        Query query = sessionFactory.getCurrentSession().createQuery("from User where name = :name");
        query.setParameter("name", name);
        user = (User) query.getSingleResult();
        return user;
    }

//    private Set<Role> getSetRole(User user) {
//        Role admin = roleService.getById((long) 1);
//        Role userRole = roleService.getById((long) 2);
//        Set<Role> roleSet = new HashSet<>();
//        for (Role role : user.getRoles()) {
//            if (role.getName().equals("ROLE_ADMIN")) {
//                roleSet.add(admin);
//            }
//            if (role.getName().equals("ROLE_USER")) {
//                roleSet.add(userRole);
//            }
//        }
//        return roleSet;
//    }
}
