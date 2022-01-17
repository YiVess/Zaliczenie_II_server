package com.example.emenu.service;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

public abstract class HibernateCRUDService <Entity, IdType extends Serializable>{

    @Autowired
    private EntityManager entityManager;

    private final Class<Entity> entityClass;

    public HibernateCRUDService(Class<Entity> entityClass) {
        this.entityClass = entityClass;
    }

    @Transactional
    public Entity getById(IdType id){

        Session session = entityManager.unwrap(Session.class);

        return session.get(entityClass,id);
    }

    @Transactional
    public List<Entity> getAll(){
        Session session = entityManager.unwrap(Session.class);

        return session.createQuery("from "+entityClass.getName()).getResultList();
    }

    @Transactional
    public void save(Entity entity){
        Session session = entityManager.unwrap(Session.class);

        session.save(entity);
    }

    @Transactional
    public void update(Entity entity){
        Session session = entityManager.unwrap(Session.class);

        session.update(entity);
    }

    @Transactional
    public void saveOrUpdate(Entity entity){
        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(entity);
    }

    @Transactional
    public void deleteById(IdType id){
        Session session = entityManager.unwrap(Session.class);

        session.createQuery("delete from "+entityClass.getName()+" where id="+id).executeUpdate();
    }

    @Transactional
    public List<Entity> createGetListQuery(String string){
        Session session = entityManager.unwrap(Session.class);

        return session.createQuery(string).getResultList();
    }

    @Transactional
    public Entity createGetIndividualQuery(String string){
        Session session = entityManager.unwrap(Session.class);

        return session.createQuery(string,entityClass).getResultList().get(0);
    }

    @Transactional
    public void createUpdateQuery(String string){
        Session session = entityManager.unwrap(Session.class);

        session.createQuery(string).executeUpdate();
    }
}
