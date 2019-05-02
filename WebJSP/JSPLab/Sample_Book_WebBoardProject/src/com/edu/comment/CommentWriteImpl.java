package com.edu.comment;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.BBSOracleDao;
import com.edu.bbs.BBSService;

import net.sf.json.JSONObject;
 
public class CommentWriteImpl implements BBSService {
 
    @Override
    public String bbsService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        
        String id = req.getSession().getAttribute("id").toString();
        String commentContent = req.getParameter("commentContent");
        String articleNumber = req.getParameter("articleNumber");
        HashMap<String, Object> result = null;
        
        try {
            result = BBSOracleDao.getInstance().insertComment(id, commentContent, articleNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JSONObject jsonObj = JSONObject.fromObject(result);
        PrintWriter pw = resp.getWriter();
        pw.println(jsonObj);
        
        return null;
    }
 
}
