package model.pojo;
// Generated 2018/5/8 下午 04:08:19 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Workspace generated by hbm2java
 */
public class Workspace  implements java.io.Serializable {


     private Integer id;
     private String name;
     private Date crtTime;
     private Date uptTime;

    public Workspace() {
    }

    public Workspace(String name, Date crtTime, Date uptTime) {
       this.name = name;
       this.crtTime = crtTime;
       this.uptTime = uptTime;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Date getCrtTime() {
        return this.crtTime;
    }
    
    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }
    public Date getUptTime() {
        return this.uptTime;
    }
    
    public void setUptTime(Date uptTime) {
        this.uptTime = uptTime;
    }




}

