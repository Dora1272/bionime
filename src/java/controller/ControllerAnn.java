/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.dao.NurseDAO;
import model.dao.NurseWorkSpaceDAO;
import model.dao.WorkSpaceDAO;
import model.pojo.Nurse;
import model.pojo.Nurseworkspace;
import model.pojo.Workspace;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dora
 */
@Controller
public class ControllerAnn {

    //站點清單
    @RequestMapping(value = "/WorkSpaceManage")
    public ModelAndView workSpaceList() {

        ModelAndView mv = new ModelAndView("/jsp/workSpaceMan.jsp");
        try {
            List<Workspace> lst = WorkSpaceDAO.workSpaceList();
            mv.addObject("listWS", lst);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return mv;

    }

    

    //站點新增導頁
    @RequestMapping(value = "/WorkSpaceAppend")
    public ModelAndView workSpaceAppend() {

        ModelAndView modelAndView = new ModelAndView("/jsp/workSpaceAppend.jsp");
        modelAndView.addObject("status", "F");

        return modelAndView;
    }

    //站點新增儲存
    @RequestMapping(value = "/WorkSpaceAppendSave", method = RequestMethod.GET)
    public ModelAndView workSpaceAppendSave(@RequestParam("workSpaceName") String workSpaceName) {
        ModelAndView modelAndView = new ModelAndView("/jsp/123.jsp");

        int rowsAffected = WorkSpaceDAO.workSpaceAppend(workSpaceName);

        String message = "";
        if (rowsAffected > 0) {
            message = "新增成功";
        } else {
            message = "新增失敗";
        }

        //modelAndView.addObject("message", message);
        //modelAndView.addObject("status", "T");
        return modelAndView;
    }

    //站點異動導頁
    @RequestMapping(value = "/WorkSpaceModify", method = RequestMethod.GET)
    public ModelAndView workSpaceView(@RequestParam("workSpaceId") String workSpaceId) {

        ModelAndView mv = new ModelAndView("/jsp/workSpaceView.jsp");
        try {
            List<Nurse> lst = NurseWorkSpaceDAO.nurseOfWorkSpaceList(Integer.parseInt(workSpaceId));
            mv.addObject("list", lst);

            int id = WorkSpaceDAO.getWorkSpace(Integer.parseInt(workSpaceId)).get(0).getId();
            mv.addObject("spaceId", id);

            String name = WorkSpaceDAO.getWorkSpace(Integer.parseInt(workSpaceId)).get(0).getName();
            mv.addObject("spaceName", name);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return mv;

    }

    //站點異動儲存
    @RequestMapping(value = "/WorkSpaceModifySave", method = RequestMethod.GET)
    public ModelAndView workSpaceViewSave(@RequestParam("workSpaceId") String workSpaceId, @RequestParam("workSpaceName") String workSpaceName) {

        ModelAndView mv = new ModelAndView("/jsp/workSpaceView.jsp");
        try {

            WorkSpaceDAO.workSpaceUpdate(Integer.parseInt(workSpaceId), workSpaceName);

            List<Nurse> lst = NurseWorkSpaceDAO.nurseOfWorkSpaceList(Integer.parseInt(workSpaceId));
            mv.addObject("list", lst);

            int id = WorkSpaceDAO.getWorkSpace(Integer.parseInt(workSpaceId)).get(0).getId();
            mv.addObject("spaceId", id);

            String name = WorkSpaceDAO.getWorkSpace(Integer.parseInt(workSpaceId)).get(0).getName();
            mv.addObject("spaceName", name);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return mv;

    }

    //站點刪除
    @RequestMapping(value = "/WorkSpaceDel", method = RequestMethod.GET)
    public ModelAndView workSpaceDel(@RequestParam("workSpaceId") String workSpaceId) {

        ModelAndView mv = new ModelAndView("/jsp/workSpaceMan.jsp");
        try {

            WorkSpaceDAO.workSpaceDel(Integer.parseInt(workSpaceId));
            NurseWorkSpaceDAO.NurseWorkSpaceDel(Integer.parseInt(workSpaceId));

            List<Workspace> lst = WorkSpaceDAO.workSpaceList();
            mv.addObject("listWS", lst);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return mv;

    }

    //護士新增導頁
    @RequestMapping(value = "/NurseAppend")
    public ModelAndView nurseAppend() {

        ModelAndView mv = new ModelAndView("/jsp/nurseAppend.jsp");
        mv.addObject("id",0);
        mv.addObject("status",'F');
        
        return mv;
    }
    
    
    
    //護士新增儲存
    @RequestMapping(value = "/NurseAppendSave", method = RequestMethod.POST)
    public ModelAndView nurseAppendSave(@RequestParam("nurseId") String nurseId,@RequestParam("nurseName") String nurseName) {
        
        ModelAndView modelAndView = new ModelAndView("/jsp/nurseWorkList.jsp");
        
        try {
            
            int idCount = NurseDAO.getNurseId(nurseId).size();
            
            int id = 0;
            
            if(idCount == 0){
                //無重複的編號
                NurseDAO.nurseAppend(nurseId,nurseName);
                
                id = NurseDAO.getNurseId(nurseId).get(0).getId();               
               
                modelAndView.addObject("status",'T');
                
                
            }else{
                
                modelAndView.addObject("status",'F');
            }
            
            modelAndView.addObject("id",id);
            
            List<Nurseworkspace> lst = NurseWorkSpaceDAO.nurseNotWorkSpaceList(id);
            modelAndView.addObject("list", lst);
            
            List<Nurseworkspace> lstIn = NurseWorkSpaceDAO.nurseWorkSpaceList(id);
            modelAndView.addObject("lstIn", lstIn);
        } catch (Exception e) {

            e.printStackTrace();
        }

        
        return modelAndView;
    }
    
    //護士站點清單
    @RequestMapping(value = "/NurseWorkList", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView nurseWorkList(@RequestParam("id") String id) {

        ModelAndView mv = new ModelAndView("/jsp/nurseWorkList.jsp");
        try {
            
            List<Nurseworkspace> lst = NurseWorkSpaceDAO.nurseNotWorkSpaceList(Integer.parseInt(id));
            mv.addObject("list", lst);
            
            List<Nurseworkspace> lstIn = NurseWorkSpaceDAO.nurseWorkSpaceList(Integer.parseInt(id));
            mv.addObject("lstIn", lstIn);
           
        } catch (Exception e) {

            e.printStackTrace();
        }

        return mv;
    }
    
    //護士站點新增
    @RequestMapping(value = "/NurseWorkAppend", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView nurseWorkAppend(@RequestParam("nurseId") String id,@RequestParam("workId") String workId) {

        ModelAndView mv = new ModelAndView("/jsp/nurseWorkList.jsp");
        try {
            
            NurseWorkSpaceDAO.NurseWorkSpaceAppend(workId, Integer.parseInt(id));
            
            List<Nurseworkspace> lst = NurseWorkSpaceDAO.nurseNotWorkSpaceList(Integer.parseInt(id));
            mv.addObject("list", lst);
            
            List<Nurseworkspace> lstIn = NurseWorkSpaceDAO.nurseWorkSpaceList(Integer.parseInt(id));
            mv.addObject("lstIn", lstIn);
           
        } catch (Exception e) {

            e.printStackTrace();
        }

        return mv;
    }
    
    //護士站點移除
    @RequestMapping(value = "/NurseWorkRemove", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView nurseWorkRemove(@RequestParam("nurseId") String id,@RequestParam("workId") String workId) {

        ModelAndView mv = new ModelAndView("/jsp/nurseWorkList.jsp");
        try {
            
            NurseWorkSpaceDAO.NurseWorkSpaceRemove(workId, Integer.parseInt(id));
            
            List<Nurseworkspace> lst = NurseWorkSpaceDAO.nurseNotWorkSpaceList(Integer.parseInt(id));
            mv.addObject("list", lst);
            
            List<Nurseworkspace> lstIn = NurseWorkSpaceDAO.nurseWorkSpaceList(Integer.parseInt(id));
            mv.addObject("lstIn", lstIn);
           
        } catch (Exception e) {

            e.printStackTrace();
        }

        return mv;
    }
    
    //護士清單
    @RequestMapping(value = "/NurseManage")
    public ModelAndView nurseList() {

        ModelAndView mv = new ModelAndView("/jsp/nurseMan.jsp");
        try {
            List<Nurse> lst = NurseDAO.nurseList();
            mv.addObject("list", lst);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return mv;

    }

    //護士異動導頁
    @RequestMapping(value = "/NurseModify", method = RequestMethod.GET)
    public ModelAndView nurseView(@RequestParam("id") String id) {

        ModelAndView mv = new ModelAndView("/jsp/nurseView.jsp");
        try {
           
            String nurseId = NurseDAO.getId(Integer.parseInt(id)).get(0).getNurseId();
            String nurseName = NurseDAO.getId(Integer.parseInt(id)).get(0).getName();
            mv.addObject("id", id);
            mv.addObject("nurseId", nurseId);
            mv.addObject("nurseName", nurseName);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return mv;

    }
    
    //護士刪除
    @RequestMapping(value = "/NurseDel", method = RequestMethod.GET)
    public ModelAndView nurseDel(@RequestParam("id") String id) {

        ModelAndView mv = new ModelAndView("/jsp/nurseMan.jsp");
        try {

            NurseDAO.nurseDel(Integer.parseInt(id));
            NurseWorkSpaceDAO.NurseWorkSpace2Del(Integer.parseInt(id));

            List<Nurse> lst = NurseDAO.nurseList();
            mv.addObject("list", lst);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return mv;

    }
}
