public class UnsynchronizedEg {
    public static void main(String[] args) {
        CallMe callMe = new CallMe();
        Caller caller1 = new Caller(callMe, "Hello");
        Caller caller2 = new Caller(callMe, "Synchronized");
        Caller caller3 = new Caller(callMe, "World");

        caller1.t.start();
        caller2.t.start();
        caller3.t.start();

        try {
            caller1.t.join();
            caller2.t.join();
            caller3.t.join();
        } catch (Exception e) {
            System.out.println("interrupted");
        }
    }
}

class CallMe {
    void call(String msg) {
        System.out.println("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread Interrupted");
        }
        System.out.println("]");
    }
}

class Caller implements Runnable {
    String msg;
    CallMe target;
    Thread t;

    Caller(CallMe target, String s) {
        this.target = target;
        msg = s;
        t = new Thread(this);
    }

    @Override
    public void run() {
        target.call(msg);
    }
}