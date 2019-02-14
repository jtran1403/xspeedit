package xspeedit.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArticleTest {

    @Test
    public void should_define_an_article_with_size() {
        final Article article = new Article(5);

        assertThat(article.getSize()).isEqualTo(5);
    }

    @Test
    public void should_not_be_packed_by_default() {
        final Article article = new Article(5);

        assertThat(article.isPacked()).isFalse();
    }

    @Test
    public void should_be_packed_when_it_was_included_in_a_package() {
        final Article article = new Article(5);

        article.packed();

        assertThat(article.isPacked()).isTrue();
    }
}
