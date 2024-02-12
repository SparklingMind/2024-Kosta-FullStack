package ex0206.exam3;

public class HomeAgency implements Rentable<Home> {
	@Override
	public Home rent() {
		return new Home();
	
	}
}
