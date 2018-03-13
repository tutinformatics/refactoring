package rental;

public class InvalidRequestException extends RuntimeException {
	private static final long serialVersionUID = -3860346525962550742L;

	public InvalidRequestException(String message) {
		super(message);
	}
}
