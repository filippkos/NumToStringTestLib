import java.util.HashMap;

public class Ukrainian extends Language {

    int wordCount;
    HashMap<Integer, String> cardinalNums = new HashMap<>();
    String [] degreeNames = {"тис€ча", "м≥льон", "м≥ль€рд", "тр≥л≥он", "квадр≥л≥он"};

    public Ukrainian() {
        this.wordCount = 16;
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

    @Override
    public int getWordCount() {
        return wordCount;
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
    }
}
