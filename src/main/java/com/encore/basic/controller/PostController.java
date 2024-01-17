package com.encore.basic.controller;
import com.encore.basic.domain.PostReqDto;
import com.encore.basic.domain.PostResDto;
import com.encore.basic.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.NoSuchElementException;

@Controller
@RequestMapping("post")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("list")
    public String GetPostList(Model model) {
        model.addAttribute("postList", postService.posts());
        return "post-list";
    }

    @PostMapping("list")
    public String PostList(PostReqDto postReqDto) {
        postService.save(postReqDto);
        return "redirect:list";
    }

    @GetMapping()
    public String GetPostWriting() {
        return "post";
    }

    @PostMapping()
    public String PostWriting(PostReqDto postReqDto) {
        postService.save(postReqDto);
        return "redirect:post";
    }

    @GetMapping("detail")
    public String PostDetailView(@RequestParam(value = "id") int id, Model model) {
        try {
            PostResDto postResDto = postService.findById(id);
            model.addAttribute("postList", postResDto);
            return "detail";
        } catch (NoSuchElementException e) {
            return "404-error";
        }
    }

    @PostMapping("update")
    public String PostUpdate(PostReqDto postReqDto) {
        postService.update(postReqDto);

        return "redirect:/post/detail?id="+postReqDto.getId();
    }

    @GetMapping("delete")
    public String PostDelete(@RequestParam(value = "id") int id) {
        postService.delete(id);
        return "redirect:list";
    }
}
