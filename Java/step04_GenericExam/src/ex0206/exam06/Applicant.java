package ex0206.exam06;

public class Applicant<T> {
	private T kind;	//사람, 직장인, 고등, 중학..과 같은 종류

	public Applicant(T kind) {
		super();
		this.kind = kind;
	}

	public T getKind() {
		return kind;
	}

	public void setKind(T kind) {
		this.kind = kind;
	}
	
	
}
