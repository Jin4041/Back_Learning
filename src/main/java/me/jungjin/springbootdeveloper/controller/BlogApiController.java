package me.jungjin.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.jungjin.springbootdeveloper.entity.Article;
import me.jungjin.springbootdeveloper.dto.AddArticleRequest;
import me.jungjin.springbootdeveloper.dto.ArticleResponse;
import me.jungjin.springbootdeveloper.dto.UpdateArticleRequest;
import me.jungjin.springbootdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController //HTTP Response Body에 객체 데이터를 JSON 형식으로 반환하는 컨트롤러
public class BlogApiController {

    private final BlogService blogService;

    //HTTP 메서드가 POST일 때 전달받은 URL과 동일하면 메서드로 매핑
    @PostMapping("/api/articles")
    //@RequestBody로 요청 본문 값 매핑
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){ //RequestBody는 HTTP 요청 시 응답에 해당하는 값을  RequestBody가 붙은 대상 객체에 매핑
        Article savedArticle = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    //전체 글을 조회한 뒤 반환하는 메서드
    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles(){
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(articles);
    }

    @GetMapping("/api/articles/{id}")
    //URL 경로에서 값 추출 - {id}에 해당하는 값이 id로 들어옴
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id){
        Article article = blogService.findById(id);

        return ResponseEntity.ok()
                .body(new ArticleResponse(article));
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id){
        blogService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/articles/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id,
                                                 @RequestBody UpdateArticleRequest request){
        Article updateArticle=blogService.update(id,request);

        return ResponseEntity.ok()
                .body(updateArticle);
    }
}
