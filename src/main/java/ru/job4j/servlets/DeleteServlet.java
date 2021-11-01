package ru.job4j.servlets;

import ru.job4j.dream.store.DbStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        DbStore.instOf().deleteCandidateById(id);
        Files.deleteIfExists(Paths.get("d:\\images\\" + id + ".png"));
        resp.sendRedirect(req.getContextPath() + "/candidates.do");
    }
}
