import java.util.Scanner;

public class Addition {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		boolean exit = false;
		boolean correct = false;

		while (!exit) {
			correct = false;
			System.out.print("숫자 목록을 입력하세요 (공백으로 구분): ");
			String input = scanner.nextLine();

			String[] numbers = input.split(" ");

			if (numbers.length < 2 || !isValidNumber(numbers)) {
				System.out.println("(-1000000 ~ 1000000) 사이 숫자를 2개 이상 입력해주세요.");
				continue;
			}

			int sum = 0;
			for (String number : numbers) {
				sum += Integer.parseInt(number);
			}

			System.out.println("합계: " + sum);

			while (!correct) {
				System.out.print("종료하시겠습니까? (y/n) ");
				String answer = scanner.next();

				if (answer.equals("y")) {
					exit = true;
					correct = true;
				} else if (answer.equals("n")) {
					correct = true;
				} else {
					System.out.println("잘못 입력하셨습니다.");
				}
			}

      scanner.nextLine(); // 개행 문자 처리
        }

        scanner.close();
    }	
	public static boolean isValidNumber(String[] numbers) {
		int num;
		for (String number : numbers) {
			try {
				num=Integer.parseInt(number);
				if(num < -1000000 || num > 1000000)
					return false;
			} catch (NumberFormatException e) {
				return false;
			}	
		}
		return true;
	}
}