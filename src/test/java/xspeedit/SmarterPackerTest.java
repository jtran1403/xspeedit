package xspeedit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SmarterPackerTest {

    @Test
    public void should_add_articles_in_package() {
        final SmarterPacker smarterPacker = new SmarterPacker();
        final ArrayList<String> expectedArticles = new ArrayList<>();
        expectedArticles.add("163");

        final List<String> packedArticles = smarterPacker.pack("163");

        assertThat(packedArticles).containsExactlyElementsOf(expectedArticles);
    }

}
