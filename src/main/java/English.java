import java.util.HashMap;

public class English extends Language {

    int wordCount;
    HashMap<Integer, String> cardinalNums = new HashMap<>();
    String [] degreeNames = {"thousand", "million", "billion", "trillion", "quadrillion"};

    public English() {
        this.wordCount = 26;
        this.cardinalNums = cardinalNums;
        this.degreeNames = degreeNames;
        fillingMap();
    }

    public HashMap<Integer, String> getCardinalNums() {
        return cardinalNums;
    }

    public String[] getDegreeNames() {
        return degreeNames;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void fillingMap() {
        cardinalNums.put(1, "one");
        cardinalNums.put(2, "two");
        cardinalNums.put(3, "three");
        cardinalNums.put(4, "four");
        cardinalNums.put(5, "five");
        cardinalNums.put(6, "six");
        cardinalNums.put(7, "seven");
        cardinalNums.put(8, "eight");
        cardinalNums.put(9, "nine");
        cardinalNums.put(10, "ten");
        cardinalNums.put(11, "eleven");
        cardinalNums.put(12, "twelve");
        cardinalNums.put(13, "thirteen");
        cardinalNums.put(14, "fourteen");
        cardinalNums.put(15, "fifteen");
        cardinalNums.put(16, "sixteen");
        cardinalNums.put(17, "seventeen");
        cardinalNums.put(18, "eighteen");
        cardinalNums.put(19, "nineteen");
        cardinalNums.put(20, "twenty");
        cardinalNums.put(30, "thirty");
        cardinalNums.put(40, "forty");
        cardinalNums.put(50, "fifty");
        cardinalNums.put(60, "sixty");
        cardinalNums.put(70, "seventy");
        cardinalNums.put(80, "eighty");
        cardinalNums.put(90, "ninety");
        cardinalNums.put(100, "hundred");
    }
}
