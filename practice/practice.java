package practice;

public class practice {
    public static void main(String[] args) {
        for (int i = 9; i >= 0 ; i--) {
            System.out.print(i + " ");
        }
    }
}
class Person {
    String name;
    int age;
    
}

class MakingChanges {
    public static void changeIdentities(Person p1, Person p2) {
        // write your code here
        String nameTemp = p1.name;
        p1.name = p2.name;
        p2.name = nameTemp;

        int ageTemp = p1.age;
        p1.age = p2.age;
        p2.age = ageTemp;
    }
}