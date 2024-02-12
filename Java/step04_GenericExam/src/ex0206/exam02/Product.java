package ex0206.exam02;

public class Product<K,M> {
	private K kind;	//상품의 종류 - ex)Tv나 Audio
	private M model;	//모델정보
	
	public K getKind() {
		return kind;
	}
	public void setKind(K kind) {
		this.kind = kind;
	}
	public M getModel() {
		return model;
	}
	public void setModel(M model) {
		this.model = model;
	}
	
	
}
