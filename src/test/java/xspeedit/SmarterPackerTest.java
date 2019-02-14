package xspeedit;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SmarterPackerTest {

    private SmarterPacker smarterPacker;

    @Before
    public void setUp() {
        smarterPacker = new SmarterPacker();
    }

    @Test
    public void should_add_articles_in_package() {
        final ArrayList<String> expectedArticles = new ArrayList<>();
        expectedArticles.add("163");

        final List<String> packedArticles = smarterPacker.pack("163");

        assertThat(packedArticles).containsExactlyElementsOf(expectedArticles);
    }

    @Test
    public void should_fill_package_with_article_of_complementary_size_when_next_article_is_too_big() {
        final ArrayList<String> expectedArticles = new ArrayList<>();
        expectedArticles.add("163");
        expectedArticles.add("4");

        final List<String> packedArticles = smarterPacker.pack("1643");

        assertThat(packedArticles).containsExactlyElementsOf(expectedArticles);
    }
}
