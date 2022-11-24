package pratice;

public class main {
    public static void main(String[] args) {
        System.out.println("hello");
        ;
    }
}
class Animal {

    public void say() {
        System.out.println("...An incomprehensible sound...");
    }
}

class Cat extends Animal {
    public void say() {
        System.out.println("meow-meow");
    }
}

class Dog extends Animal {
    public void say() {
        System.out.println("arf-arf");
    }
}

class Duck extends Animal {
    public void say() {
        System.out.println("quack-quack");
    }
}