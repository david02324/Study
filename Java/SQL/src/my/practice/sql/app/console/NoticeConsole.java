package my.practice.sql.app.console;

import my.practice.sql.app.entity.Notice;
import my.practice.sql.app.service.NoticeService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class NoticeConsole {

    private NoticeService service;
    private int page;
    private String searchField;
    private String searchWord;


    public NoticeConsole() {
        service = new NoticeService();
        page = 1;
        searchField = "";
        searchWord = "";
    }

    public void printNoticeList() throws SQLException {
        List<Notice> list = service.getList(page);
        int count = service.getCount();
        int lastPage = count/10;
        if(count % 10 != 0){
            lastPage++;
        }

        System.out.println("─────────────────────────────────");
        System.out.printf("<공지사항> 총 %d게시글\n",count);
        System.out.println("─────────────────────────────────");
        for(Notice n : list)
        System.out.printf("%d. %s / %s / %s\n",
                n.getId(),n.getTitle(),n.getWriterId(),n.getRegDate());
        System.out.println("─────────────────────────────────");
        System.out.printf("           %d/%d pages\n",page,lastPage);
    }

    public int inputNoticeMenu() {
        Scanner scan = new Scanner(System.in);

        System.out.printf("1. 상세조회/ 2. 이전/ 3. 다음/ 4.글쓰기/ 5.검색/ 6.종료> ");
        String menuString = scan.nextLine();
        int menu = Integer.parseInt(menuString);
        return menu;
    }

    public void movePrevList() {
        if(page==1){
            System.out.println("더이상 갈 수 없음");
            return;
        }
        page--;
    }

    public void moveNextList() throws SQLException {
        int count = service.getCount();
        int lastPage = count/10;
        if(count % 10 != 0){
            lastPage++;
        }
        if(page == lastPage){
            System.out.println("더이상 갈 수 없음");
            return;
        }
        page++;
    }

    public void inputSearchWord() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("검색 범주(title/content/writerId)중에 하나를 입력하세요");
        System.out.println(" > ");
        searchField = scanner.nextLine();

        System.out.println("검색어 > ");
        searchWord = scanner.nextLine();

        int count = service.getCount();
        int lastPage = count/10;
        if(count % 10 != 0){
            lastPage++;
        }

        List<Notice> list = service.getListFromTitle(searchWord);
        printResultNoticeList(list);
    }

    public void printResultNoticeList(List<Notice> resultList) throws SQLException {
        int count = resultList.size();

        System.out.println("─────────────────────────────────");
        System.out.printf("총 %d게시글 검색됨\n",count);
        System.out.println("─────────────────────────────────");
        for(Notice n : resultList)
            System.out.printf("%d. %s / %s / %s\n",
                    n.getId(),n.getTitle(),n.getWriterId(),n.getRegDate());
        System.out.println("─────────────────────────────────");
    }
}
