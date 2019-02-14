package xspeedit;

import org.junit.Test;
import xspeedit.domain.StandardPackage;

import static org.assertj.core.api.Assertions.assertThat;

public class SmarterPackerTest {

    @Test
    public void should_be_initialized_with_an_empty_standard_package() {
        final SmarterPacker smarterPacker = new SmarterPacker();

        final StandardPackage expectedEmptyStandardPackage = new StandardPackage();

        assertThat(smarterPacker.getPackedArticles()).containsExactly(expectedEmptyStandardPackage);
    }

}
