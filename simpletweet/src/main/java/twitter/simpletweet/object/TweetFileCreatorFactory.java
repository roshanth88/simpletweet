package twitter.simpletweet.object;

import static twitter.simpletweet.object.Constants.*;

import java.io.File;
import java.util.*;
import java.util.List;

import twitter.simpletweet.impl.TweetFileCreatorImpl;

public class TweetFileCreatorFactory {
	List<String> userInput;
	File TweetFile;
	TweetFileCreatorImpl fileCreator = new TweetFileCreatorImpl();

	// Factory method helps to create new Stream file and start the stream process
	public void createTweetFileandStartStreaming(String input) {
		userInput = Arrays.asList(input.split("\\s", MAX_TWEET_TAG));
		for (String userInputTag : userInput) {
			if (!userInputTag.isEmpty()) {
				TweetFile = fileCreator.createTweetFile(userInputTag);
				fileCreator.startstreamingTweets(TweetFile, userInputTag);
			}
		}
	}
}
