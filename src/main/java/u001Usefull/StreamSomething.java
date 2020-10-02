package u001Usefull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSomething {

    public static void main(String[] args) {
        List<String> testList = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
                .peek(var -> System.out.println(var))
                .filter(var -> false)
                .collect(Collectors.toList());
        System.out.println(testList.size());
    }
}
