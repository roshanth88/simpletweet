package twitter.simpletweet.impl;

import java.io.*;

import twitter.simpletweet.interfaces.TweetFileCreator;
import twitter.simpletweet.object.TweetStreamFacade;

import static twitter.simpletweet.object.Constants.*;

public class TweetFileCreatorImpl implements TweetFileCreator {
	private String TweetStreamFile;
	private TweetStreamFacade tweetingFacade = new TweetStreamFacade();

	public File createTweetFile(String tweetFileName) {
		this.TweetStreamFile = tweetFileName;
		Writer writer = null;
		File tweetFile = new File(DEFAULT_DIR + "/" + TweetStreamFile + ".txt");
		System.out.println("Stream file created on :: " + tweetFile.getPath());
		boolean isFileCreationSuccess = false;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tweetFile), "utf-8"));
			isFileCreationSuccess = true;
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {

			}
		}
		return isFileCreationSuccess ? tweetFile : null;
	}

	// method to call the facade implementation
	@Override
	public void startstreamingTweets(File tweetFile, String tweetTag) {
		tweetingFacade.StartStreamingTweets(tweetFile, tweetTag);
	}
}
