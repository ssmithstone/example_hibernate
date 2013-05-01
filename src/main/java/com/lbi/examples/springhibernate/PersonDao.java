package com.lbi.examples.springhibernate;

public interface PersonDao {

    void save(Person person) throws SpringHibernateCustomerExceptionExample.CustomException;
}
