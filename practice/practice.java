package practice;

import java.io.IOException;

public class practice {
    public static void main(String[] args) {
        UncheckedException uncheckedException = new UncheckedException();
        System.out.println(uncheckedException instanceof RuntimeException);
    }
}

class UncheckedException extends RuntimeException {

    public UncheckedException() {
    }

}
