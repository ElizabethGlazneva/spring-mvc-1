package service;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

//@Component
@Transactional
@Service
public class UserServiceImpl {

    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
    public UserServiceImpl(){}

    //private SessionFactory sessionFactory;
    //@PersistenceContext
    //private EntityManager entityManager;
    //EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myJpaPersistenceUnit");
   // EntityManager entityManager = entityManagerFactory.createEntityManager();

   /* private static int user_id =0;
    public List<User> UserList;


    {
        UserList = new ArrayList<>();
        /*UserList.add(new User(++user_id, "Liza", "Glazneva", "glaz.mail"));
        UserList.add(new User(++user_id, "Dasha", "Galushko", "gal.mail"));
        UserList.add(new User(++user_id, "Anna", "Demidova", "nuta.mail"));
        UserList.add(new User(++user_id, "Sasha", "Bortich", "borabora.mail"));*/
    //}


    @SuppressWarnings("unchecked")
    public List<User> userList(){
        //return UserList;

        /*TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();*/
        //entityManager.createCriteria(User.class).list();
        //return entityManager.createQuery("select u from User",User.class).getResultList();
        //return entityManagerFactory.createEntityManager().createQuery("From User").getResultList();
        List<User> list = null;

        try (Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession()) {
            list = (List<User>) session.createQuery("From User").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public User findUserBuId(int id){
        //return UserList.stream().filter(user -> user.getId() == id).findAny().orElse(null);
       /* TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User where id= :id");
        query.setParameter("id",id);
        return query.getResultList().get(0);*/
        //return entityManager.find(User.class, id);
        User user = null;
        try (Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession()) {
            user = session.get(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public void save(User user){
        /*user.setId(++user_id);
        UserList.add(user);*/
        //sessionFactory.getCurrentSession().save(user);
        //entityManager.persist(user);
        try (Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void update(int id, User updatedUser){
        /*User userAfterUpdate = findUserBuId(id);
        userAfterUpdate.setName(updatedUser.getName());
        userAfterUpdate.setLastName(updatedUser.getLastName());
        userAfterUpdate.setEmail(updatedUser.getEmail());*/
        //entityManager.merge(updatedUser);
        try (Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession()) {
            session.beginTransaction();
            session.update(updatedUser);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id){
        //sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(User.class, id));
       // UserList.removeIf(user -> user.getId()==id);
        //entityManager.remove(findUserBuId(id));
        try (Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession()) {
            session.beginTransaction();
            session.remove(session.get(User.class, id));
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
