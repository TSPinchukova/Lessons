import java.io.*;

public class Main {
    public static void goToWork(IWorker employee){
        employee.goToWork();
    }

    public static void pay(IWorker employee){
        employee.pay();
    }
    public static void main(String[] args) throws IOException {
        /*User u = new User();
        u.toString();
        System.out.println(u.toString());

        User u = new User();
        u.id = 10;
        User u2 = new User();
        u2.id = 10;
        if (u.equals(u2)){
            System.out.println("Equals");
        }

        System.out.println(u.hashCode());
        System.out.println(u2.hashCode());

        u.name = "Vasya";
        u.height = 170.5f;
        System.out.println(u);//=System.out.println(u.toString());
        //System.out.println(u.toString());*/

        // Интерфейсы


        Worker w = new Worker();
        Cleaner c = new Cleaner();
        Boss b = new Boss();

        w.goToWork();
        w.pay();
        goToWork(w);
        goToWork(c);
        goToWork(b);
        pay(c);

        File f = new File("1.txt");                                 //Читать файл
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String content = "";

        while (true){    //бесконечный цикл
            String s= br.readLine();
            if (s == null){
                break;
            }
            content += s+"\n";     //После завершения цикла содержимое цикла в переменную content
        }
        content += "Hi";

        PrintWriter writer = new PrintWriter("1.txt","UTF-8");    //Записать в файл
        writer.println(content);
        //writer.append("Hello World!");
        //writer.println(5476);
        writer.close();


    }

}
