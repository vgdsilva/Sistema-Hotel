package model.exceptions;

public class ReserExcepition extends RuntimeException{
	private static final long serailVersionUID = 1L;
	
	public ReserExcepition(String msg) {
		super(msg);
	}
}
