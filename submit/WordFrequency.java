/**
 * TODO Add javadoc here
 */
public class WordFrequency implements Comparable<WordFrequency> {
    // TODO add instance variables
    private String word;
    private int count;

    /**
     * Constuctor that take the word that is being stored  as w to word.
     * @param w is what is stored as word.
     */
    public WordFrequency(String w)
    {
        // TODO add code here
        word = w;
        count = 1;
    }

    /**
     * Method returns word when it is called
     * @return the string variable word.
     */
    public String getWord()
    {
        return word;
    }

    /**
     * Method returns the word count of the String.
     * @return the word count of the object.
     */
    public int getCount()
    {
        return count;
    }

    /**
     * Increments the count of the of the object when called.
     */
    public void increment()
    {
        count++;
    }

    /**
     * Compares two WordFrequency objects.
     * First, it compares by count (descending). 
     * If counts are equal, it compares words alphabetically (ascending).
     * @param other Another WordFrequency object.
     * @return Negative if this is greater, positive if other is greater, 0 if equal.
     */
    @Override
    public int compareTo(WordFrequency other) {
        int countComparison = Integer.compare(other.getCount(), this.getCount()); 
        if (countComparison != 0) {
            return countComparison;
        }
        return this.getWord().compareTo(other.getWord()); 
    }

}
