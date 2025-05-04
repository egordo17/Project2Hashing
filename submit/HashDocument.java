import java.util.*;

/**
 * This class stores a title and test and is able to determin how many times
 * a word occurs, how many different words are in the text and how many total 
 * words are in the text.
 */
public class HashDocument {
    // TODO add instance variables
    private String title;
    private String content;
    private HashMap<String, Integer> wordMap;
    private int totalWords;
    /**
     * This constructor takes a title and content parameter and initializes a
     * HashMap and process the test
     * @param title is the title that is stored
     * @param content is the varialble that holds the text
     */
    public HashDocument(String title, String content)
    {
        // TODO add code here
        this.title = title;
        this.content = content;
        this.wordMap = new HashMap<>();
        processWords(content);
    }

    /**
     * Return the title of the object.
     * @return returns the string object.
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Breaks up content into words, skipping punctuations
     * and keeping only words that have more than 3 characters.
     * @param content - all the text from a file to be processed
     */
    private void processWords(String content) {
        // Use regular expression to pick up words only
        String[] words = content.split("\\W+");
        for (String word : words) {
            // and process only words longer than 3 characters
            if (word.length() > 3) {
                addWord(word.toLowerCase());
            }
        }
    }
    
    /**
     * return the number of time a word comes up in a text.
     * @param w Is a String word that is being counted.
     * @return the number of times a word occurs in a text.
     */
    public int frequency(String w) {
        // TODO add code here
        return wordMap.getOrDefault(w.toLowerCase(), 0);
    }

    /**
     * adds a word to a hashMap and increments the count and if the word is new then it 
     * adds a value to the new word
     * @param w stores the word that is being added to the hashmap
     */
    public void addWord(String w) {
        wordMap.put(w, wordMap.getOrDefault(w, 0) + 1);
        totalWords++; // Ensure total word count is updated
    }

    /**
     * Checks if the word exists in the wordMap.
     * @param w The word to check for.
     * @return true if the word exists in the wordMap, false otherwise.
     */
    public boolean contains(String w) {
        return wordMap.containsKey(w.toLowerCase());
    }

    /**
     * Returns the number of unique words stored in the wordMap.
     * @return the number of unique words in the wordMap.
     */
    public int numUniqueWordsInTable() {
        return wordMap.size();
    }

    /**
     * Returns the total number of words in the document (including duplicates).
     * @return The total number of words in the wordMap.
     */
    public int totalNumOfWords() {
        return totalWords;
    }

    /**
     * Returns the word with the highest count of appearances in the wordMap.
     * @return The most common word.
     */
    public String mostCommonWord() {
        String mostCommon = null;
        int maxCount = 0;

        // Iterate over the wordMap to find the word with the maximum count
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommon = entry.getKey();
            }
        }

        return mostCommon;
    }

    /**
     * Returns the term frequency of a given word.
     * @param w The word to calculate term frequency for.
     * @return The term frequency of the word in the document.
     */
    public double termFrequency(String w) {
        int wordFrequency = frequency(w);

        if (wordFrequency > 0) {
            return (double) wordFrequency / totalNumOfWords();
        }

        return 0.0; // If the word is not present, return 0
    }

}
