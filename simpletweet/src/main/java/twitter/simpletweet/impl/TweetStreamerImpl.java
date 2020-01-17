package twitter.simpletweet.impl;

import static twitter.simpletweet.object.Constants.NEW_LINE;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import twitter.simpletweet.interfaces.TweetStreamer;
import static twitter.simpletweet.object.Constants.*;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public class TweetStreamerImpl implements TweetStreamer {

	public void streamTweetsToFile(File tweetFile, String tweetTag) {
		// TODO Auto-generated method stub
		System.out.println("Tweet streaming started for Tweet Tag " + tweetTag);
		try {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthConsumerKey(CONSUMER_KEY).setOAuthConsumerSecret(CONSUMER_SECRET)
					.setOAuthAccessToken(ACCESS_TOKEN).setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);
			TwitterFactory tf = new TwitterFactory(cb.build());
			Twitter twitter = tf.getInstance();
			Query query = new Query("source:" + tweetTag);
			QueryResult result = twitter.search(query);
			List<String> tweetsForTag = result.getTweets().stream().map(item -> item.getText())
					.collect(Collectors.toList());
			writeToTweetFile(tweetFile, tweetsForTag);
		} catch (TwitterException e) {
			System.out.println("Error when streaming the tweets...");
			e.printStackTrace();
		}

		// waiting until the next fetch;
		waitToStreamTweets();
	}

	private void waitToStreamTweets() {
		try {
			Thread.sleep(TWEET_DELAY);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public void writeToTweetFile(File tweetFile, List<String> tweets) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(tweetFile);
			for (String str : tweets) {
				writer.write(str + NEW_LINE);
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {

			}
		}
	}
}
