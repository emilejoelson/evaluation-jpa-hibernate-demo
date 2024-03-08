package org.example.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
    private static  final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Vol_Management_PersistenceUnit");
    public  static EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }
}