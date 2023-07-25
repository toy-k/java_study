import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Library {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		boolean exit = false;

		ArrayList<String> bookList = new ArrayList<>();
		HashMap<String, Integer> bookMap = new HashMap<>();

		while (!exit) {

			System.out.println("\n[메뉴] List");
			System.out.println("1. 도서 저장 (도서명)");
			System.out.println("2. 도서 검색 (도서명)");
			System.out.println("3. 도서 삭제 (도서명)");

			System.out.println("[메뉴] Map");
			System.out.println("4. 도서 등록 (도서명, 가격)");
			System.out.println("5. 도서 검색 (도서명)");
			System.out.println("6. 도서 삭제 (도서명)");

			System.out.println("7. 종료");

			System.out.print("메뉴를 선택하세요: ");

			int menu = 0;

			try {
				menu = scanner.nextInt();
				if (menu < 1 || menu > 7) {
					System.out.println("메뉴는 (1~7) 숫자만 입력 가능합니다.");
					scanner.nextLine();
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("메뉴는 (1~7) 숫자만 입력 가능합니다.");
				scanner.nextLine();
				continue;
			}

			switch (menu) {
				case 1:
					addBookList(scanner, bookList);
					break;
				case 2:
					searchBookList(scanner, bookList);
					break;
				case 3:
					deleteBookList(scanner, bookList);
					break;
				case 4:
					addBookMap(scanner, bookMap);
					break;
				case 5:
					searchBookMap(scanner, bookMap);
					break;
				case 6:
					deleteBookMap(scanner, bookMap);
					break;
				case 7:
					exit = isExit();
					break;
			}

			if (exit) {
				break;
			}

		}
		scanner.close();
	}	

	public static void addBookList(Scanner scanner, ArrayList<String> bookList) {
		System.out.print("도서명(저장): ");
		String bookName = scanner.next();
		bookList.add(bookName);
		System.out.println(bookList.get(bookList.indexOf(bookName)) + " 도서가 저장되었습니다.");
	}

	public static void searchBookList(Scanner scanner, ArrayList<String> bookList) {
		System.out.print("도서명(검색): ");
		String bookName = scanner.next();
		if (bookList.contains(bookName)) {
			System.out.println(bookList.get(bookList.indexOf(bookName)) + " 도서가 목록에 있습니다.");
		} else {
			System.out.println(bookName + " 도서가 목록에 없습니다.");
		}
	}

	public static void deleteBookList(Scanner scanner, ArrayList<String> bookList) {
		try{
		System.out.print("도서명(삭제): ");
		String bookName = scanner.next();
		if (bookList.contains(bookName)) {
			bookList.remove(bookName);
			System.out.println(bookName + " 도서가 삭제되었습니다.");
		} else {
			System.out.println(bookName + " 도서가 목록에 없습니다.");
		}
		}catch(Exception e){
			System.out.println("도서 삭제 중 예외가 발생했습니다.");
		}
	}

	public static void addBookMap(Scanner scanner, HashMap<String, Integer> bookMap) {
		System.out.print("도서명(저장): ");
		String bookName = scanner.next();

		Integer bookPrice;
		while(true){
			System.out.print("가격(저장): ");

			try {
				bookPrice = scanner.nextInt();
				isValidNumber(bookPrice);
					break;
			} catch (InputMismatchException e) {
				System.out.println("가격은 (500 ~ 1000000) 숫자만 입력 가능합니다.");
				scanner.nextLine();
				continue;
			}
		}
		bookMap.put(bookName, bookPrice);
		System.out.println(bookName + " 도서가 저장되었습니다. 가격은 " + bookMap.get(bookName) + "원 입니다.");
	}

	public static void isValidNumber(int bookPrice) throws InputMismatchException {
		if (bookPrice < 500 || bookPrice > 1000000) {
			throw new InputMismatchException();
		}
	}

	public static void searchBookMap(Scanner scanner, HashMap<String, Integer> bookMap) {
		System.out.print("도서명(검색): ");
		String bookName = scanner.next();
		if (bookMap.containsKey(bookName)) {
			//키와 밸류를 출력
			System.out.println(bookName + " 도서가 목록에 있습니다. 가격은 " + bookMap.get(bookName) + "원 입니다.");
		} else {
			System.out.println(bookName + " 도서가 목록에 없습니다.");
		}
	}
	
	public static void deleteBookMap(Scanner scanner, HashMap<String, Integer> bookMap) {
		try{
			System.out.print("도서명(삭제): ");
			String bookName = scanner.next();
			if (bookMap.containsKey(bookName)) {
				bookMap.remove(bookName);
				System.out.println(bookName + " 도서가 삭제되었습니다.");
			} else {
				System.out.println(bookName + " 도서가 목록에 없습니다.");
			}
		} catch (Exception e) {
			System.out.println("도서 삭제 중 예외가 발생했습니다.");
		}
	}

	public static boolean isExit() {
		System.out.println("프로그램을 종료합니다.");
		return true;
	}
}