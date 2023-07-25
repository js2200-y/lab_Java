package edu.java.class02;

public class ClassMain02 {

	public static void main(String[] args) {
		// TV 객체(object) 사용 - TV 켬 / 끔 ,  채널변경, 볼륨 변경, ...
		
		// (1) TV 객체를 생성.
		BasicTv tv1 = new BasicTv(); //생성자 호출 -> 객체 생성.
		
		// (2) 생선된 TV 객체(인스턴스)의 필드 또는 메서드를 사용.
		// tv1. powerOn: 생성된 객체(인스턴스) tv1의 필드(멤버 변수) powerOn
		System.out.println("tv1 전원: " + tv1.powerOn);
		tv1.powerOnOff(); // 객체의 메서드 호출.
		
		System.out.println("tv1 채널: "+ tv1.channel);
		System.out.println("tv1 음량: "+ tv1.volume);
		
		tv1.channelUp(); // 채널: 0->1
		tv1.channelUp(); // 채널: 1->2
		tv1.channelDown(); // 채널: 2->1
		
		tv1.volumeUp(); //볼륨: 0->1
		tv1.volumeDown(); // 볼륨: 1->0
		tv1.volumeUp(); 
		tv1.powerOnOff();
		
		System.out.println("------------------------------");
		
		BasicTv tv2 = new BasicTv();
		System.out.println("tv2 전원: " + tv2.powerOn);
		tv2.powerOnOff(); // powerOn : false -> true
		
		for (int i = 0; i < 10; i++) {
			tv2.channelUp();
		}
		
		for (int i= 0; i < 10; i++) {
			tv2.channelDown();
		}
		
		for (int i = 0; i < 10; i++) {
			tv2.volumeUp();
		}
		
		for (int i= 0; i < 10; i++) {
			tv2.volumeDown();
		}
		// 1. 전원= true : 채널 볼륨 변경
		// 2. 채널과 볼륨은 >= 0 
		// 3. 채널과 볼륨을 =< 5
		// 4. 채널은 0-1-2-3-4-5 ->0 순환
		// 5. 볼륨은 0-1-2-3-4-5 멈춤 
		
		
		
	}

}
