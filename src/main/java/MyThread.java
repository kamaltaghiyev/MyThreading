public class MyThread implements Runnable{
    String line;
    int id;

    public MyThread(String line, int id) {
        this.line = line;
        this.id = id;
    }

    public void run(){
        System.out.println("The Thread is alive and running... ");
        if (line == null || line.isEmpty()) {
            System.out.println("0");
        }

        String[] words = line.split("\\s+");
        System.out.println(words.length);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("I am going to die, good bye!!");
    }
}
