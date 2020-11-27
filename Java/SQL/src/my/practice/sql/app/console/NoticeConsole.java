package my.practice.sql.app.console;

import my.practice.sql.app.entity.Notice;
import my.practice.sql.app.service.NoticeService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class NoticeConsole {

    private NoticeService service;

    public NoticeConsole() {
        service = new NoticeService();
    }

    public void printNoticeList() throws SQLException {
        List<Notice> list = service.getList(1);

        System.out.println("─────────────────────────────────");
        System.out.printf("<공지사항> 총 %d게시글\n",10);
        System.out.println("─────────────────────────────────");
        for(Notice n : list)
        System.out.printf("%d. %s / %s / %s\n",
                n.getId(),n.getTitle(),n.getWriterId(),n.getRegDate());
        System.out.println("─────────────────────────────────");
        System.out.printf("           %d/%d pages\n",1,2);
    }

    public int inputNoticeMenu() {
        Scanner scan = new Scanner(System.in);

        System.out.printf("1. 상세조회/ 2. 이전/ 3. 다음/ 4.글쓰기/ 5.종료> ");
        String menuString = scan.nextLine();
        int menu = Integer.parseInt(menuString);
        return menu;
    }
}
