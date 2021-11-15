package ru.job4j.dream.store;

import org.junit.Test;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class DbStoreTest {

    @Test
    public void whenCreatePost() {
        Store store = DbStore.instOf();
        Post post = new Post(0, "Java Job");
        store.save(post);
        Post postInDb = store.findById(post.getId());
        assertThat(postInDb.getName(), is(post.getName()));
    }

    @Test
    public void whenCreateCandidate() {
        Store store = DbStore.instOf();
        Candidate candidate = new Candidate(0, "Vasiliy", 1);
        store.save(candidate);
        Candidate canInDb = store.findCandidateById(candidate.getId());
        assertThat(candidate.getName(), is(canInDb.getName()));
    }

    @Test
    public void whenDeleteCandidate() {
        Store store = DbStore.instOf();
        Candidate candidate = new Candidate(0, "Vasiliy", 1);
        store.save(candidate);
        store.deleteCandidateById(candidate.getId());
        assertThat(store.findCandidateById(candidate.getId()), is(nullValue()));
    }

    @Test
    public void whenUpdatePost() {
        Store store = DbStore.instOf();
        store.save(new Post(1, "Post2"));
        assertThat(store.findById(1).getName(), is("Post2"));
    }

    @Test
    public void whenFindAllPosts() {
        Store store = DbStore.instOf();
        assertThat(store.findAllPosts().isEmpty(), is(false));
    }
}