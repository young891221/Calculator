import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import enums.Operator;

public class Input {
    private Scanner scanner;

    public Input(Object value) {
        if(value instanceof InputStream) scanner = new Scanner((InputStream) value);
        else if(value instanceof String) scanner = new Scanner((String) value);
    }

    public List checkReturnList() {
        List<String> result = new ArrayList<>();
        int i = 0, check = 1;

        while(scanner.hasNext()) {
            String target = scanner.next();
            if("=".equals(target)) break;
            result.add(target);

            check = checkInputType(result, i, check);
            i++;
        }

        return result;
    }

    private int checkInputType(List<String> result, int i, int check) {
        boolean isEven = check++ % 2 == 0;

        if(isEven) {
            int finalI = i;
            Arrays.stream(Operator.values()).filter(o -> o.matchOperator(result.get(finalI))).findAny().orElseThrow(NumberFormatException::new);
        }
        else if(!isEven) {
            try {
                Integer.parseInt(result.get(i));
            } catch (NumberFormatException e) {
                throw new NumberFormatException();
            }
        }
        return check;
    }
}
