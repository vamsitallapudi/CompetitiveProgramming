public class MultipleThreads {

    static class NewThread implements Runnable {
        Thread t;
        String threadName;

        NewThread(String threadName) {
            this.threadName = threadName;
            t = new Thread(this, threadName);
            System.out.println("New Thread: " + t);
        }

        @Override
        public void run() {
            try {
                for (int i = 5; i > 0; i--) {
                    System.out.println(threadName + ": " + i);
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                System.out.println(threadName + " Interrupted");
            }
            System.out.println(threadName + " Exiting");
        }
    }

    public static void main(String[] args) {
        NewThread nt1 = new NewThread("One");
        NewThread nt2 = new NewThread("Two");
        NewThread nt3 = new NewThread("Three");

        nt1.t.start();
        nt2.t.start();
        nt3.t.start();

        System.out.println("Thread One is alive " + nt1.t.isAlive());
        System.out.println("Thread Two is alive " + nt2.t.isAlive());
        System.out.println("Thread Three is alive " + nt3.t.isAlive());

        // wait for the threads to finish
        try {
            System.out.println("Waiting for threads to finish");
            nt1.t.join();
            nt2.t.join();
            nt3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main Thread interrupted");
        }
        System.out.println("Thread One is alive " + nt1.t.isAlive());
        System.out.println("Thread Two is alive " + nt2.t.isAlive());
        System.out.println("Thread Three is alive " + nt3.t.isAlive());
    }
}
