import java.util.Scanner;

public class Multiplication {
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);

		boolean exit = false;
		boolean correct = false;

		while (!exit) {
			correct = false;	
			System.out.print("구구단 첫번째 숫자를 입력해주세요(1~9): ");

			if (!scanner.hasNextInt()) {
				System.out.println("1~9 사이의 숫자를 입력해주세요.");
				scanner.next();
				continue;
			}

			int first = scanner.nextInt();

			if (first < 1 ||first > 9) {
				System.out.println("1~9 사이의 숫자를 입력해주세요.");
				continue;
			}


			for (int i = 1; i < 10; i++) {
				System.out.println(first + " * " + i + " = " + first * i);
			}
						while (!correct) {
				System.out.print("종료하시겠습니까? (y/n) ");
				String answer = scanner.next();

				if (answer.equals("y")) {
					exit = true;
					correct = true;
				}else if(answer.equals("n")) {
					correct = true;
				}else {
					System.out.println("잘못 입력하셨습니다.");
				}
			}
      scanner.nextLine(); // 개행 문자 처리


		}

	scanner.close();


	}
}