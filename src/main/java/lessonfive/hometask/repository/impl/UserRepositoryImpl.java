package lessonfive.hometask.repository.impl;

import lessonfive.hometask.model.User;
import lessonfive.hometask.repository.UserRepository;
import lessonfive.hometask.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public User create(User user) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.persist(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return user;
    }

    @Override
    public User update(User user) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            session.merge(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("select sss from User sss join fetch sss.roles where sss.id=:id", User.class)
                .setParameter("id", id)
                .getResultList()
                .stream()
                .findFirst();
        }
    }
}
