package xspeedit.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PackageTest {

    @Test
    public void should_contain_articles() {
        final Package aPackage = new Package(Arrays.asList(1,6,3));

        final List<Integer> articles = aPackage.getArticles();

        assertThat(articles).containsExactly(1,6,3);
    }

    @Test
    public void should_be_able_to_add_articles() {
        final Package aPackage = new Package(new ArrayList<>());

        final List<Integer> articles = aPackage.addArticle(5);

        assertThat(articles).containsExactly(5);
    }
}
