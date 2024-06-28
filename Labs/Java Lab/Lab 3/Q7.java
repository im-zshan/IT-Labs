// Implementation of Factory Methods

public class Q7 {
    private String name;

    private Q7(String name) {
        this.name = name;
    }

    public static Q7 create(String name) {
        return new Q7(name);
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Q7 q7 = Q7.create("Zeeshan");
        System.out.println(q7.getName());
    }
}