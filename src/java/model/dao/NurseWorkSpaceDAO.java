/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Nurse;
import model.pojo.Nurseworkspace;
import model.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Dora
 */
public class NurseWorkSpaceDAO {
    
    //護士站點
    public static List<Nurseworkspace> nurseWorkSpaceList(int nurseId){
        List<Nurseworkspace> lst = null;
        try{
            
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            
            //String hql = "from Nurseworkspace where nurseId = :nurseId";
            String hql = "from Workspace " +
"where id in (select workSpaceId from Nurseworkspace where nurseId = :nurseId)";
            Query query = session.createQuery(hql);
            query.setParameter("nurseId", nurseId);
            lst = query.list();
           
            session.close();
            
        } catch( Exception e){
            
            e.printStackTrace();
        }
        return lst;
    }
    
    //非護士的站點
    public static List<Nurseworkspace> nurseNotWorkSpaceList(int nurseId){
        List<Nurseworkspace> lst = null;
        try{
            
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            
            
            String hql = "from Workspace " +
"where id not in (select workSpaceId from Nurseworkspace where nurseId = "+nurseId+")";
            Query query = session.createQuery(hql);
            //query.setParameter("nurseId", nurseId);
            lst = query.list();
           
            session.close();
            
        } catch( Exception e){
            
            e.printStackTrace();
        }
        return lst;
    }
    
    //站點有那些護士
    public static List<Nurse> nurseOfWorkSpaceList(int workSpaceId){
        List<Nurse> lst = null;
        try{
            
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            
            
          
            Query query = session.createQuery("from Nurse where id in (select nurseId from Nurseworkspace where workSpaceId = :workSpaceId)");
            query.setParameter("workSpaceId", workSpaceId);
          
            lst = query.list();
           
            session.close();
            
        } catch( Exception e){
            
            e.printStackTrace();
        }
        return lst;
    }
    
    //站點刪除時, 護士管理的站點同時刪除
   public static int NurseWorkSpaceDel(int workId){
    
        int rowsAffected = 0;
        
        try{
            
            
            Session session = HibernateUtil.getSessionFactory().openSession();
           
 
            Query query = session.createQuery("delete Nurseworkspace where workSpaceId = :workId");           
            query.setParameter("workId", workId);
            rowsAffected = query.executeUpdate();
            
            session.close();
            
        } catch( Exception e){
            
            e.printStackTrace();
        }
        return rowsAffected;
    
    
    }
   
   
   //護士刪除時, 護士管理的站點同時刪除
   public static int NurseWorkSpace2Del(int nurseId){
    
        int rowsAffected = 0;
        
        try{
            
            
            Session session = HibernateUtil.getSessionFactory().openSession();
           
 
            Query query = session.createQuery("delete Nurseworkspace where nurseId = :nurseId");           
            query.setParameter("nurseId", nurseId);
            rowsAffected = query.executeUpdate();
            
            session.close();
            
        } catch( Exception e){
            
            e.printStackTrace();
        }
        return rowsAffected;
    
    
    }
   
   //新增護士管點的站點
   public static int NurseWorkSpaceAppend(String workId ,int nurseId){
    
        int rowsAffected = 0;
        
        try{
            
            
            Session session = HibernateUtil.getSessionFactory().openSession();
           
            String splitWorkId[] = workId.split(",");
            
            for (String s: splitWorkId) {
 
                String hql = "insert into Nurseworkspace (nurseId, workSpaceId, crtTime) value("+nurseId+","+s+",now())";
                Query query = session.createSQLQuery(hql);
 
                query.executeUpdate();
            }
            
            session.close();
            
        } catch( Exception e){
            
            e.printStackTrace();
        }
        return rowsAffected;
    
    
    }
   
   //移除護士管點的站點
   public static int NurseWorkSpaceRemove(String workId ,int nurseId){
    
        int rowsAffected = 0;
        
        try{
            
            
            Session session = HibernateUtil.getSessionFactory().openSession();
           
            
            
            String splitWorkId[] = workId.split(",");
            
            for (String s: splitWorkId) {
 
                String hql = "delete Nurseworkspace where workSpaceId ="+s+" and nurseId="+nurseId;
               
                
                Query query = session.createQuery(hql);           
            
                rowsAffected = query.executeUpdate();
            }
            
 
            
            session.close();
            
        } catch( Exception e){
            
            e.printStackTrace();
        }
        return rowsAffected;
    
    
    }
    
}
