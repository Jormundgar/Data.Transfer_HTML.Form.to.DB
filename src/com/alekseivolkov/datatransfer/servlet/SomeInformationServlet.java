package com.alekseivolkov.datatransfer.servlet;

import com.alekseivolkov.datatransfer.util.JspHelper;
import com.alekseivolkov.datatransfer.util.UrlPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(UrlPath.TARGET)
public class SomeInformationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspHelper.getPath("someinformation"))
                .forward(req, resp);
    }
}
