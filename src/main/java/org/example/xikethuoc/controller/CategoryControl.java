package org.example.xikethuoc.controller;

import org.example.xikethuoc.dao.DAO;
import org.example.xikethuoc.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/category")
public class CategoryControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cateId = req.getParameter("cid");
        DAO dao = new DAO();
        List<Product> list =  dao.getProductByCID(cateId);
        req.setAttribute("listP",list);
        req.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(req, resp);

    }
}