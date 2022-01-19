package com.example.tasty.profile.DAO;

import com.example.tasty.DAO.HibernateAbstractDAO;
import com.example.tasty.profile.entity.Profile;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class ProfileDAO extends HibernateAbstractDAO<Profile,String> {

    @Autowired
    public ProfileDAO(EntityManager entityManager) {
        super(Profile.class);
    }

    public boolean isLoginSuccessful(Profile profile){
        Session session = this.entityManager.unwrap(Session.class);

        Profile temp = session.createQuery("from Profile where id=:username and password=:password",Profile.class)
                .setParameter("username",profile.getId()).setParameter("password",profile.getPassword()).getSingleResult();

        if(temp == null)
            return false;
        else
            return true;
    }

}
