package ru.job4j.dream.servlet;

import org.junit.Test;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.store.DbStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;

public class CandidateServletTest {

    @Test
    public void whenCreatePost() throws ServletException, IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("id")).thenReturn("0");
        when(req.getParameter("name")).thenReturn("name of the new Candidate2");
        when(req.getParameter("cityId")).thenReturn("1");
        new CandidateServlet().doPost(req, resp);
        Collection<Candidate> candidates = DbStore.instOf().findAllCandidates();
        Optional<Candidate> candidate = candidates.stream()
                .filter(c -> c.getName().equals("name of the new Candidate2"))
                .findFirst();
        assertThat(candidate.get().getName(), is("name of the new Candidate2"));
    }

    @Test
    public void whenUpdatePost() throws ServletException, IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("id")).thenReturn("1");
        when(req.getParameter("name")).thenReturn("name of the new Candidate");
        when(req.getParameter("cityId")).thenReturn("1");
        new CandidateServlet().doPost(req, resp);
        Candidate candidate = DbStore.instOf().findCandidateById(1);
        assertThat(candidate.getName(), is("name of the new Candidate"));
    }
}