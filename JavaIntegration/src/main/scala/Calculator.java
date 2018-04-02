import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calculator {

    public Calculator() {

    }

    public double add(double a, double b) {
        return addAllFromList(Arrays.asList(a, b));
    }

    public double addAllFromList(List<Double> numbers) {
        return numbers.stream().mapToDouble(n -> n.doubleValue()).sum();
    }

    public List<Integer> getPrimenumbers(int n) {
        List<Integer> primenumbers = IntStream.rangeClosed(2, n).boxed().collect(Collectors.toList());
        int index1 = 0;
        int index2 = 1;
        int number1 = 0;
        int number2 = 0;

        while(index1 < (primenumbers.size() - 1)) {
            number1 = primenumbers.get(index1);
            number2 = primenumbers.get(index2);

            if((number2%number1) == 0) {
                primenumbers.remove(index2);
            } else {
                index2++;
            }

            if(index2 >= primenumbers.size()) {
                index1++;
                index2 = index1 + 1;
            }
        }


        return primenumbers;
    }
}
