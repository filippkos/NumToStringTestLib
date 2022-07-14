import java.util.HashMap;

public class Ukrainian extends Language {

    int wordCount;

    int wordLoopSize;
    HashMap<Integer, String> cardinalNums = new HashMap<>();
    HashMap<Integer, String> ordinalNums = new HashMap<>();
    String [] degreeNames = {"тис€ча", "м≥льон", "м≥ль€рд", "тр≥л≥он", "квадр≥л≥он"};
    String [] articles = {"", ""};
    String [] conjunctions = {"", ""};
    String [] endings = {"ий", "надц€тий", "а", ""};
    public Ukrainian() {
        this.wordCount = 16;
        this.wordLoopSize = (wordCount - 1) / 5;
        this.cardinalNums = cardinalNums;
        this.ordinalNums = ordinalNums;
        this.degreeNames = degreeNames;
        this.articles = articles;
        this.conjunctions = conjunctions;
        this.endings = endings;
        fillingMap();
    }

    @Override
    public HashMap<Integer, String> getCardinalNums() {
        return cardinalNums;
    }
    @Override
    public HashMap<Integer, String> getOrdinalNums() {
        return ordinalNums;
    }
    @Override
    public String[] getDegreeNames() {
        return degreeNames;
    }
    @Override
    public int getWordCount() {
        return wordCount;
    }
    @Override
    public int getWordLoopSize() {
        return wordLoopSize;
    }
    @Override
    public String[] getArticles() {
        return articles;
    }
    @Override
    public String[] getConjunctions() {
        return conjunctions;
    }
    @Override
    public String[] getEndings() {
        return endings;
    }

    public void fillingMap() {
        cardinalNums.put(1, "один");
        cardinalNums.put(2, "два");
        cardinalNums.put(3, "три");
        cardinalNums.put(4, "чотири");
        cardinalNums.put(5, "п'€ть");
        cardinalNums.put(6, "ш≥сть");
        cardinalNums.put(7, "с≥м");
        cardinalNums.put(8, "в≥с≥м");
        cardinalNums.put(9, "дев'€ть");
        cardinalNums.put(10, "дес€ть");
        cardinalNums.put(11, "одинадц€ть");
        cardinalNums.put(12, "дванадц€ть");
        cardinalNums.put(13, "тринадц€ть");
        cardinalNums.put(14, "чотирнадц€ть");
        cardinalNums.put(15, "п'€тнадц€ть");
        cardinalNums.put(16, "ш≥стнадц€ть");
        cardinalNums.put(17, "с≥мнадц€ть");
        cardinalNums.put(18, "в≥с≥мнадц€ть");
        cardinalNums.put(19, "дев'€тнадц€ть");
        cardinalNums.put(20, "двадц€ть");
        cardinalNums.put(30, "тридц€ть");
        cardinalNums.put(40, "сорок");
        cardinalNums.put(50, "п'€тдес€т");
        cardinalNums.put(60, "ш≥стдес€т");
        cardinalNums.put(70, "с≥мдес€т");
        cardinalNums.put(80, "в≥с≥мдес€т");
        cardinalNums.put(90, "дев'€носто");
        cardinalNums.put(100, "сто");
        cardinalNums.put(200, "дв≥ст≥");
        cardinalNums.put(300, "триста");
        cardinalNums.put(400, "чотириста");
        cardinalNums.put(500, "п'€тсот");
        cardinalNums.put(600, "ш≥стсот");
        cardinalNums.put(700, "с≥мсот");
        cardinalNums.put(800, "в≥с≥мсот");
        cardinalNums.put(900, "дев'€тсот");


        ordinalNums.put(1, "перший");
        ordinalNums.put(2, "другий");
        ordinalNums.put(3, "трет≥й");
        ordinalNums.put(4, "четвертий");
        ordinalNums.put(5, "п'€тий");
        ordinalNums.put(6, "шостий");
        ordinalNums.put(7, "сьомий");
        ordinalNums.put(8, "восьмий");
        ordinalNums.put(9, "дев'€тий");
        ordinalNums.put(10, "дес€тий");
        ordinalNums.put(11, "одинадц€тий");
        ordinalNums.put(12, "дванадц€тий");
        ordinalNums.put(13, "тринадц€тий");
        ordinalNums.put(14, "чотирнадц€тий");
        ordinalNums.put(15, "п'€тнадц€тий");
        ordinalNums.put(16, "ш≥стнадц€тий");
        ordinalNums.put(17, "с≥мнадц€тий");
        ordinalNums.put(18, "в≥с≥мнадц€тий");
        ordinalNums.put(19, "дев'€тнадц€тий");
        ordinalNums.put(20, "двадц€тий");
        ordinalNums.put(30, "тридц€тий");
        ordinalNums.put(40, "сороковий");
        ordinalNums.put(50, "п'€тдес€тий");
        ordinalNums.put(60, "ш≥стдес€тий");
        ordinalNums.put(70, "с≥мдес€тий");
        ordinalNums.put(80, "в≥с≥мдес€тий");
        ordinalNums.put(90, "дев'€ностий");
        ordinalNums.put(100, "сотий");
        ordinalNums.put(200, "двохсотий");
        ordinalNums.put(300, "трьохсотий");
        ordinalNums.put(400, "чотирьохсотий");
        ordinalNums.put(500, "п'€тисотий");
        ordinalNums.put(600, "шестисотий");
        ordinalNums.put(700, "с≥мсотий");
        ordinalNums.put(800, "восьмисотий");
        ordinalNums.put(900, "дев'€тисотий");

    }
}
