package xspeedit.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArticleTest {

    @Test
    public void should_define_an_article_with_size() {
        final Article article = new Article(5);
        assertThat(article.getSize()).isEqualTo(5);
    }
}
