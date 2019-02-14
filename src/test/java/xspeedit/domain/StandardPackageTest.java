package xspeedit.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StandardPackageTest {

    private StandardPackage standardPackage;

    @Before
    public void setUp() {
        standardPackage = new StandardPackage();
    }

    @Test
    public void should_be_initialized_without_articles() {
        final String articles = standardPackage.getArticlesAsString();

        assertThat(articles.isEmpty()).isTrue();
    }

    @Test
    public void should_return_true_if_new_article_is_added_successfully() {
        final boolean added = standardPackage.addNewArticle(5);
        assertThat(added).isTrue();
    }

    @Test
    public void should_return_true_if_new_article_cannot_be_added() {
        standardPackage.addNewArticle(9);

        final boolean added = standardPackage.addNewArticle(5);

        assertThat(added).isFalse();
    }

    @Test
    public void should_return_articles_in_package_as_string() {
        standardPackage.addNewArticle(1);
        standardPackage.addNewArticle(6);
        standardPackage.addNewArticle(3);

        final String articles = standardPackage.getArticlesAsString();

        assertThat(articles).isEqualTo("163");
    }
}
