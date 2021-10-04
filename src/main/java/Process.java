import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Process extends Thread {


    private volatile boolean executeAllowed;
    private int virtualMemory;
    private final int CALL_TO_WORKING_SET_PROBABILITY = 90;
    private final Random random = new Random();
    private List<VirtualPage> workingSet = new ArrayList<>(virtualMemory);
    private final PageReplacement pageReplacement = WsClockPageReplacement.getInstance();
    private List<PhysicalPage> physicalPages;


    public Process(String name, int sizeOfMemory, List<PhysicalPage> physicalPages) {
        super(name);
        this.virtualMemory = sizeOfMemory;
        this.physicalPages = physicalPages;
        System.out.println("---------------------");
        System.out.println(name + " process was created! Required memory size = " + sizeOfMemory);
        if (workingSet.isEmpty()){
            workingSet = VirtualPage.initWorkingSet(10);
        }
        start();
    }

    private void getVirtualPage(List<VirtualPage> workingSet, List<PhysicalPage> pageTable) {
        if (ThreadLocalRandom.current().nextInt(100) < CALL_TO_WORKING_SET_PROBABILITY) {
            pageReplacement.readPage(workingSet, ThreadLocalRandom.current().nextInt(workingSet.size()));
        } else {
            System.out.println("Page from table, replacing");
            pageReplacement.replacePage(workingSet, virtualMemory, ThreadLocalRandom.current().nextInt(pageTable.size()));
        }
        return;
    }

    public void run() {

        while (true) {

            if (executeAllowed) {
                try {
                    sleep(2);
                    getVirtualPage(workingSet, physicalPages);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public void setExecuteAllowed(boolean executeAllowed) {
        this.executeAllowed = executeAllowed;
    }
}
