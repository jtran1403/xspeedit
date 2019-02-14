package xspeedit.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PackageTest {

    @Test
    public void should_contain_articles() {
        final Package aPackage = new Package(Arrays.asList(1,6,3));

        final List<Integer> articles = aPackage.getArticles();

        assertThat(articles).containsExactly(1,6,3);
    }
}
