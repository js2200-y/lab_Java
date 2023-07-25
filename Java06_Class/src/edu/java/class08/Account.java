package edu.java.class08;

/**
 * 은행 계좌 클래스. 필드: 계좌번호, 잔액. 메서드: 입금, 출금, 이체, 정보 출력.
 */
public class Account {
	// field
	int accountNo; // 계좌번호
	double balance; // 잔고

	// TODO: argument 2개를 갖는 생성자
		public Account(int accountNo, double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}

	/**
     * 입금(deposit)
     * @param amount 입금액(double).파라미터의 데이터 타입 더블
     * @return 입금 후 잔액.
     */
    public double deposit(double amount) {
    	balance += amount;
    	return balance;
      }

	/**
     * 출금(withdraw)
     * @param amount 출금액(double). 얼마를 출금할건지 어마운트 파라미터 한개.
     * @return 입금 후 잔액. (마이너스 통장가능) 밸러스에 출금액을 빼고 밸러스에 다시 저장.
     */
    public double withdraw(double amount) {
    	balance -=amount;
    	return balance;
    }

    /**
     * 이체(transfer).
     * @param to 이체할 은행 계좌 객체(Account 타입 객체). 메서드 호출 주어에 내가(1) 얼마를(2)
     * @param amount 이체할 금액(double). 파라미터의 타입도 어카운트 얼마를 
     * @return true. 나의 밸러스에서 어마운트를 빼고 밸러스에 저장. 
     */
    public boolean transfer(double amount, Account to) {
    	// 이체: 내 계좌 출금, 다른 계좌 입금.
//    	balance -= amount;
//    	to.balance += amount;
    	this.withdraw(amount);
    	to.deposit(amount);
    		return true;
    	}
    
    
    /**
     * 정보 출력(printInfo).
     * 계좌 번호와 잔고를 출력.
     */
    public void printInfo() {
    	System.out.printf("계좌 정보(번호: %d, 잔액: %f)\n",
    						this.accountNo, this.balance);
//    	System.out.println("계좌번호: " + accountNo);
//    	System.out.println("잔고: " + balance);

    }
    	
    
    
    
}
