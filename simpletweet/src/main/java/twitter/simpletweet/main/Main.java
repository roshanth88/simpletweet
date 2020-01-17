package twitter.simpletweet.main;

import static twitter.simpletweet.object.Constants.*;

import java.util.Scanner;

import twitter.simpletweet.object.TweetFileCreatorFactory;

public class Main {
	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("Enter tweet tags to start streaming (Can enter up to %d seperated by space)",MAX_TWEET_TAG);
		System.out.println();
		Scanner in = new Scanner(System.in);
		String userinput = in.nextLine();
		//Declaring the TweetFileFactory to create Tweet Streaming files
		TweetFileCreatorFactory tweetFileFactory = new TweetFileCreatorFactory();
		tweetFileFactory.createTweetFileandStartStreaming(userinput);
	}

}
