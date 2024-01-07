package Chapter2;

// Udemy threading class ch2.4


public class exercise1 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("We are now in thread " + Thread.currentThread().getName());
                System.out.println("Current thread priority is " + Thread.currentThread().getPriority());
                throw new RuntimeException("Intentional Exception");
            }
        });

        thread.setName("New worker thread");

        thread.setPriority(Thread.MAX_PRIORITY);

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error hanppened in thread " + t.getName()
                        + " the error is " + e.getMessage());
            }
        });

        System.out.println("we are in Thread: " + Thread.currentThread().getName() + " before starting a new thread.");
        thread.start();
        System.out.println("we are in Thread: " + Thread.currentThread().getName() + " after starting a new thread.");

//        Thread.sleep(10000);
    }
}
