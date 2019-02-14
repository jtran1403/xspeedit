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
    public void should_be_initialized_with_an_empty_standard_package() {
        final StandardPackage expectedEmptyStandardPackage = new StandardPackage();
        assertThat(simplePacker.getPackedArticles()).containsExactly(expectedEmptyStandardPackage);
    }

    @Test
    public void should_add_articles_in_package() {
        final SimplePacker simplePacker = new SimplePacker();
        final ArrayList<String> expectedArticles = new ArrayList<>();
        expectedArticles.add("163");

        final List<String> packedArticles = simplePacker.pack("163");

        assertThat(packedArticles).containsExactlyElementsOf(expectedArticles);
    }
}
