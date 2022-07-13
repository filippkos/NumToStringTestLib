import java.util.HashMap;

public class Language {
    int wordCount;
    HashMap<Integer, String> cardinalNums;
    String [] degreeNames;

    public HashMap<Integer, String> getCardinalNums() {
        return cardinalNums;
    }

    public void setCardinalNums(HashMap<Integer, String> cardinalNums) {
        this.cardinalNums = cardinalNums;
    }

    public String[] getDegreeNames() {
        return degreeNames;
    }

    public void setDegreeNames(String[] degreeNames) {
        this.degreeNames = degreeNames;
    }

    public int getWordCount() {
        return wordCount;
    }
}
