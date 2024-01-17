package com.encore.basic.repository;

import com.encore.basic.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataJpaRepo extends PostRepository, JpaRepository<Post, Integer>{

}
