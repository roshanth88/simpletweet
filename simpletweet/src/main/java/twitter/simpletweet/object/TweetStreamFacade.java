package twitter.simpletweet.object;

import java.io.File;

import twitter.simpletweet.impl.TweetStreamerImpl;

public class TweetStreamFacade {
	TweetStreamerImpl tweetStreamer = new TweetStreamerImpl();

	// Facade method helps to hide the complexity of the tweet streaming implementation
	public void StartStreamingTweets(File tweetFile, String tweetTag) {
		if (tweetFile.exists() && !tweetTag.isEmpty()) {
			tweetStreamer.streamTweetsToFile(tweetFile, tweetTag);
		}
	}
}
