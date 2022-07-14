import java.util.HashMap;

public class Language {
    int wordCount;
    int wordLoopSize;

    HashMap<Integer, String> cardinalNums;
    HashMap<Integer, String> ordinalNums;
    String [] degreeNames;

    String [] articles;
    String [] conjunctions;
    String [] endings;

    public HashMap<Integer, String> getCardinalNums() {
        return cardinalNums;
    }

    public HashMap<Integer, String> getOrdinalNums() {
        return ordinalNums;
    }

    public String[] getDegreeNames() {
        return degreeNames;
    }

    public int getWordCount() {
        return wordCount;
    }

    public int getWordLoopSize() {
        return wordLoopSize;
    }

    public String[] getArticles() {
        return articles;
    }

    public String[] getConjunctions() {
        return conjunctions;
    }

    public String[] getEndings() {
        return endings;
    }
}
