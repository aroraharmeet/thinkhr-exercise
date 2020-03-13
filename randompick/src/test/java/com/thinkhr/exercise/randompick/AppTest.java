package com.thinkhr.exercise.randompick;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.thinkhr.challenge.randompick.App;
import com.thinkhr.challenge.randompick.Messages;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    /**
     * Check if Random Word can pull from list of 1
     */
    @Test
    public void shouldMatchListOfOne()
    {
    	List<String> testList = Arrays.asList("Rob");
    	assertEquals(App.getRandomWord(testList), "Rob" );
    }
    
    /**
     * Check if Random word picker picks from the list
     */
    @Test
    public void shouldContainInList()
    {
    	List<String> testList = Arrays.asList("Rob", "Bob", "Sob");
        assert testList.contains(App.getRandomWord(testList)) : "Orphan Word";
    }
    
    /**
     * Check if fetching wordlist takes too long > 10sec
     * @throws IOException
     */
    @Test
    public void shouldFinishIn10Secs() throws IOException
    {
    	String LOCATION = Messages.getString("App3.0");
    	URL url = new URL(LOCATION);

    	long start = System.currentTimeMillis();
		App.getWordList(url);

    	assert System.currentTimeMillis() - start < 10000 : "Taking too long to create list";
    }
    
    /**
     * Check if given a URL we get a List
     * @throws IOException
     */
    @Test
    public void shouldReturnAList() throws IOException
    {
    	String LOCATION = Messages.getString("App3.0");
    	URL url = new URL(LOCATION);
    	
    	List<String> wordList = App.getWordList(url);
    	
    	assert wordList instanceof List<?>;
    }
    
    @Test
    public void shouldBeValidURL()
    {
    	//TODO This will have to be an integration test unless I want to test configuration
    }
    
    
    
}
