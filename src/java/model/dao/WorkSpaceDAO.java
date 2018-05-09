/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Workspace;
import model.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Dora
 */
public class WorkSpaceDAO {
    
    public static List<Workspace> workSpaceList(){
        List<Workspace> lst = null;
        try{
            
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            
            String hql = "from Workspace order by id";
            Query query = session.createQuery(hql);
            lst = query.list();
            
            session.close();
            
        } catch( Exception e){
            
            e.printStackTrace();
        }
        return lst;
    
    
    }
    
    public static List<Workspace> getWorkSpace(int workSpaceId){
        List<Workspace> lst = null;
        try{
            
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            
            String hql = "from Workspace where id = :workSpaceId";
            Query query = session.createQuery(hql);
            query.setParameter("workSpaceId", workSpaceId);
            lst = query.list();
            
            session.close();
            
        } catch( Exception e){
            
            e.printStackTrace();
        }
        return lst;
    
    
    }
    
    public static int workSpaceAppend(String workName){
    
        int rowsAffected = 0;
        
        try{
            
            
            Session session = HibernateUtil.getSessionFactory().openSession();
           
 
            String hql = "insert into Workspace (name, crtTime, uptTime) value('"+workName+"',now() ,now())";
            Query query = session.createSQLQuery(hql);
 
            rowsAffected = query.executeUpdate();
            
            session.close();
            
        } catch( Exception e){
            
            e.printStackTrace();
        }
        return rowsAffected;
    
    
    }
    
    
    public static int workSpaceUpdate(int workId,String workName){
    
        int rowsAffected = 0;
        
        try{
            
            
            Session session = HibernateUtil.getSessionFactory().openSession();
           
 
            Query query = session.createQuery("update Workspace set name = :workName , uptTime = now()"  +
    				" where id = :workId" 
            );
            query.setParameter("workName", workName);
            query.setParameter("workId", workId);
            rowsAffected = query.executeUpdate();
            
            session.close();
            
        } catch( Exception e){
            
            e.printStackTrace();
        }
        return rowsAffected;
    
    
    }
    
    public static int workSpaceDel(int workId){
    
        int rowsAffected = 0;
        
        try{
            
            
            Session session = HibernateUtil.getSessionFactory().openSession();
           
 
            Query query = session.createQuery("delete Workspace where id = :workId");           
            query.setParameter("workId", workId);
            rowsAffected = query.executeUpdate();
            
            session.close();
            
        } catch( Exception e){
            
            e.printStackTrace();
        }
        return rowsAffected;
    
    
    }
}
