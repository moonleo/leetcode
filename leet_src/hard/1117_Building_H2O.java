import java.util.concurrent.Semaphore;

class H2O {

    Semaphore os = new Semaphore(0);
    Semaphore hs = new Semaphore(2);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hs.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        os.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        os.acquire(2);
        // releaseOxygen.run() outputs "H". Do not change or remove this line.
		    releaseOxygen.run();
        hs.release(2);
    }
}
