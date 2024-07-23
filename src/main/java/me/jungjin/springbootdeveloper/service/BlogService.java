package me.jungjin.springbootdeveloper.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.jungjin.springbootdeveloper.entity.Article;
import me.jungjin.springbootdeveloper.dto.AddArticleRequest;
import me.jungjin.springbootdeveloper.dto.UpdateArticleRequest;
import me.jungjin.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor //final이 붙거나 @NotNull이 붙은 필드의 생성자 추가, 빈을 생성자로 생성
@Service //빈으로 등록
public class BlogService {
    private final BlogRepository blogRepository;

    //블로그 글 추가 메서드
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

    //블로그 글 조회
    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    public Article findById(Long id){
        return blogRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found: "+id));
    }

    public void delete(long id){
        blogRepository.deleteById(id);
    }

    @Transactional //트랜잭션 메서드 - 매칭한 메서드를 하나의 트랜잭션(DB의 데이터를 바꾸기 위해 묶은 작업 단위)으로 묶음
    public Article update(long id, UpdateArticleRequest request){
        Article article=blogRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found: "+id));
        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
