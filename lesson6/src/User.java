public class User {
    public int id;
    public String name;
    public float height;

    @Override //Декоратор говорит Java, что меняем функционал класса
    public boolean equals(Object obj) {
        User user2 = (User)obj;
        return this.id == user2.id;
        //super.equals();
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString(){
        return String.format("[%d], Name: %s, Height: %.1f.", id, name, height);
    }


}
