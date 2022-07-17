import java.util.HashMap;

public class Ukrainian extends Language {

    int wordCount;

    int wordLoopSize;
    boolean twoWordHundreds;
    HashMap<Integer, String> cardinalNums = new HashMap<>();
    HashMap<Integer, String> ordinalNums = new HashMap<>();
    HashMap<Integer, String> ordinalComponentNums = new HashMap<>();
    String [] degreeNames = {"тис€ч", "м≥льон", "м≥ль€рд", "тр≥л≥он", "квадр≥л≥он"};
    String [] feminineNums = {"одна", "дв≥"};
    String [] articles = {"", ""};
    String [] conjunctions = {"", ""};
    String [] endings = {"ний", "a", "≥", "а", "≥в", "", ""};
    public Ukrainian() {
        this.wordCount = 21;
        this.wordLoopSize = (wordCount - 1) / 5;
        this.cardinalNums = cardinalNums;
        this.ordinalNums = ordinalNums;
        this.degreeNames = degreeNames;
        this.articles = articles;
        this.conjunctions = conjunctions;
        this.endings = endings;
        this.twoWordHundreds = false;
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
    @Override
    public HashMap<Integer, String> getOrdinalComponentNums() {
        return ordinalComponentNums;
    }
    @Override
    public String[] getFeminineNums() {
        return feminineNums;
    }
    @Override
    public boolean isTwoWordHundreds() {
        return twoWordHundreds;
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

        ordinalComponentNums.put(1, "одно");
        ordinalComponentNums.put(2, "двох");
        ordinalComponentNums.put(3, "трьох");
        ordinalComponentNums.put(4, "чотирьох");
        ordinalComponentNums.put(5, "п'€ти");
        ordinalComponentNums.put(6, "шести");
        ordinalComponentNums.put(7, "семи");
        ordinalComponentNums.put(8, "восьми");
        ordinalComponentNums.put(9, "дев'€ти");
        ordinalComponentNums.put(10, "дес€ти");
        ordinalComponentNums.put(11, "одинадц€ти");
        ordinalComponentNums.put(12, "дванадц€ти");
        ordinalComponentNums.put(13, "тринадц€ти");
        ordinalComponentNums.put(14, "чотирнадц€ти");
        ordinalComponentNums.put(15, "п'€тнадц€ти");
        ordinalComponentNums.put(16, "ш≥стнадц€ти");
        ordinalComponentNums.put(17, "с≥мнадц€ти");
        ordinalComponentNums.put(18, "в≥с≥мнадц€ти");
        ordinalComponentNums.put(19, "дев'€тнадц€ти");
        ordinalComponentNums.put(20, "двадц€ти");
        ordinalComponentNums.put(30, "тридц€ти");
        ordinalComponentNums.put(40, "сорока");
        ordinalComponentNums.put(50, "п€тидес€ти");
        ordinalComponentNums.put(60, "шестидес€ти");
        ordinalComponentNums.put(70, "семидес€ти");
        ordinalComponentNums.put(80, "восьмидес€ти");
        ordinalComponentNums.put(90, "дев'€носто");

    }
}
