package my.practice.sql.app.console;

import java.sql.SQLException;

public class Program5 {
    public static void main(String args[]) throws SQLException {
        NoticeConsole console = new NoticeConsole();

        EXIT:
        while(true){
        console.printNoticeList();
        int menu = console.inputNoticeMenu();

        switch (menu){
            case 1: // 상세조회
                break;
            case 2: // 이전
                break;
            case 3: // 다음
                break;
            case 4: // 글쓰기
                break;
            case 5: // 종료
                System.out.println("Bye~~");
                break EXIT;
            default:
                System.out.println("1~5번까지만 입력해주세요");
                break;
            }
        }
    }
}
