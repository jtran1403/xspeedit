package xspeedit;

import org.junit.Test;
import xspeedit.domain.StandardPackage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StandardPackerTest {
    @Test
    public void should_be_initialized_with_an_empty_standard_package() {
        final StandardPacker standardPacker = new StandardPacker();

        final StandardPackage expectedEmptyStandardPackage = new StandardPackage();

        assertThat(standardPacker.getPackedArticles()).containsExactly(expectedEmptyStandardPackage);
    }

    @Test
    public void should_transform_article_list_into_list_of_articles_size() {
        final StandardPacker standardPacker = new StandardPacker();

        final List<Integer> articlesBySize = standardPacker.getArticlesBySize("1234");

        assertThat(articlesBySize).containsExactly(1,2,3,4);
    }
}
