package co.grandcircus.lab29.errors;

public class ErrorContainer {
	private Error storedError;
	
	public ErrorContainer() {
		super();
		storedError = null;
	}
	
	public ErrorContainer(String errorMessage) {
		this();
		storedError = new Error(errorMessage);
	}
	
	public void setError(String errorMessage) {
		storedError = new Error(errorMessage);
	}
	
	public boolean hasError() {
		if (storedError != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Error consumeError()
	{
		Error toBeReturned = storedError;
		storedError = null;
		return toBeReturned;
	}
}
