package com.encore.basic.service;

import com.encore.basic.domain.Post;
import com.encore.basic.domain.PostReqDto;
import com.encore.basic.domain.PostResDto;
import com.encore.basic.repository.PostRepository;
import com.encore.basic.repository.SpringDataJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(SpringDataJpaRepo springDataJpaRepo) {
        this.postRepository =  springDataJpaRepo;
    }

    public List<PostResDto> posts() {
        List<Post> posts = postRepository.findAll();
        List<PostResDto> postResDtos = new ArrayList<>();
        for (Post post : posts) {
            PostResDto postResDto = new PostResDto();
            postResDto.setId(post.getId());
            postResDto.setTitle(post.getTitle());
            postResDto.setContents(post.getContents());
            postResDto.setAuthor(post.getAuthor());
            postResDto.setCreate_time(post.getCreate_time());

            postResDtos.add(postResDto);
        }
        return postResDtos;

    }


    public void save(PostReqDto postReqDto) {
        Post post = new Post(postReqDto.getTitle(), postReqDto.getAuthor(), postReqDto.getContents());
        postRepository.save(post);
    }

    public PostResDto findById(int id) throws NoSuchElementException {
        PostResDto postResDto = new PostResDto();
        Post post = postRepository.findById(id).orElseThrow(NoSuchElementException::new);
        postResDto.setId(post.getId());
        postResDto.setTitle(post.getTitle());
        postResDto.setAuthor(post.getAuthor());
        postResDto.setContents(post.getContents());
        postResDto.setCreate_time(post.getCreate_time());

        return postResDto;
    }

    public void update(PostReqDto postReqDto) {
        Post post = postRepository.findById(postReqDto.getId()).orElseThrow(NoSuchElementException::new);
        post.UpdateTitleContents(postReqDto.getTitle(), postReqDto.getContents());
        postRepository.save(post);
    }

    public void delete(int id) {
        postRepository.delete(postRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }
}
