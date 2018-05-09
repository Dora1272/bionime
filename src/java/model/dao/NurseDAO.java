/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Nurse;
import model.pojo.Workspace;
import model.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Dora
 */
public class NurseDAO {
    
    //判斷編號有無重複
    public static List<Nurse> getNurseId(String nurseId){
    
        List<Nurse> lst = null;
        try{
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            
            String hql = "from Nurse where status = 'T' and nurseId = :nurseId";
            Query query = session.createQuery(hql);
            query.setParameter("nurseId", nurseId);
            lst = query.list();
            
            session.close();
            
        } catch( Exception e){
            
            e.printStackTrace();
        }
        return lst;
    }
    
    //依ID取資料
    public static List<Nurse> getId(int id){
    
        List<Nurse> lst = null;
        try{
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            
            String hql = "from Nurse where status = 'T' and id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            lst = query.list();
            
            session.close();
            
        } catch( Exception e){
            
            e.printStackTrace();
        }
        return lst;
    }
    
    public static List<Nurse> nurseList(){
        List<Nurse> lst = null;
        try{
                        
            Session session = HibernateUtil.getSessionFactory().openSession();
            
            String hql = "from Nurse where status = 'T'";
            Query query = session.createQuery(hql);
            lst = query.list();
            
            session.close();
            
        } catch( Exception e){
            
            e.printStackTrace();
        }
        return lst;
    }
    
    public static int nurseAppend(String nurseId, String nurseName){
    
        int rowsAffected = 0;
        
        try{
            
            
            Session session = HibernateUtil.getSessionFactory().openSession();
           
 
            String hql = "insert into Nurse (nurseId, name, status, crtTime, uptTime) value('"+nurseId+"','"+nurseName+"','T',now(),now())";
            Query query = session.createSQLQuery(hql);
 
            rowsAffected = query.executeUpdate();
            
            session.close();
            
        } catch( Exception e){
            
            e.printStackTrace();
        }
        return rowsAffected;
    
    
    }
    
    
    public static int nurseUpdate(int id,String nurseId, String nurseName){
    
        int rowsAffected = 0;
        
        try{
            
            
            Session session = HibernateUtil.getSessionFactory().openSession();
           
 
            Query query = session.createQuery("update Nurse set name = :nurseName ,nuseId = :nurseId, uptTime = now()" +
    				" where id = :id");
            query.setParameter("nurseName", nurseName);
            query.setParameter("nurseId", nurseId);
            query.setParameter("id", id);
            rowsAffected = query.executeUpdate();
            
            session.close();
            
        } catch( Exception e){
            
            e.printStackTrace();
        }
        return rowsAffected;
    
    
    }
    
    public static int nurseDel(int id){
    
        int rowsAffected = 0;
        
        try{
            
            
            Session session = HibernateUtil.getSessionFactory().openSession();
           
 
            Query query = session.createQuery("update Nurse set status = 'F', uptTime = now()" +
    				" where id = :id");
           
            query.setParameter("id", id);
            rowsAffected = query.executeUpdate();
            
            session.close();
            
        } catch( Exception e){
            
            e.printStackTrace();
        }
        return rowsAffected;
    
    
    }
}
