import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    /*public static void writeUserToFile(User[] users,String filename) throws IOException {
        FileOutputStream fos = new FileOutputStream (filename); //создает поток для записи в файл
        ObjectOutputStream oos = new ObjectOutputStream(fos);   //создает поток для записи объукта из опер.памяти
        for (int i = 0; i < users.length; i++){
            oos.writeObject(users[i]);
        }
        oos.close();  //чтобы не было ситуации "файл уже используется"
        fos.close();
    }

    public static void showUsers(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        while (true){
            Object obj = null;
            try{
                obj = ois.readObject();
            }catch (Exception e){
                break;
            }
            User u = (User) obj; //явное преобразование переменной obj в тип User
            System.out.print(u.id);
            System.out.println(" " + u.name);
        }
        ois.close();
        fis.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*User u = new User();
        u.id = 100;
        u.name = "User100";

        User u2 = new User();
        u2.id = 200;
        u2.name = "User200";

        User[] users = {u, u2};
        //writeUserToFile(users,"users.txt");
        //showUsers("users.txt");

        String s = String.valueOf(true);
        System.out.println(s);

        float f = Float.parseFloat("12.3f");
        System.out.println(f*2);

    }*/

    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(0,10);
        list.add(13);
        list.add(13);
        System.out.println(list);

        list.remove(1);   //удаляет по индексу
        Integer k = 13;
        list.remove(k);
        System.out.println(list);
        System.out.println(list.get(1));   //возвращает элемент под индексом 1

        int size = list.size();
        System.out.println("Size = " +size);  //возвращает размер коллекции

        for (Integer i: list){
            System.out.println(i*i);
        }

        HashSet<String> set = new HashSet<String>();
        set.add("Hello");
        set.add("World");
        set.add("Hello");
        System.out.println(set);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("Ivanov", 123456);
        map.put("Petrov", 789101);
        map.put("Ivanov", 112131);
        System.out.println(map);

        System.out.println(map.get("Ivanov"));
        map.remove("Petrov");
        System.out.println(map);

    }

}
