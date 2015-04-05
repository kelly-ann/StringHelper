package org.kelly_ann.junit.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/*
 * JUnit Best Practices: 
 * The tests below should be in multiple files but they are in 1 file here for simplicity.
 * Name of each test method should tell you what is being tested.
 * The values used in the test should be the values that are important for the test.  
 * If unimportant, remove from the test.
 * Aim for simpler assert()'s.
 * Test for empty vars.
 * JUnit's that are not written well are difficult to understand and over time lose their value. 
 */


public class StringHelperTest {
	// this will be run before & after the class
	/*
	@BeforeClass
	public static void before() {
		System.out.println("Before Class");
	}
	@AfterClass
	public static void after() {
		System.out.println("After Class");
	}
	*/
	
	StringHelper helper;
	
	// this will be run before & after each test case/scenario's method
	@Before
	public void before() {
		helper = new StringHelper();
	}
	
	@After
	public void after() {
		helper = null;
	}
	
	// the scenario below is why it's not good to have more than one test condition in a single JUnit test method.
	// Usage: assertEquals(expectedOutput, actualOuput);
	/*
	@Test
	public void testAssertEquals() {
		assertEquals("ABC", "ABC"); 
		assertEquals("ABC", "ABC"); 
		assertEquals("ABC", "ABC"); 
		assertEquals("ABC", "abc"); // this will fail
		assertEquals("ABC", "ABC");  // because the condition above failed this will never run
	}
	*/
	
	@Test
	public void testTruncateAInFirst2Positions() {
		System.out.println("testTruncateAInFirst2Positions");
		assertEquals("RTAA", helper.truncateAInFirst2Positions("RTAA"));
		assertEquals("BB", helper.truncateAInFirst2Positions("AABB"));
		assertEquals("BBB", helper.truncateAInFirst2Positions("BABB"));

	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame() { 
		System.out.println("testAreFirstAndLastTwoCharactersTheSame");
		// assertTrue(false); // this will fail
		// assertFalse(true); // this will fail
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame(""));
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("A"));
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("AB"));
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("AAA"));
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("AAB"));
	}
	
	// Arrays.sort
	@Test
	public void testArraysSort() {
		int[] numbers = {5,6,4,2,3,1};
		Arrays.sort(numbers);
		int[] expectedOutput = {1,2,3,4,5,6};
		assertArrayEquals(expectedOutput, numbers);
	}
	
	// this is a test where you expect an Exception to be thrown
	@Test(expected=NullPointerException.class)
	public void testArraysSortWithNullCondition() {
		int[] numbers = null;
		Arrays.sort(numbers);
	}
	
	// this will test to see if this test case runs for 2ms or less.
	@Test(timeout=250)
	public void testArraySortPerformance() {
		for(int i=0; i<1000000; i++) {
			int[] numbers = {i, i-1, i+1};
			Arrays.sort(numbers);
		}
	}

}
