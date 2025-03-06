import java.lang.Runnable;
import java.lang.Thread;

public class Main implements Runnable {
    private String threadname;

    public Main(String name){
        this.threadname = name;
    }

    public static void main(String[] args) {
        Thread[] ta = new Thread[10];
        for (int i =0; i<10; i++) {
            new Thread(new Main("Thread"+i)).start();
                ta[i] = new Thread(new Main("Thread"+i));
        }
        for(int i=0; i<10; i++){
            ta[i].start();
        }
    }

    @Override
    public void run() {
        LazyInitializedSingleton lis = LazyInitializedSingleton.getInstance();
        System.out.printf("Hello world from %s: Code: %d%n ", this.threadname,lis.hashCode());
    }
}
