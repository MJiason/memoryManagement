import java.util.List;

public class WsClockPageReplacement implements PageReplacement {
    private int currPage = 0;


    private WsClockPageReplacement() {
    }

    public static WsClockPageReplacement getInstance() {
        return new  WsClockPageReplacement();
    }

    @Override
    public void replacePage(List<VirtualPage> workSet, int maxSize, PhysicalPage physicalPage) {
        if (workSet.size() < maxSize) {
            workSet.add(new VirtualPage(true, physicalPage.getPageNum()));
        }

        for (int i = currPage; i < workSet.size(); i++) {
            VirtualPage page = workSet.get(i);
            if (page.isR()) {
                page.setR(false);
                continue;
            }
            if (!page.isR()) {
                System.out.println("virtual page replaced " + page);
                page = new VirtualPage(true, physicalPage.getPageNum());
                physicalPage.setVirtualTime(System.currentTimeMillis());
                System.out.println("new page " + page);
                return;
            }
            if (currPage == workSet.size() - 1){
                currPage = 0;
            }
        }
    }

    @Override
    public void readPage(List<VirtualPage> workingSet, int pageNum) {
        if (workingSet.isEmpty()) {
            return;
        }
        VirtualPage currPage =  workingSet.get(pageNum);
        System.out.println(currPage);
        currPage.setR(true);
    }
}
