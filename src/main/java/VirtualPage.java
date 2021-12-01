import java.util.ArrayList;
import java.util.List;

public class VirtualPage {
    private boolean P;
    private boolean R;
    private boolean M;
    private int physicalPageNum;


    public VirtualPage(boolean r, int physicalPageNum) {
        R = r;
        this.physicalPageNum = physicalPageNum;
    }

    public static List<VirtualPage> initWorkingSet(int size) {
        List<VirtualPage> virtualPages = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            virtualPages.add(new VirtualPage(true, i));
        }
        return virtualPages;
    }

    public boolean isP() {
        return P;
    }

    public void setP(boolean p) {
        P = p;
    }

    public boolean isR() {
        return R;
    }

    public void setR(boolean r) {
        R = r;
    }

    public boolean isM() {
        return M;
    }

    public void setM(boolean m) {
        M = m;
    }

    @Override
    public String toString() {
        return "VirtualPage{" +
                "P=" + P +
                ", R=" + R +
                ", physicalPageNum=" + physicalPageNum +
                '}';
    }
}
