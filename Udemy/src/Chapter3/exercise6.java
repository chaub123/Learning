package Chapter3;

// Udemy threading class ch3.7 part b
import java.math.BigInteger;

public class exercise6 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new LongComputationTask(new BigInteger("200000"), new BigInteger("10000000000")));

        thread.setDaemon(true);
        thread.start();
        thread.sleep(100);
        thread.interrupt();
    }

    private static class LongComputationTask implements Runnable{
        private BigInteger base;
        private BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power){
            this.base = base;
            this.power = power;
        }

        @Override
        public void run(){
            System.out.println(base+"^"+power+" = " + pow(base, power));
        }

        public BigInteger pow(BigInteger base, BigInteger power){
            BigInteger result = BigInteger.ONE;

            for(BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)){
                result = result.multiply(base);
            }

            return result;
        }
    }
}
