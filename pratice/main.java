package pratice;

import java.util.*;

public class main {

    public static void main(String... args) {
        // initialize an instance of Holder to make the code below compiled

        List<Integer> list = new ArrayList<>();

    }

}

class Holder<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}