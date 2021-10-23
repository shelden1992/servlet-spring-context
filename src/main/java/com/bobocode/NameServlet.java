package com.bobocode;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;

import java.io.IOException;


@WebServlet("/name")
public class NameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletContext servletContext = req.getServletContext();
        ApplicationContext springContext = (ApplicationContext) servletContext.getAttribute(MyInitializer.SPRING_APP_CONTEXT);
        try (ServletOutputStream outputStream = resp.getOutputStream()) {
            outputStream.print(springContext.getBean((NameProvider.class)).getName());
        }
    }
}
