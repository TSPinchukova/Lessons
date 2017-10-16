public class Cleaner implements IWorker {
    @Override
    public void goToWork() {
        System.out.println("Cleaner приехал на работу в 6.00");
    }

    @Override
    public void pay() {
        System.out.println("Cleaner получил 300 BYN");
    }
}
