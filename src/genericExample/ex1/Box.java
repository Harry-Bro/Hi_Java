package genericExample.ex1;

public class Box<T> {

	private T box;
	
	public void setBox(T object) {
		this.box = object;
	}
	
	public T getBox() {
		return box;
	}
	
}
