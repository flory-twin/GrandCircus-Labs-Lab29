package co.grandcircus.lab29.models.deckOfCards.newDeck;

public class NewDeckResponse {
	   
	private boolean shuffled;
	private String deck_id;
	private Integer remaining;
	private boolean success;
	public NewDeckResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NewDeckResponse(boolean shuffled, String deck_id, Integer remaining, boolean success) {
		super();
		this.shuffled = shuffled;
		this.deck_id = deck_id;
		this.remaining = remaining;
		this.success = success;
	}
	public boolean isShuffled() {
		return shuffled;
	}
	public void setShuffled(boolean shuffled) {
		this.shuffled = shuffled;
	}
	public String getDeck_id() {
		return deck_id;
	}
	public void setDeck_id(String deck_id) {
		this.deck_id = deck_id;
	}
	public Integer getRemaining() {
		return remaining;
	}
	public void setRemaining(Integer remaining) {
		this.remaining = remaining;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
}
