import java.util.List;

public interface PageReplacement {
    public void replacePage(List<VirtualPage> list, int maxSize, PhysicalPage pageNum);
    public void readPage (List<VirtualPage> list, int pageNum);
}
