package co.grandcircus.lab29.models.deckOfCards.newDeck;

import co.grandcircus.lab29.models.deckOfCards.BaseRequest;

public class NewDeckRequest extends BaseRequest {
	
	// "shuffle" to shuffle, "" to not shuffle
	private String shuffle;
	// Number of decks to retrieve.
	private Integer deck_count;
	
	public Integer getDeck_count() {
		return deck_count;
	}
	public void setDeck_count(Integer deck_count) {
		this.deck_count = deck_count;
	}
	public String getShuffle() {
		return shuffle;
	}
	public NewDeckRequest(Integer deck_count) {
		this();
		this.deck_count = deck_count;
	}
	public NewDeckRequest() {
		super();
		this.shuffle = "shuffle";
	}
	
	public String buildRequestUrl() {
		return "" +
				BaseRequest.url +
				"/new" +
				( this.shuffle.equals("") ? 
						"" : 
						"/" + this.shuffle ) + 
				"/?deck_count=" + this.deck_count;
				
				
	}
}
