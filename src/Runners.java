public class Runners {
    public static void main(String[] args) {
        Runner1 runner1 = new Runner1();
        Runner2 runner2 = new Runner2();

        Thread thread1 = new Thread(runner1);
        Thread thread2 = new Thread(runner2);

        //thread1.setPriority(1);
        //thread2.setPriority(1);

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread1.interrupt();
        thread2.interrupt();
    }
}

//бегун
class Runner1 implements Runnable {

    @Override
    public void run() {
        long begin = System.currentTimeMillis();
        long end = begin + 300;
        //for (int i=0; i<5; i++){
        //while (System.currentTimeMillis() < end) {
        while (true){
            System.out.println("Runner 1 is running");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}


class Runner2 implements Runnable{

    @Override
    public void run(){
        //for (int i=0; i<5; i++){
        while (true){
            System.out.println("Runner 2 is running");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
