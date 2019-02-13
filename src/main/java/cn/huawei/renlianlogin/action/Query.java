package cn.huawei.renlianlogin.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
* @program: renlian
*
* @description: 登录验证类
*
* @author: huangmindong
*
* @create: 2019-02-10 14:25
**/
@WebServlet(name = "query",urlPatterns = "/query")
public class Query extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集编码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //获取前段页面传过来的参数
        String base=request.getParameter("base");

    }
}
