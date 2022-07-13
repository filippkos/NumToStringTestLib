import java.util.HashMap;

public class Ukrainian extends Language {

    int wordCount;
    HashMap<Integer, String> cardinalNums = new HashMap<>();
    String [] degreeNames = {"������", "�����", "������", "�����", "��������"};

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
        cardinalNums.put(1, "����");
        cardinalNums.put(2, "���");
        cardinalNums.put(3, "���");
        cardinalNums.put(4, "������");
        cardinalNums.put(5, "�'���");
        cardinalNums.put(6, "�����");
        cardinalNums.put(7, "��");
        cardinalNums.put(8, "���");
        cardinalNums.put(9, "���'���");
        cardinalNums.put(10, "������");
        cardinalNums.put(11, "����������");
        cardinalNums.put(12, "����������");
        cardinalNums.put(13, "����������");
        cardinalNums.put(14, "������������");
        cardinalNums.put(15, "�'���������");
        cardinalNums.put(16, "�����������");
        cardinalNums.put(17, "���������");
        cardinalNums.put(18, "����������");
        cardinalNums.put(19, "���'���������");
        cardinalNums.put(20, "��������");
        cardinalNums.put(30, "��������");
        cardinalNums.put(40, "�����");
        cardinalNums.put(50, "�'�������");
        cardinalNums.put(60, "���������");
        cardinalNums.put(70, "�������");
        cardinalNums.put(80, "��������");
        cardinalNums.put(90, "���'������");
        cardinalNums.put(100, "���");
    }
}
