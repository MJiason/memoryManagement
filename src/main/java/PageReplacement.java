import java.util.List;

public interface PageReplacement {
    public void replacePage(List<VirtualPage> list, int maxSize, int pageNum);
    public void readPage (List<VirtualPage> list, int pageNum);
}
