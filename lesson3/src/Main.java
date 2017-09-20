public class Main {
    public static void main(String[] args) {
        Human h = new Human();
        h.name = "Vasya";
        h.sleep(12);

        Human.eyeCount=3;
        System.out.println(Human.eyeCount);

        Human h2 = h;
        h2.name = "Kolyan";
        System.out.println(h.name);
        System.out.println(h2.name);

        Woman w = new Woman();
        w.name = "Katya";
        w.cook();

        Man m = new Man("Kolya");
        m.cook();
    }

    static int add(int a, int b){
        int c=a+b;
        return c;
    }

    int a=5;
    int b=6;
    static int min(int a, int b){
        if(a<b){
            System.out.println("min");
            return a;
        }
        else{
            System.out.println("min");
            return b;
        }
    }

}
