import java.util.Scanner;

public class Bank {
    public static void main(String[] args){
        boolean run = true;

        int balance = 0;

        Scanner scanner = new Scanner(System.in);

        while(run){
            System.out.println("-----------------------------------");
            System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
            System.out.println("-----------------------------------");
            int userSelection = scanner.nextInt();
            if(userSelection == 1){
                System.out.println("금액을 입력하세요 : ");

                int money = scanner.nextInt();
                balance += money;

                System.out.println("완료되었습니다. 현재 잔고 " + balance + "원");
            } else if(userSelection == 2){
                System.out.println("금액을 입력하세요 : ");

                int money = scanner.nextInt();
                if(balance >= money) {
                    balance -= money;
                    System.out.println("완료되었습니다. 현재 잔고 " + balance + "원");
                } else {
                    System.out.println("잔액이 부족합니다. 현재 잔고 " + balance + "원");
                }
            } else if(userSelection == 3){
                System.out.println("현재 잔고 " + balance + "원");
            } else if(userSelection == 4){
                run = false;
            } else{
                System.out.println("제대로 입력해주세요.");
            }
        }
    }
}
