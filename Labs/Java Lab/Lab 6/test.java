interface Wild {
    void hey();
}

class cow implements Wild {
    public void hey() {
        System.out.println("Cow is eating");
    }
}
class goat implements Wild{
    public void hey() {
        System.out.println("goat grazing");
    }
}
public class test  {
    public static void main(String[] args) {
        Wild obj1 = new cow();
        Wild obj2 = new goat();
        obj1.hey();
        obj2.hey();
    }
}

