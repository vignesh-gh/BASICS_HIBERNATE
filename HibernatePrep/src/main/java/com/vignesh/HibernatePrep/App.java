package com.vignesh.HibernatePrep;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) 
    {
        Goverment goverment = new Goverment();
        goverment.setDistrict("namakkal");
        goverment.setState("TN");
        
        Configuration conf= new Configuration().configure("hibernate_config.xml").addAnnotatedClass(Goverment.class);
        
        SessionFactory sf=conf.buildSessionFactory();
        
        Session session =sf.openSession();
        
        org.hibernate.Transaction t=session.beginTransaction();
        
        session.save(goverment);
        
		/*
		 * goverment= session.get(Goverment.class,3); System.out.println(goverment);
		 */
        t.commit();
       
        
        
    }
}
