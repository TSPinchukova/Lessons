import sun.java2d.pipe.SpanShapeRenderer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
    public static int k = 0;
    synchronized public static void doSome(int d){
        k+=d;
    }
    public static void main(String[] args) throws InterruptedException {
        /*double d = Math.sin(3.14);
        System.out.println(d);
        double s = Math.sqrt(16);
        System.out.println(s);
        double p = Math.pow(2,10);
        System.out.println(p);
        double min = Math.min(2,10);
        System.out.println("min = "+ min);
        double max = Math.max(2,10);
        System.out.println("min = "+max);
        double r = Math.rint(2.15);
        System.out.println(r);*/

        /*long t = System.currentTimeMillis();
        for (int i=0; i<10000000; i++){
            double d = Math.sin(i)*Math.tan(i*2)-Math.sqrt(i/2);
        }
        MyThread mt = new MyThread();
        MyThread2 mt2 = new MyThread2();
        mt.start(); //Метод start запускает поток на выполнение
        mt2.start();
        mt.join();
        mt2.join();
        long dt = System.currentTimeMillis()-t;
        System.out.println(dt);   //8479*/

        /*Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<1000000; i++) {
                    doSome(1);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<1000000; i++){
                    doSome(-1);
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(k);*/

        Date d = new Date();
        System.out.println(d);
        System.out.println(d.getTime());
        d.setTime(2000000000);
        System.out.println(d);

        Date d2 = new Date();
        if(d2.before(d)){
            System.out.println("d2<d");
        }
        else {
            System.out.println("d<=d2");
        }

        SimpleDateFormat format = new SimpleDateFormat("'Сегодня 'EEE hh:mm:ss dd.MM.yyyy");//dd-междун. стандарт, чтобы вывести день
        System.out.println(format.format(d));

        Calendar c = Calendar.getInstance();
        System.out.println(c.getTime());
        c.add(Calendar.MONTH,2); //прибавляет 2 месяца
        System.out.println(c.getTime());
        c.add(Calendar.MONTH,-2);
        System.out.println(c.getTime());
        c.set(Calendar.MONTH,9);  //нумерация месяцев начинается с 0 в JAVA
        System.out.println(c.getTime());
        c.set(Calendar.DAY_OF_WEEK,12);
        System.out.println(c.getTime());

        int year = c.get(Calendar.YEAR);
        System.out.println(year);

        GregorianCalendar gc = new GregorianCalendar();
        gc.set(Calendar.YEAR, 2000);
        if(gc.isLeapYear(2000)){
            System.out.println("Год високосный");
        }
        else {
            System.out.println("Год невисокосный");
        }


    }
}
