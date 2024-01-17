package com.encore.basic.repository;

import com.encore.basic.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    public List<Post> findAll();

    public Post save(Post post);

    public Optional<Post> findById(int id);

    public void delete(Post post);
}
