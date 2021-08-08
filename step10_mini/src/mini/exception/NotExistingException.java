package mini.exception;

public class NotExistingException extends Exception {

	public NotExistingException() {
		super("데이터가 존재하지 않습니다");
	}	

}
