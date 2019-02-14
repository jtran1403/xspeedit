package xspeedit;

import org.junit.Test;
import xspeedit.domain.StandardPackage;

import static org.assertj.core.api.Assertions.assertThat;

public class StandardPackerTest {
    @Test
    public void should_be_initialized_with_an_empty_standard_package() {
        final StandardPacker standardPacker = new StandardPacker();

        final StandardPackage expectedEmptyStandardPackage = new StandardPackage();

        assertThat(standardPacker.getPackedArticles()).containsExactly(expectedEmptyStandardPackage);
    }
}
