package common;

import java.util.Scanner;

import controller.DetailController;
import controller.ListController;
import controller.WriteController;

public class FrontController {
    public static void main(String[] args) {
        new FrontController().process();
    }

    public void process() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("\n1. 글작성 | 2. 목록조회 | 3. 글상세조회 | 0. 종료");
            System.out.print("메뉴 선택: ");
            int menu = Integer.parseInt(sc.nextLine());
            Controller controller = null;

            switch(menu) {
                case 1: controller = new WriteController(); break;
                case 2: controller = new ListController(); break;
                case 3: controller = new DetailController(); break;
                case 0: System.out.println("프로그램을 종료합니다!"); System.exit(0);
                default: System.out.println("유효한 숫자를 입력해 주세요!"); continue;
            }

            if(controller != null) {
                controller.execute(sc);
            }
        }
    }
}
