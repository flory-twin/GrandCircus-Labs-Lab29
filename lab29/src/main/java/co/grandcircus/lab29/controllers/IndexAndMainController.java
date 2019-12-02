package co.grandcircus.lab29.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.lab29.errors.ErrorContainer;
import co.grandcircus.lab29.models.deckOfCards.newDeck.NewDeckRequest;
import co.grandcircus.lab29.models.deckOfCards.newDeck.NewDeckResponse;

@Controller
public class IndexAndMainController {
	
	public static void updateError(HttpSession session, String errorMessage) {
		((ErrorContainer) session.getAttribute("error")).setError(errorMessage);
	}
	
	@RequestMapping("/")
	public ModelAndView directToMainPage() {
		return new ModelAndView("main");
	}
		
	@RequestMapping(value = "/get-deck")
	public ModelAndView getNewDeck(HttpSession session)
	{
		RestTemplate restTemplate = new RestTemplate();
		// TODO Is there a way to get Spring to auto-generate an external REST request from a model?
		NewDeckRequest ndReq = new NewDeckRequest(1);
		
		ResponseEntity<NewDeckResponse> deckResponse = restTemplate.getForEntity(
				ndReq.buildRequestUrl(), 
				NewDeckResponse.class);
		
		if (!deckResponse.getStatusCode().is2xxSuccessful()) {
			String errorMessage = "The deck webservice is experiencing issues:\n" +
					"   " + deckResponse.getStatusCodeValue() + 
					": " + deckResponse.getStatusCode().getReasonPhrase();
			updateError(session, errorMessage);
			return new ModelAndView("main");
		}
		
		return addDeckToSessionAndDisplayMainPage(deckResponse.getBody(), session);
	}
	
	@RequestMapping() 
	public ModelAndView addDeckToSessionAndDisplayMainPage(@RequestParam NewDeckResponse ndr, HttpSession session) {
		session.setAttribute("deck", ndr);
		return directToMainPage();
	}

}
