package com.services.impl;

import com.models.Dog;
import com.services.IDogService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 使用Hibernate的sessionFactory对数据进行保存等操作
 */
@Service
public class DogService implements IDogService {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Dog create(Dog dogForm) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        if (dogForm != null) {
            Dog dog = new Dog();
            dog.setName(dogForm.getName());
            session.save(dog);
            return dog;
        }
        return null;
    }

    @Override
    public Dog findById(Integer id) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        Criteria c = session.createCriteria(Dog.class);
        c.add(Restrictions.eq("id",id));
        return (Dog) c.uniqueResult();
    }

    @Override
    public Dog update(Dog dogForm) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        Dog dog = findById(dogForm.getId());
        if (dog != null) {
            dog.setName(dogForm.getName());
            session.update(dog);
        }
        return dog;
    }

    @Override
    public Boolean delById(Integer id) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        Dog dog = findById(id);
        if (dog != null) {
            session.delete(dog);
        }
        return true;
    }
}
