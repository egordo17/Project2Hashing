import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test class for HashDocument.
 */
public class HashDocumentTest {
    // Object to be tested
    private HashDocument runner;

    /**
     * setup() method, runs before each test method below.
     * Use this method to recreate the objects needed for
     * testing your class.
     */
    @Before
    public void setup() {
        runner = new HashDocument("Gettysburg","Four score and seven years"+
        " ago our fathers brought forth,"+
        " upon this continent, a new nation, conceived in liberty, and dedicated"+
        " to the proposition that \"all men"+
        " are created equal.\"\"\n" +
        "Now we are engaged in a great civil war, testing whether that nation, or"+
        " any nation so conceived,"+
        " and so dedicated, can long endure. We are met on a great battle field of"+
        " that war. We have come to"+
        " dedicate a portion of it, as a final resting place for those who died here,"+
        " that the nation might live."+
        " This we may, in all propriety do. But, in a larger sense, we can not dedicate"+
        " -- we can not consecrate --"+
        " we can not hallow, this ground -- The brave men, living and dead, who struggled"+
        " here, have hallowed it, far"+
        " above our poor power to add or detract. The world will little note, nor long"+
        " remember what we say here;"+
        " while it can never forget what they did here.\n" +
        "It is rather for us, the living, to stand here, we here be dedicated to the"+
        " great task remaining before"+
        " us -- that, from these honored dead we take increased devotion to that cause"+
        " for which they here, gave"+
        " the last full measure of devotion -- that we here highly resolve these dead"+
        " shall not have died in vain;"+
        " that the nation, shall have a new birth of freedom, and that government of the"+
        " people by the people for"+
        " the people, shall not perish from the earth.\n");
    }

    /**
     * Make sure that the getTitle() method returns the title.
     */
    @Test
    public void testGetTitle() {
        String t = runner.getTitle();
        assertEquals("Gettysburg", t);
    }

    /**
     * Make sure that the frequency() method returns the correct count of a word.
     */
    @Test
    public void testFrequency() {
        assertEquals(8, runner.frequency("here")); 
        assertEquals(3, runner.frequency("dedicated")); 
        assertEquals(0, runner.frequency("missing")); // Word not in document
    }

    /**
     * Make sure that addWord() correctly adds words and updates counts.
     */
    @Test
    public void testAddWord() {
        runner.addWord("test");
        assertEquals(1, runner.frequency("test")); 

        runner.addWord("dedicated");
        assertEquals(4, runner.frequency("dedicated")); 
    }

    /**
     * Make sure that contains() correctly checks 
     * if a word exists in the document.
     */
    @Test
    public void testContains() {
        assertTrue(runner.contains("freedom")); // Word exists
        assertFalse(runner.contains("missingword")); // Word does not exist
    }

    /**
     * Make sure that numUniqueWordsInTable() returns 
     * the correct number of unique words.
     */
    @Test
    public void testNumUniqueWordsInTable() {
        assertTrue(runner.numUniqueWordsInTable() > 0); 
    }

    /**
     * Make sure that totalNumOfWords() returns the total number of words.
     */
    @Test
    public void testTotalNumOfWords() {
        assertTrue(runner.totalNumOfWords() > 0); 
        
    }

    /**
     * Make sure that mostCommonWord() returns the 
     * correct most frequent word.
     */
    @Test
    public void testMostCommonWord() {
        assertEquals("that", runner.mostCommonWord()); 
        
    }

    /**
     * Make sure that termFrequency() correctly calculates 
     * term frequency.
     */
    @Test
    public void testTermFrequency() {
        double expectedTF = (double) runner.frequency("freedom") / runner.totalNumOfWords();
        assertEquals(expectedTF, runner.termFrequency("freedom"), 0.01);

        assertEquals(0.0, runner.termFrequency("missingword"), 0.01); 
    }
}