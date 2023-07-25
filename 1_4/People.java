import java.util.Scanner;

class Person {
	private String name;
	private int age;

	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Person : 이름 = " + this.getName() + ", 나이 = " + this.getAge();
	}

	public void doSomething(){
		System.out.println("사람이 뭔가를 합니다.");
	}
}

interface Worker {
	void work();
}

class Employee extends Person implements Worker {
	private int employeeId;

	public Employee() {
	}

	public Employee(String name, int age, int employeeId) {
		super(name, age);
		this.employeeId = employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	@Override
	public String toString() {
		return "Employee : 이름 = " + this.getName() + ", 나이 = " + this.getAge() + ", 사번 = " + this.getEmployeeId();
	}

	@Override
	public void doSomething() {
		this.work();
	}
	
	@Override
	public void work() {
		System.out.println("직원이 일을 합니다.");
	}

}


public class People {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		boolean exit = false;
		boolean correct = false;
		boolean isValidString = false;

		Person[] people = new Person[2];

		while (!exit) {
			correct = false;

			for(int i=0; i<people.length; i++) {
				System.out.println("[사람 " + (i+1) + " 정보 입력]");

				String name;
				while(true){
					System.out.print("이름: ");
					name = scanner.nextLine();
					for (char c : name.toCharArray()) {
						if (!isValidChar(c)) {
							System.out.println("이름은 한글, 영문 대소문자만 입력 가능합니다.");
							isValidString = false;
							break;
						}
						isValidString = true;
					}
					if (isValidString) {
						isValidString = false;
						break;
					}
				}

				int age;
				while (true) {
					System.out.print("나이: ");
					if (!scanner.hasNextInt()) {
							System.out.println("나이는 15~65 사이의 숫자만 입력 가능합니다.");
						scanner.next();
						continue;
					} else {
						age = scanner.nextInt();
						if (age < 15 || age > 65) {
							System.out.println("나이는 15~65 사이의 숫자만 입력 가능합니다.");
							continue;
						} else {
							break;
						}
					}
				}
				scanner.nextLine(); // 개행 문자 처리
			
				if(i==0){
					people[i] = new Person();
					people[i].setName(name);
					people[i].setAge(age);
				}else{
					int employeeId;
					while (true) {
						System.out.print("사번(1 ~ 1000000): ");
						if (!scanner.hasNextInt()) {
							System.out.println("사번은 (1 ~ 1000000) 숫자만 입력 가능합니다.");
							scanner.next();
							continue;
						} else {
							employeeId = scanner.nextInt();
							if (employeeId < 1 || employeeId > 1000000) {
							System.out.println("사번은 (1 ~ 1000000) 숫자만 입력 가능합니다.");
								continue;
							} else {
								break;
							}
						}
					}
					scanner.nextLine(); // 개행 문자 처리

					people[i] = new Employee(name, age, employeeId);
				}
			}

			for(Person person: people){
				System.out.println(person.toString());
				person.doSomething();
			}
			
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

		public static boolean isValidChar(char c) {
			try{
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '가' && c <= '힣');
			} catch (Exception e) {
				return false;
			}
    }

}