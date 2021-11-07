package ru.job4j.dream.servlet;

import org.junit.Test;
import ru.job4j.dream.model.Post;
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

public class PostServletTest {
    @Test
    public void whenUpdatePost() throws IOException, ServletException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("id")).thenReturn("1");
        when(req.getParameter("name")).thenReturn("name of new post");
        new PostServlet().doPost(req, resp);
        Post post = DbStore.instOf().findById(1);
        assertThat(post.getName(), is("name of new post"));
    }

    @Test
    public void whenCreatePost() throws ServletException, IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("id")).thenReturn("0");
        when(req.getParameter("name")).thenReturn("Mikhail");
        new PostServlet().doPost(req, resp);
        Collection<Post> posts = DbStore.instOf().findAllPosts();
        Optional<Post> post = posts.stream()
                .filter(p -> p.getName().equals("Mikhail"))
                .findFirst();

        assertThat(post.get().getName(), is("Mikhail"));
    }
}