package com.abc.controller;

import com.abc.common.Comm;
import com.abc.dao.entity.Emp;
import com.abc.service.factory.ServiceFactory;
import com.abc.service.iservice.IEmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmpFindByIdServlet",urlPatterns = {"/empbyid"})
public class EmpFindByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int empno = Integer.parseInt(request.getParameter("empno"));
        IEmpService empService = (IEmpService) ServiceFactory.getInstance(Comm.EMP);
        Emp emp = empService.findById(empno);
        //反馈--JAVA模板引擎
        if(emp != null){
            List<Emp> emps = new ArrayList<Emp>();
            emps.add(emp);
            request.setAttribute("empsFromServer",emps);
            request.getRequestDispatcher("/emps.jsp").forward(request,response);
        }else{
            HttpSession session = request.getSession();
            session.setAttribute("errMsg","精确查询失败");
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int empno = Integer.parseInt(request.getParameter("empno"));
        IEmpService empService = (IEmpService) ServiceFactory.getInstance(Comm.EMP);
        Emp emp = empService.findById(empno);
        if (emp != null) {
            request.setAttribute("emp", emp);
            request.getRequestDispatcher("/updateemp.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("errMsg", "无此员工信息，修改失败");
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}

