import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test class for WordFrequency.
 */
public class WordFrequencyTest {
    private WordFrequency word1;
    private WordFrequency word2;
    private WordFrequency word3;
    private WordFrequency word4;

    /**
     * Setup method, runs before each test case.
     * Initializes WordFrequency objects for testing.
     */
    @Before
    public void setup() {
        word1 = new WordFrequency("Hello");
        word2 = new WordFrequency("World");
        word3 = new WordFrequency("Hello");
        word4 = new WordFrequency("Hello");
        word4.increment(); // word4 has count = 2
    }

    /**
     * Tests if getWord() correctly returns the word.
     */
    @Test
    public void testGetWord() {
        assertEquals("Hello", word1.getWord());
    }

    /**
     * Tests if getCount() correctly returns the initial count.
     */
    @Test
    public void testGetCountInitial() {
        assertEquals(1, word1.getCount());
    }

    /**
     * Tests if increment() increases the count correctly.
     */
    @Test
    public void testIncrement() {
        word1.increment();
        assertEquals(2, word1.getCount());
    }

    /**
     * Tests compareTo() when words are different.
     * "Hello" should come before "World" alphabetically.
     */
    @Test
    public void testCompareToDifferentWords() {
        assertTrue(word1.compareTo(word2) < 0); // "Hello" < "World"
    }

    /**
     * Tests compareTo() when words are the same with the same count.
     */
    @Test
    public void testCompareToSameWordsSameCount() {
        assertEquals(0, word1.compareTo(word3)); // Same word, same count
    }

    /**
     * Tests compareTo() when word frequencies are different.
     * word4 has a higher count than word1, so it should come first.
     */
    @Test
    public void testCompareToDifferentFrequencies() {
        assertTrue(word4.compareTo(word1) < 0); 
    }

    /**
     * Tests compareTo() when words are the same but counts are different.
     */
    @Test
    public void testCompareToSameWordDifferentCount() {
        word1.increment(); // Now word1 has count = 2
        assertEquals(0, word1.compareTo(word4)); // Both have "Hello" with count = 2
    }

    /**
     * Edge case: Comparing with itself should return 0.
     */
    @Test
    public void testCompareToSameObject() {
        assertEquals(0, word1.compareTo(word1));
    }
}
