package com.example.tasty.profile;

import com.example.tasty.service.HibernateAbstractService;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProfileService extends HibernateAbstractService<Profile, String> {

    public ProfileService() {
        super(Profile.class);
    }


    @Transactional
    public Profile logIn(Profile profile){

        Session session = this.entityManager.unwrap(Session.class);

        Query<Profile> query = session.createQuery("from Profile where id=:id and password=:password", Profile.class)
                .setParameter("id",profile.getId()).setParameter("password",profile.getPassword());


        if(query.getResultList().isEmpty()){
            return null;
        }

        return query.getSingleResult();

    }

}
