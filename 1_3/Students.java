import java.util.Scanner;

class Student {
    private String name;
		private int studentId;
		private String department;

    public Student() {
    }

    public Student(String name, int studentId, String department) {
        this.name = name;
				this.studentId = studentId;
				this.department = department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

		public void setDepartment(String department) {
			this.department = department;
		}
		
		public String getDepartment() {
			return department;
		}

    @Override
    public String toString() {
        return "Student : 이름 = " + this.getName() + ", 학번 = " + this.getStudentId() + ", 학과 = " + this.getDepartment() ;
    }
}

public class Students {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		boolean exit = false;
		boolean correct = false;
		boolean isValidString = false;

		Student[] students = new Student[2];

		while (!exit) {
			correct = false;
			for (int i = 0; i < students.length; i++) {
				System.out.println("[학생 " + (i + 1) + " 정보 입력]");

				String name;

				while (true) {
					System.out.print("이름: ");
					name = scanner.nextLine();
					for (char c : name.toCharArray()) {
						if (!isValidChar(c)) {
							System.out.println("이름은 한글, 영문만 입력 가능합니다.");
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

				int studentId;
				while (true) {
					System.out.print("학번: ");
					if (!scanner.hasNextInt()) {
							System.out.println("학번은 (1 ~ 10000000) 숫자만 입력 가능합니다.");
						scanner.next();
						continue;
					} else {
						studentId = scanner.nextInt();
						if (studentId < 1 || studentId > 10000000) {
							System.out.println("학번은 (1 ~ 10000000) 숫자만 입력 가능합니다.");
							continue;
						} else {
							break;
						}
					}
				}
				scanner.nextLine(); // 개행 문자 처리

				String department;
				while (true) {
					System.out.print("학과: ");
					department = scanner.nextLine();
					for (char c : department.toCharArray()) {
						if (!isValidChar(c)) {
							System.out.println("학과는 한글, 영문만 입력 가능합니다.");
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


				if (i == 0) {
					students[i] = new Student();
					students[i].setName(name);
					students[i].setStudentId(studentId);
					students[i].setDepartment(department);
				} else {
					students[i] = new Student(name, studentId, department);
				}
			}

			for (Student student : students) {
				System.out.println(student);
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