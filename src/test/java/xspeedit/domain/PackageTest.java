package xspeedit.domain;

import org.junit.Test;
import xspeedit.exception.OversizedPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PackageTest {

    @Test
    public void should_contain_articles() {
        final Package aPackage = new Package(Arrays.asList(1,6,3));

        final List<Integer> articles = aPackage.getArticles();

        assertThat(articles).containsExactly(1,6,3);
    }

    @Test
    public void should_be_able_to_add_articles() throws OversizedPackage {
        final Package aPackage = new Package(new ArrayList<>());

        final List<Integer> articles = aPackage.addArticle(5);

        assertThat(articles).containsExactly(5);
    }

    @Test
    public void should_not_be_able_to_add_new_article_when_its_size_makes_package_over_size_limit() {
        final Package aPackage = new Package(Arrays.asList(1,6,3));

        assertThatThrownBy(() -> aPackage.addArticle(5))
                .isInstanceOf(OversizedPackage.class)
                .hasMessage("Cannot add article to package");
    }
}
