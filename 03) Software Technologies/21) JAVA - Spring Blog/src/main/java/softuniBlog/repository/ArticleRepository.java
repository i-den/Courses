package softuniBlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuniBlog.entity.Article;

/**
 * Created by Van on 07/08/2017.
 */
public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
