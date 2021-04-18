package hust.soict.hedspi.aims.media;

public class MemoryDaemon implements Runnable{
    long memoryUsed = 0;
    @Override
    public void run() {
        Runtime rt = Runtime.getRuntime();
        long used;
        while(true){
            used = rt.totalMemory() - rt.freeMemory();
            if(used != memoryUsed){
                System.out.println("Memory used = " + used);
                memoryUsed = used;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
