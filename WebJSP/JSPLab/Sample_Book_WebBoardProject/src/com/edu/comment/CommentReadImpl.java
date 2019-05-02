package com.edu.comment;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.BBSOracleDao;
import com.edu.bbs.BBSService;

import net.sf.json.JSONArray;
 
public class CommentReadImpl implements BBSService {
 
    @Override
    public String bbsService(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");        // JSON 한글 깨짐 해결
        
        int commPageNum = Integer.parseInt(req.getParameter("commPageNum"));
        String articleNumber = req.getParameter("articleNumber");
        ArrayList<CommentDto> comments = null;
        
        try {
            comments = BBSOracleDao.getInstance().selectComments(articleNumber, commPageNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JSONArray jsonArr =  JSONArray.fromObject(comments);      // 스프링에선 애노테이션(?)
        PrintWriter pw = resp.getWriter();
        pw.println(jsonArr);
        
        return null;
    }
 
}
