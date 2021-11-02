package ru.job4j.dream.store;

import ru.job4j.dream.model.Post;

public class MainStore {
    public static void main(String[] args) {
        Store store = DbStore.instOf();
        store.save(new Post(0, "Java Job"));
        store.save(new Post(1, "Vas"));

        for (Post post : store.findAllPosts()) {
            System.out.println(post.getId() + " " + post.getName());
        }

    }
}