package com.lbi.examples.springhibernate;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SpringHibernateCustomerExceptionExample implements PersonDao {

    @Autowired
    public SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    @Transactional
    public void save(Person person) throws CustomException {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.save(person);
        } catch (DataIntegrityViolationException e) {
            System.out.println("DataIntegrityViolationException = " + e.getMessage());
            throw new CustomException();
        }
    }

    public static class CustomException extends Exception {

    }
}
