package me.jungjin.springbootdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.jungjin.springbootdeveloper.domain.Article;

//DTO는 데이터를 옮기기기 위해 사용하는 전달자 역할의 개체, 비즈니스 로직을 포함하지 않음
@NoArgsConstructor //기본 생성자 추가
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자 추가
@Getter
public class AddArticleRequest {

    private String title;
    private String content;

    public Article toEntity(){ //생성자를 사용해 객체 생성 - 빌더 패턴을 사용해 DTO를 엔티티로 만들어줌(글 추가 시 저장할 엔티티로 변환하는 용도로 사용)
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
