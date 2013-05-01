package com.lbi.examples.springhibernate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-config.xml"})
public class SpringHibernateCustomerExceptionsTest {

    @Autowired
    PersonDao example;

    @Test(expected = SpringHibernateCustomerExceptionExample.CustomException.class)
    public void testName() throws SpringHibernateCustomerExceptionExample.CustomException {
        assertThat(example, notNullValue());
        Person person = new Person();
        try {
            example.save(person);
        } catch (SpringHibernateCustomerExceptionExample.CustomException e) {

        }
        catch(DataIntegrityViolationException e){
            throw new SpringHibernateCustomerExceptionExample.CustomException();
        }
    }
}

