package ex0213.assignment;
import java.io.*;
import java.util.Scanner;

public class UserProfileManagement {
	private static final String DIRECTORY_PATH = "src/ex0213/assignment/";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n1. 프로필 저장\t2. 프로필 불러오기\t3. 종료");
            System.out.print("선택> ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    saveProfile();
                    break;
                case "2":
                    loadProfile();
                    break;
                case "3":
                    running = false;
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    private static void saveProfile() {
        System.out.print("이름> ");
        String name = scanner.nextLine();

        System.out.print("몸무게> ");
        String weight = scanner.nextLine();

        System.out.print("비밀번호> ");
        String password = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DIRECTORY_PATH + name + ".txt"))) {
            writer.write(weight + ":" + password);
            System.out.println(name + "님의 프로필을 저장했습니다.");
        } catch (IOException e) {
            System.out.println("프로필 저장 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    private static void loadProfile() {
        System.out.print("이름> ");
        String name = scanner.nextLine();

        File file = new File(DIRECTORY_PATH + name + ".txt");
        if (!file.exists()) {
            System.out.println(name + "님의 프로필을 찾을 수 없습니다.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String[] profile = reader.readLine().split(":");
            if (profile.length == 2) {
                System.out.println(name + "님 몸무게는 " + profile[0] + "kg 이고 비번은 " + profile[1] + " 입니다.");
            }
        } catch (IOException e) {
            System.out.println("프로필 불러오기 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}
