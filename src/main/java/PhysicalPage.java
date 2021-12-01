import java.util.ArrayList;
import java.util.List;

public class PhysicalPage {
    private int pageNum;
    private boolean isEmpty;
    private long virtualTime;

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

    public long getVirtualTime() {
        return virtualTime;
    }

    public void setVirtualTime(long virtualTime) {
        this.virtualTime = virtualTime;
    }

    public int getPageNum() {
        return pageNum;
    }
}
