package xspeedit;


import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RobotTest {
    @Test
    public void should_print_packages()
    {
        final Robot robot = new Robot();

        final String printedArticles = robot.print(Arrays.asList("451", "62"));

        assertThat(printedArticles).isEqualTo("451/62");
    }
}
