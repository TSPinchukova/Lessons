import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        /*File f = new File("1.txt");
        if (!f.exists()){
            f.createNewFile();
        }

        if (f.canWrite()){
            System.out.println("Файл доступен для записи");
        }
        else {
            System.out.println("Файл не доступен для записи");
        }

        if (f.isHidden()){
            System.out.println("Файл скрыт");
        }
        else {
            System.out.println("Файл не скрыт");
        }
        //f.delete();
        System.out.println(f.getAbsolutePath());       //Возвращает абсолютный путь файла
        System.out.println(f.getFreeSpace());

        if(f.isFile()){
            System.out.println("Это файл");
        }

        System.out.println(f.lastModified());   //Возвращает количество милисекунд, прошедших с 01.01.1970
        System.out.print("Размер файла: ");
        System.out.println(f.length());

        File f2 = new File("2.txt");
        f.renameTo(f2);                        // Срабатывает один раз
        if (!f.renameTo(f2)){
            System.out.println("Переименовать не удалось");
        }

        f.setWritable(true);
        f.setLastModified(0);

        File dir = new File("test\\");
        if (!dir.exists()){
            dir.mkdir();
        }

        //dir.setWritable(false);

        File[] files = dir.listFiles();
        for (int i=0;i<files.length;i++){
            files[i].setWritable(false);
        }

        String s = "Hello world!";
        s=s.concat("Hi");
        s="<"+s+">";
        System.out.println(s);

        if (s.indexOf("!")>=0){
            System.out.println("! есть");
        }

        if (s=="<Hello world!Hi>"){
            System.out.println("Строки равны");
        }

        if (s.equals("<Hello world!Hi>")){
            System.out.println("Строки равны");
        }                                                           // С учетом регистра

        if (s.equalsIgnoreCase("<hello world!Hi>")){
            System.out.println("Строки равны");
        }                                                           // Без учета регистра

        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());*/

        String format = String.format("\tMy name is  %s. \nI am %d year old. \nMy height is %.1f cm.", "Tanya", 23, 165.5f);
        System.out.println(format);
    }
}
