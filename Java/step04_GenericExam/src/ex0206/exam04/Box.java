package ex0206.exam04;

public class Box<T> {
	public T content;
	
	/**
	 * 자기자신과 인수로 전달된 Box<T>의 content를 비교
	 */
	
	public boolean compare(Box<T> other) {
		if(content.equals(other.content)) {
			return true;
		}
		return false;
	}
}
