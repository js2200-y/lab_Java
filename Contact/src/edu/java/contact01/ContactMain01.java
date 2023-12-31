package edu.java.contact01;

import java.util.Scanner;

public class ContactMain01 {
	// 상수(constant)
	private static final int MAX_LENGTH = 1; // 연락처 배열의 최대 길이(원소 개수)

	// field
	private Contact[] contacts = new Contact[MAX_LENGTH]; // 연락처를 저장할 배열.
	private int count = 0; // 연락처 배열에 현재까지 저장된 연락처의 개수. 배열에 저장될 때 마다 값을 증가시킴.
	private Scanner scanner = new Scanner(System.in); // 입력도구

	public static void main(String[] args) {
		System.out.println("****** 연락처 프로그램 v0.1 ******");

		ContactMain01 app = new ContactMain01(); // 객체가 생성되고 나면 참조 변수를 통해 메서드 호출
		// -> static이 아닌 메서드들을 사용하기 위해서 참조 변수를 생성.

		boolean run = true;
		while (run) {
			// 메인 메뉴 보여주기
			// 메인 메뉴에서 선택된 값
			int menu = app.showMainMenu();
			switch (menu) {
			case 0: // 프로그램 종료
				run = false;
				break;
			case 1: // 새 연락처 저장
				app.insertNewContact();
				break;
			case 2: // 연락처 전체 목록 보여주기
				app.selectAllContacts();
				break;
			case 3: // 배열의 인덱스로 검색하기
				app.selectContactByIndex();
				break;
			case 4: // 연락처 이름/전화번호/이메일 정보 수정하기
				app.updateContactByIndex();
				break;
			case 5: // 배열의 인덱스로 연락처 삭제하기
				app.deleteContactByIndex();
				break;
			default:
				System.out.println("메뉴 메뉴 번호를 확인하세요...");
			}
		}
		System.out.println("****** 프로그램 종료 ******");
	}

	public void insertNewContact() { // void 리턴안해도됨.
		System.out.println();
		System.out.println("< 1.새 연락처 저장 >");
		if (count == MAX_LENGTH) { // 배열에 저장된 연락처 개수가 배열길이와 같다면
			System.out.println(" 연락처 저장 공간 부족 ㅜㅠ...");
			return; // 메서드 종료 (void메서드에서도 리턴옆에 값만 쓰지 않으면 사용가능)
		}
		System.out.print("이름 입력>>> ");
		String name = scanner.nextLine();
		System.out.print("전화번호 입력>>> ");
		String phone = scanner.nextLine(); // 공백을 포함한 엔터가 입력될때까지 모든 문자열
		System.out.print("이메일 입력>>> ");
		String email = scanner.nextLine();

		// 입력받은 정보들로 Contact 타입의 객체를 생성.
		Contact c = new Contact(0, name, phone, email); // -< 배열에 저장하기 위해서

		// 생성된 Contact 타입의 객체를 배열에 저장.
		contacts[count] = c;
		// 배열에 저장된 원소(연락처) 개수를 1증가.
		count++;
		System.out.println("~~~~~~~~새 연락처 저장 성공~~~~~~~!!!!!");
	}

	public int showMainMenu() {
		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.println("[0]종료 [1]연락처등록 [2]전체목록 [3]검색 [4]수정 [5]삭제");
		System.out.println("------------------------------------------------------------");
		System.out.print("선택>>> ");

		// 콘솔창에서 입력된 문자열 1개 라인을 정수(int)로 변환.
		int result = Integer.parseInt(scanner.nextLine()); // nextLine은 공백포함 한줄 읽기~!

		return result;
	}

	public void selectAllContacts() {
		System.out.println();
		System.out.println("<2.전체목록>");
		for (int i = 0; i < count; i++) {
			contacts[i].printInfo();
		}
	}

	public void selectContactByIndex() {
		System.out.println();
		System.out.println("<3.인덱스 검색>");
		System.out.print("검색할 인덱스 입력>>> ");
		int index = Integer.parseInt(scanner.nextLine());
		
		if (index >= 0 && index < count) {
			contacts[index].printInfo();
		} else {
			System.out.println("해당 인덱스에는 연락처 정보가 없음~!");
		}
	}

	public void updateContactByIndex() {
		System.out.println();
		System.out.println("<4.연락처 수정>");
		System.out.println("수정할 연락처 인덱스 입력>>> ");
		int index = Integer.parseInt(scanner.nextLine());
		
		if(index < 0 || index >= count) {
			System.out.println("해당 인덱스에는 연락처 정보 없음");
			return;
		}
		System.out.print("수정 전: ");
		contacts[index].printInfo(); // 수정 전의 연락처 정보 출력

		System.out.print("수정할 이름 입력 >  ");
		String name = scanner.nextLine();
		System.out.println("수정할 전화번호 입력 >  ");
		String phone = scanner.nextLine();
		System.out.println("수정할 이메일 입력 >  ");
		String email = scanner.nextLine();

		// 수정할 인덱스의 정보를 업데이트
		contacts[index].setName(name);
		contacts[index].setPhone(phone);
		contacts[index].setEmail(email);

//		contacts[index] = new Contact(0, name, phone, email);

		System.out.print("수정 후:  ");
		contacts[index].printInfo();
	}

	public void deleteContactByIndex() {
		System.out.println();
		System.out.println("<5.삭제>");
		System.out.println("삭제할 연락처 인덱스 입력>>> ");
		int index = Integer.parseInt(scanner.nextLine());
		
		if(index < 0 || index >= count) {
			System.out.println("해당 인덱스에는 연락처 정보 없음");
			return;
		}
		
		for (int i = index; i < count - 1; i++) {
			contacts[i] = contacts[i + 1]; // 뒷쪽 연락처 정보를 한칸 앞으로~!
		}
		contacts[count - 1] = null; // 삭제 전 배열의 마지막 원소를 null
		count--; // 배열 원소 개수를 1줄임.

		System.out.println("삭제 완료~!!!  ");

	}
}
