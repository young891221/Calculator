import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

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
    public void 숫자와_연산자가_올바르게_입력되었는가() {
        assertThat(new Input("3 + 4 * 5 =").checkReturnList(), is(Arrays.asList(new String[]{"3", "+", "4", "*", "5"})));
        assertThat(new Input("3 / 6 * 4 =").checkReturnList(), is(Arrays.asList(new String[]{"3", "/", "6", "*", "4"})));
    }

    @Test(expected = NumberFormatException.class)
    public void 숫자와_연산자가_비정상일_경우_에러를_던지는가() {
        assertThat(new Input("3 + 4 * + =").checkReturnList(), is(Arrays.asList(new String[]{"3", "+", "4", "*", "5"})));
        assertThat(new Input("3 + 4 * 5").checkReturnList(), is(Arrays.asList(new String[]{"3", "+", "4", "*", "5"})));
    }

    @Test
    public void 곱하기_나누기_연산이_먼저_되는가() {
        Calculator calculator = new Calculator();
        assertThat(calculator.firstMultiplyAndDivision(new ArrayList<>(Arrays.asList(new String[]{"1", "+", "3", "*", "4"}))), is(13));
        assertThat(calculator.firstMultiplyAndDivision(new ArrayList<>(Arrays.asList(new String[]{"1", "+", "3", "*", "4", "*", "5"}))), is(61));
        assertThat(calculator.firstMultiplyAndDivision(new ArrayList<>(Arrays.asList(new String[]{"1", "+", "3", "*", "4", "*", "5", "-", "3"}))), is(58));
        assertThat(calculator.firstMultiplyAndDivision(new ArrayList<>(Arrays.asList(new String[]{"1", "+", "3", "*", "5", "/", "5", "-", "3"}))), is(1));

    }

    @Test
    public void 괄호부터_먼저_계산되는가() {
        System.out.println(4%2);
    }

}
