package com.example.tasty.profile.DAO;

import com.example.tasty.DAO.HibernateAbstractDAO;
import com.example.tasty.profile.entity.ProfileData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class ProfileDataDAO extends HibernateAbstractDAO<ProfileData,String> {

    @Autowired
    public ProfileDataDAO(EntityManager entityManager) {
        super(ProfileData.class);
    }
}
