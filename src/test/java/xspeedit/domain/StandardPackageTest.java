package xspeedit.domain;

import org.junit.Test;
import xspeedit.exception.OversizedPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StandardPackageTest {

    @Test
    public void should_contain_articles() {
        final StandardPackage aStandardPackage = new StandardPackage(Arrays.asList(1,6,3));

        final List<Integer> articles = aStandardPackage.getArticles();

        assertThat(articles).containsExactly(1,6,3);
    }

    @Test
    public void should_be_able_to_add_articles() throws OversizedPackage {
        final StandardPackage aStandardPackage = new StandardPackage(new ArrayList<>());

        final List<Integer> articles = aStandardPackage.addArticle(5);

        assertThat(articles).containsExactly(5);
    }

    @Test
    public void should_not_be_able_to_add_new_article_when_its_size_makes_package_over_size_limit() {
        final StandardPackage aStandardPackage = new StandardPackage(Arrays.asList(1,6,3));

        assertThatThrownBy(() -> aStandardPackage.addArticle(5))
                .isInstanceOf(OversizedPackage.class)
                .hasMessage("Cannot add article to package");
    }

    @Test
    public void should_return_articles_in_package_as_string() {
        final StandardPackage aStandardPackage = new StandardPackage(Arrays.asList(1,6,3));

        final String articles = aStandardPackage.getArticlesAsString();

        assertThat(articles).isEqualTo("163");
    }
}
