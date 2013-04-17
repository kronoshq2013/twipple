package jojo;

import java.util.ArrayList;
import java.util.List;

public class TsubuyakiLogic {
	
	public List<TsubuyakiDto> extract(List<TsubuyakiDto> tweets) {
		List<TsubuyakiDto> tweets10 =  new ArrayList<TsubuyakiDto>();
		int tweetCount = 0;
		for (TsubuyakiDto tweet : tweets) {
			tweets10.add(tweet);
			tweetCount++;
			if(tweetCount > 9) {
				break;
			}
		}
		return tweets10;
		
	}

}
