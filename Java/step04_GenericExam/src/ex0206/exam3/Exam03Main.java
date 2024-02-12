package ex0206.exam3;

public class Exam03Main {

	public static void main(String[] args) {
		HomeAgency homeAgency = new HomeAgency();
        Home home = homeAgency.rent(); // 집을 대여함
        home.turnOffLight(); // 집의 불을 끔
        
        System.out.println("-----------");
        
        CarAgency carAgency = new CarAgency(); // CarAgency 인스턴스 생성을 수정함
        Car car = carAgency.rent(); // rent()가 Car 객체를 반환한다고 가정
        car.run(); // 차를 운행함
	}

}
