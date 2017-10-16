import java.util.Scanner;

public class Deposit {
    private float balance=0;
    private int pinCode;
    public void setPinCode(int pinCode){
        this.pinCode = pinCode;
    }
    public void add(float sum){
        balance+=sum;
    }
    public void getMoney(float sum) throws MyExeption {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите пин");
        int pin = sc.nextInt();
        if(pin!=pinCode){
            throw new MyExeption();
        }
        balance-=sum;
    }
    public void printMyBalance(){
        System.out.print("Ваш баланс составляет ");
        System.out.println(balance);

    }
}
