package kr.s23.object.bank;

public class BankAccount {
	//멤버 변수
	protected String number;
	protected String password;
	protected String name;
	protected long balance;
	
	//생성자
	public BankAccount(String number, String password, String name,
			                                   long balance) {
		this.number = number;
		this.password = password;
		this.name = name;
		this.balance = balance;
		System.out.println("계좌가 개설되었습니다.");
	}

	//입금 하기
	public void deposit(long amount) {
		if(amount <= 0) {
			System.out.println("0이하의 금액은 입금할 수 없습니다.");
			//특정 조건일 때 void형 메서드를 빠져나감
			return;
		}
		balance += amount;
		System.out.println(amount + "원이 입금 되었습니다.");
	}
	
	//출금 하기
	public void withdraw(long amount) {
		if(amount <= 0) {
			System.out.println("0이하의 금액은 입금할 수 없습니다.");
			return;
		}
		if(balance < amount) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		balance -= amount;
		System.out.println(amount + "원이 출금되었습니다.");
	}
	
	public void printAccount() {
		System.out.println("--------------------");
		System.out.println("(일반)계좌번호:" + number);
		System.out.println("비밀번호 : " + password);
		System.out.println("예금주 : " + name);
		System.out.printf("계좌잔액 : %,d원%n", balance);
		System.out.println("--------------------");
	}
	
	
}







