package ru.javamentor.springBoot.dao;

import org.springframework.stereotype.Repository;
import ru.javamentor.springBoot.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public UserDAOImpl() {
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(User user) {
        entityManager.remove(user);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u").getResultList();
    }

    @Override
    public void updateUser(long id, String firstName, String lastName, byte age) {
        User user = fingUser(id);
        entityManager.merge(user);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(age);
    }

    @Override
    public User fingUser(long id) {
        return entityManager.find(User.class, id);
    }
}
