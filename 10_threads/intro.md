Threads in Java :

A thread is a lightweight process. It allows multiple tasks to run concurrently.


--------------------------------------------------------------
Main Thread (Default Single Thread)
--------------------------------------------------------------

By default, every Java program runs on a single thread called the "main thread".
JVM creates this main thread automatically when the program starts.

class Demo
{
    public static void main(String[] args)
    {
        System.out.println("Thread name : " + Thread.currentThread().getName());
        // Output : Thread name : main

        System.out.println("Running on main thread...");
    }
}

Everything runs sequentially on this single main thread unless we create new threads.


--------------------------------------------------------------
Multiple Threads : by extending Thread class
--------------------------------------------------------------

- Create a class that extends Thread.
- Override the run() method — this is what the thread will execute.
- Call start() to begin the thread (do NOT call run() directly).
- start() is defined to call run() internally

class MyThread extends Thread
{
    public void run()
    {
        System.out.println("Thread name : " + Thread.currentThread().getName());
        System.out.println("MyThread is running...");
    }
}

class Demo
{
    public static void main(String[] args)
    {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start();   // starts thread 1
        t2.start();   // starts thread 2

        System.out.println("Main thread : " + Thread.currentThread().getName());
    }
}

// Output order is NOT guaranteed, threads run concurrently.


--------------------------------------------------------------
Multiple Threads : by implementing Runnable interface
--------------------------------------------------------------

- Preferred approach over extending Thread.
- Implement the Runnable interface and override run().
- Pass the Runnable object to a Thread object, then call start().

- Why prefer Runnable?
  Because Java does not support multiple inheritance.
  If your class already extends another class, you can't extend Thread.
  But you can always implement Runnable.

class MyRunnable implements Runnable
{
    public void run()
    {
        System.out.println("Thread name : " + Thread.currentThread().getName());
        System.out.println("MyRunnable is running...");
    }
}

class Demo
{
    public static void main(String[] args)
    {
        MyRunnable r = new MyRunnable();

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();

        System.out.println("Main thread : " + Thread.currentThread().getName());
    }
}


--------------------------------------------------------------
Thread Lifecycle
--------------------------------------------------------------

NEW       ->  Thread object created, not started yet.
RUNNABLE  ->  start() called, ready to run.
RUNNING   ->  Thread is executing run().
WAITING   ->  Thread waiting for another thread (e.g. join(), sleep()).
TERMINATED -> run() completed.


--------------------------------------------------------------
Useful Thread Methods
--------------------------------------------------------------

Thread.currentThread().getName()   // get current thread name
t1.setName("MyThread-1")           // set thread name
t1.sleep(1000)                     // pause thread for 1000ms (1 sec)
t1.join()                          // wait for t1 to finish before continuing
t1.getPriority()                   // get thread priority (1 to 10, default 5)
t1.setPriority(10)                 // set thread priority


--------------------------------------------------------------
Quick Comparison : Thread vs Runnable
--------------------------------------------------------------

| Feature                  | extends Thread      | implements Runnable  |
|--------------------------|---------------------|----------------------|
| Multiple inheritance     | NOT possible        | Possible             |
| Code reusability         | Low                 | High                 |
| Preferred approach       | NO                  | YES                  |
| How to start             | t1.start()          | new Thread(r).start()|

