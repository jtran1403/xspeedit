package xspeedit;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class RobotTest {
    @Test
    public void should_print_packages()
    {
        final Robot robot = new Robot(null);

        final String printedArticles = robot.print(Arrays.asList("451", "62"));

        assertThat(printedArticles).isEqualTo("451/62");
    }

    @Test
    public void should_pack_articles() {
        final Packer mockedPacker = mock(Packer.class);
        final Robot robot = new Robot(mockedPacker);

        robot.packArticles("163841689525773");

        verify(mockedPacker, times(1)).pack("163841689525773");
    }
}
