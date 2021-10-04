import java.util.ArrayList;
import java.util.List;

public class Main extends Thread{
    public static void main(String[] args) {

        List<PhysicalPage> pagesTable = PhysicalPage.createPageTable(200);
        String[] names = {"T1", "T2", "T3", "T4"};
        int[] vmSize = {50,250,50,105} ;
        List<Process> list = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            Process process = new Process(names[i], vmSize[i], pagesTable);
            list.add(process);

        }

        while (true) {
            int index = (int) Math.round(Math.random() * (names.length - 1));
            System.out.println("\n---> MAIN: execute allowed to " + names[index]+"----------------------------\n");
            list.get(index).setExecuteAllowed(true);

            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            list.get(index).setExecuteAllowed(false);
        }
    }
}

