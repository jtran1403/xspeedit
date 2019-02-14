package xspeedit;

import org.junit.Before;
import org.junit.Test;
import xspeedit.domain.StandardPackage;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SimplePackerTest {

    private SimplePacker simplePacker;

    @Before
    public void setUp() {
        simplePacker = new SimplePacker();
    }

    @Test
    public void should_add_articles_in_package() {
        final SimplePacker simplePacker = new SimplePacker();
        final ArrayList<String> expectedArticles = new ArrayList<>();
        expectedArticles.add("163");

        final List<String> packedArticles = simplePacker.pack("163");

        assertThat(packedArticles).containsExactlyElementsOf(expectedArticles);
    }

    @Test
    public void should_add_new_article_in_new_package_if_current_package_cannot_fit_it() {
        final SimplePacker simplePacker = new SimplePacker();

        final List<String> packedArticles = simplePacker.pack("1635");

        assertThat(packedArticles).containsExactly("163", "5");
    }
}
