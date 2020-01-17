package twitter.simpletweet.interfaces;

import java.io.File;

public interface TweetFileCreator {
	
	File createTweetFile(String fileName);
	void startstreamingTweets(File tweetFile, String tweetTag);
		
}
