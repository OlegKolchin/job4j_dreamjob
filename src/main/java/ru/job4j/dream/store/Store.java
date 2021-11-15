package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import java.util.Collection;

public interface Store {
    Collection<Post> findAllPosts();

    Collection<Candidate> findAllCandidates();

    Collection<Candidate> findNewCandidates();

    Collection<Post> findNewPosts();

    Collection<City> findAllCities();

    Collection<User> findAllUsers();

    void save(Post post);

    void save(Candidate candidate);

    void save(User user);

    Post findById(int id);

    Candidate findCandidateById(int id);

    User findByEmail(String email);

    void deleteCandidateById(int id);

    void deleteUserByEmail(String email);











}