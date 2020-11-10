package exception;

public class CustomException extends RuntimeException{
		public CustomException(String log,String msg) {
			super(msg);
		}
		public CustomException(String msg) {
			super(msg);
		}
}
