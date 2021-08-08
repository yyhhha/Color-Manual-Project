package mini.exception;

public class DuplicateException extends Exception {
	
	public DuplicateException() {
		super("중복된 데이터가 있습니다");
	}
}
