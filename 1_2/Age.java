import java.util.Scanner;

public class Age {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		boolean exit = false;
		boolean correct = false;
		while (!exit) {
			correct = false;	

			System.out.print("만 나이를 입력해주세요: ");

			int age;
			if(!scanner.hasNextInt()) {
				System.out.println("나이는 0~200 사이의 숫자만 입력 가능합니다.");
				scanner.next();
				continue;
			} else {
				age = scanner.nextInt();
				if(age < 0 || age > 200) {
					System.out.println("나이는 0~200 사이의 숫자만 입력 가능합니다.");
					continue;
				}
			}
		
			if (age >= 19) {
				System.out.println("성인 입니다.");
			} else {
				System.out.println("미성년자 입니다");
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