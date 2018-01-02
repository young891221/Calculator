import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class checkFunction {

    @Test
    public void 기능이_올바르게_존재_하는가() {
        assertThat(Operator.PLUS, is("+"));
        assertThat(Operator.MINUS, is("-"));
        assertThat(Operator.MULTIPLY, is("*"));
        assertThat(Operator.DIVISION, is("/"));
    }

}
