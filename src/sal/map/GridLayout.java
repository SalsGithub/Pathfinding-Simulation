package sal.map;

/**
 * 
 * @author Sal
 * An enumeration to hold the grid layouts.
 * Goes from 10x10 to 50x50, then 100x100.
 */
public enum GridLayout {
	TEN_BY_TEN("10x10", 10),
	TWENTY_BY_TWENTY("20x20", 20),
	THIRTY_BY_THIRTY("30x30", 30),
	FOURTY_BY_FOURTY("40x40", 40),
	FIFTY_BY_FIFTY("50x50", 50),
	ONE_HUNDRED_BY_ONE_HUNDRED("100x100", 100);
	
	/**
	 * The phrase to refer to a grid layout.
	 */
	private String phrase;
	
	/**
	 * The value of the row and columns.
	 */
	private int value;
	
	/**
	 * Construct a grid layout.
	 * @param phrase
	 */
	GridLayout(String phrase, int value) {
		this.phrase = phrase;
		this.value = value;
	}
	
	/**
	 * Finds a grid layout using a phrase.
	 * @param phrase
	 * @return
	 */
	public static GridLayout findByPhrase(String phrase) {
		for (GridLayout gridLayout : GridLayout.values()) 
			if (gridLayout.getPhrase().equalsIgnoreCase(phrase))
				return gridLayout;
		return null;
	}
	
	/**
	 * Get the phrase
	 * @return - the phrase.
	 */
	public String getPhrase() {
		return phrase;
	}
	
	/**
	 * Get the value;
	 * @return - the value.
	 */
	public int getValue() {
		return value;
	}
}
