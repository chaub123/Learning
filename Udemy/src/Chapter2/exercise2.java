package Chapter2;

// Udemy threading class ch2.5
public class exercise2 {
    public static void main(String[] args) {
        Thread thread = new newThread();
        thread.setName("Testing 1");
        thread.start();
    }

    public static class newThread extends Thread{
        @Override
        public void run(){
            System.out.println("Hello from " + this.getName());
        }
    }
}
