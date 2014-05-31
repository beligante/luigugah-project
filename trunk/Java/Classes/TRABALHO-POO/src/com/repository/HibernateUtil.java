package com.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("CLINICA_PU");

    public static EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

}
