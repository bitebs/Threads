public class ThreadDemo extends Thread {
    public static void main(String[] args) {
        System.out.println("Thread: "+Thread.currentThread().getName());

        System.out.println("Creating thread");
        Thread thread = new ThreadDemo();

        System.out.println("Starting thread");
        thread.start();

        System.out.println("Creating thread");
        Thread thread2 = new ThreadDemo();

        System.out.println("Starting thread");
        thread2.start();
        try {
            thread.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " is finished");
    }

    @Override
    public void run(){
        for (int i=0; i<3; i++)
            System.out.println(Thread.currentThread().getName()+ " is running");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+ " is finished");
    }

}
