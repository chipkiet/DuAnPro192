package org.example.xikethuoc.controller;


import org.example.xikethuoc.dao.DAO;
import org.example.xikethuoc.model.Category;
import org.example.xikethuoc.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/home")
public class ProductControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAO dao = new DAO();
        List<Product> list = dao.getAllProduct();

        List<Category> listC = dao.getAllCategory();
//        Kiểm tra sesion
        HttpSession session = req.getSession(false);
        if (session != null) {
            String username = (String) session.getAttribute("username");
            Integer isAdmin = (Integer) session.getAttribute("isAdmin");
            Integer isSell = (Integer) session.getAttribute("isSell");

            req.setAttribute("username", username);
            req.setAttribute("isAdmin", isAdmin);
            req.setAttribute("isSell", isSell);

        }

        req.setAttribute("listP", list);
        req.setAttribute("listCC", listC);

        req.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(req, resp);


    }
}