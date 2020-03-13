package com.thinkhr.exercise.randompick;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * App to pick a random word from the available wordlist Requires an internet
 * connection to work to execute run the following command
 * 
 * Once running, follow instructions to get a random word Enter N to quit
 */
public class App {

	static final String LOCATION = Messages.getString("App3.0");
	static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		String userInput = null;
		BufferedReader userRead = new BufferedReader(new InputStreamReader(System.in));

		List<String> wordList = getWordList(new URL(LOCATION));

		helloUser(wordList);

		// continue until User says stop
		while ((userInput = userRead.readLine()) != null && (!userInput.equalsIgnoreCase("N"))) {
			bufferedWriter.write(Messages.getString("App3.2") + getRandomWord(wordList));
			bufferedWriter.newLine();
			bufferedWriter.flush();
		}
		
		userRead.close();
		farewellUser();
	}

	/**
	 * @throws IOException
	 */
	private static void farewellUser() throws IOException {
		bufferedWriter.write(Messages.getString("App3.3"));
		bufferedWriter.newLine();
		bufferedWriter.close();
	}

	/**
	 * Method to show greetings to user
	 * 
	 * @param bufferedWriter
	 * @param wordList
	 * @throws IOException
	 */
	private static void helloUser(List<String> wordList) throws IOException {
		// Total available wordlist
		bufferedWriter.write(Messages.getString("App3.4") + wordList.size() + " words.");
		bufferedWriter.newLine();
		bufferedWriter.write(Messages.getString("App3.6"));
		bufferedWriter.newLine();
		bufferedWriter.write(Messages.getString("App3.7"));
		bufferedWriter.newLine();
		bufferedWriter.flush();
	}

	/**
	 * Method gets a word list from an external source url
	 * 
	 * @param url
	 * @param bufferedWriter
	 * @return List of words to be used
	 * @throws IOException
	 */
	public static List<String> getWordList(URL url) throws IOException {
		// TODO Need to add checks to ensure the url is of a wordlist

		// Build list of words from text fil
		// get word list from external source
		BufferedReader urlRead = new BufferedReader(new InputStreamReader(url.openStream()));
		List<String> wordList = new ArrayList<>();
		wordList = urlRead.lines().collect(Collectors.toList());
		urlRead.close();

		return wordList;
	}

	/**
	 * method to retrieve a random word given a List
	 * 
	 * @param wordList
	 */
	public static String getRandomWord(List<String> wordList) {
		Random rand = new Random();
		String randomWord = wordList.get(rand.nextInt(wordList.size()));

		return randomWord;
	}

}
