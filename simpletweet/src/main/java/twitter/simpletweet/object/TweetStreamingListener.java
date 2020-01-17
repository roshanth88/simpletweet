package twitter.simpletweet.object;

import java.io.*;
import java.io.File;

import twitter4j.Status;
import twitter4j.StatusAdapter;
import static twitter.simpletweet.object.Constants.*;

public class TweetStreamingListener  {
	/*
	 * private final TweetConsumer tweetConsumer; private final File
	 * fileToWriteTweet; public TweetStreamingListener(File tweetFile) {
	 * //this.tweetConsumer = tweetConsumer; fileToWriteTweet = tweetFile; }
	 * 
	 * @Override public void onStatus(Status status) { BufferedWriter writer = null;
	 * try { writer = new BufferedWriter(new FileWriter(fileToWriteTweet,true));
	 * writer.write(NEW_LINE+status.getText()); } catch (IOException ex) {
	 * System.out.println(ex.getMessage()); } finally { try { writer.close(); }
	 * catch (Exception ex) {
	 * 
	 * } } //tweetConsumer.onTweet(status.getUser().getScreenName(),
	 * status.getText()); }
	 */
}
