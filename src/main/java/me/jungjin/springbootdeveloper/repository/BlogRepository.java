package me.jungjin.springbootdeveloper.repository;

import me.jungjin.springbootdeveloper.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article,Long> {
}
