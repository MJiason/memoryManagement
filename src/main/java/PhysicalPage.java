import java.util.ArrayList;
import java.util.List;

public class PhysicalPage {
    int pageNum;
    boolean isEmpty;

    private PhysicalPage(int pageNum) {
        this.pageNum = pageNum;
        isEmpty = true;
    }

    public static List <PhysicalPage> createPageTable(int size) {
        List<PhysicalPage> pageTable = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            pageTable.add(new PhysicalPage(i));
        }
        return pageTable;
    }
}
