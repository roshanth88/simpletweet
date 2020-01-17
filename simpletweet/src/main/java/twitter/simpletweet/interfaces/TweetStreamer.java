package twitter.simpletweet.interfaces;

import java.io.File;

public interface TweetStreamer {
	void streamTweetsToFile(File tweetFile, String tweetTag);
}
