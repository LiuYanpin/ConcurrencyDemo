public class CreateThread3 implements Runnable {
    public static void main(String[] args) {
        Thread thread = new Thread(new CreateThread3());
        thread.start();
    }
    @Override
    public void run() {
        System.out.println("Hello, I am Runnable");
    }
}
