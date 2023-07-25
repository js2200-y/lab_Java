package edu.java.gugudan.model;


public class GugudanModel {

	public int okCount;   //맞춘 수 누적
    public int failCount; //틀린 수 누적
    public int timer;     //남은시간
    public int firstSu;   //첫번째 수
    public int secondSu;  //두번째 수
    public int resultSu;  //정답
    public int userInput;//유저 입력값
    public String markingRe; //정답유무 
	
    public int[] displaySu = new int[16];
    
	public GugudanModel() {
		initDisplaySu();
	}
	
	
	public void initDisplaySu(){
		for(int i = 0; i < 16 ; i++){
			displaySu[i] = setRandomSu();
		}
	}//initDisplaySu()
	
	
	//1~9 단 범위에서의 정답값을 랜덤으로 리턴
	public int setRandomSu(){
		int imsiSu1 = (int)(Math.random() * 9) + 1;
		int imsiSu2 = (int)(Math.random() * 9) + 1;
		return imsiSu1 * imsiSu2;
	}


	public void setQuestion(){
		boolean check = false;
		firstSu = (int)(Math.random() * 9) + 1;
		secondSu = (int)(Math.random() * 9) + 1;
		resultSu = firstSu * secondSu;
		for(int i = 0; i < 16; i++){
			if(displaySu[i] == resultSu){
				check = true;
				break;
			}
		}//end for
		if(!check)setQuestion();
	}
}

