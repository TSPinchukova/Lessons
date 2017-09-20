public class Human {
    protected int age;
    public String name;
    public static int eyeCount = 2;
    protected float height;
    public void sleep (int hours){
        System.out.println(name + " is sleeping");
    }
    public void wakeup(){
        System.out.println("Wake Up");
    }
    public void sleep (int hours, int minutes){
        System.out.println("I was sleeping during");
    }
}
