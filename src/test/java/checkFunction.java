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

    @Test
    public void 곱하기_나누기_연산이_먼저_되는가() {
        Main main = new Main();
        //assertThat(main.firstMultiplyAndDivision(new String[]{"1", "+", "3", "*", "4"}), is(13));
        //assertThat(main.firstMultiplyAndDivision(new String[]{"1", "+", "3", "*", "4", "*", "5"}), is(61));
        assertThat(main.firstMultiplyAndDivision(new String[]{"1", "+", "3", "*", "4", "*", "5", "-", "3"}), is(58));

    }

    @Test
    public void 숫자와_연산자가_올바르게_입력되었는가() {

    }

}
