package xspeedit.domain;

import org.junit.Before;
import org.junit.Test;
import xspeedit.exception.OversizedPackage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StandardPackageTest {

    private StandardPackage standardPackage;

    @Before
    public void setUp() {
        standardPackage = new StandardPackage();
    }

    @Test
    public void should_be_initialized_without_articles() {
        final List<Integer> articles = standardPackage.getArticles();

        assertThat(articles.isEmpty()).isTrue();
    }

    @Test
    public void should_contain_articles() throws OversizedPackage {
        standardPackage.addArticle(1);
        standardPackage.addArticle(6);
        standardPackage.addArticle(3);

        final List<Integer> articles = standardPackage.getArticles();

        assertThat(articles).containsExactly(1,6,3);
    }

    @Test
    public void should_be_able_to_add_articles() throws OversizedPackage {
        final List<Integer> articles = standardPackage.addArticle(5);

        assertThat(articles).containsExactly(5);
    }

    @Test
    public void should_not_be_able_to_add_new_article_when_its_size_makes_package_over_size_limit()
            throws OversizedPackage {
        standardPackage.addArticle(1);
        standardPackage.addArticle(6);
        standardPackage.addArticle(3);

        assertThatThrownBy(() -> standardPackage.addArticle(5))
                .isInstanceOf(OversizedPackage.class)
                .hasMessage("Cannot add article to package");
    }

    @Test
    public void should_return_articles_in_package_as_string() throws OversizedPackage {
        standardPackage.addArticle(1);
        standardPackage.addArticle(6);
        standardPackage.addArticle(3);

        final String articles = standardPackage.getArticlesAsString();

        assertThat(articles).isEqualTo("163");
    }
}
