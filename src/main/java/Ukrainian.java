import java.util.HashMap;

public class Ukrainian extends Language {

    int wordCount;

    int wordLoopSize;
    boolean twoWordHundreds;
    HashMap<Integer, String> cardinalNums = new HashMap<>();
    HashMap<Integer, String> ordinalNums = new HashMap<>();
    HashMap<Integer, String> ordinalComponentNums = new HashMap<>();
    String [] degreeNames = {"�����", "�����", "������", "�����", "��������"};
    String [] feminineNums = {"����", "��"};
    String [] articles = {"", ""};
    String [] conjunctions = {"", ""};
    String [] endings = {"���", "a", "�", "�", "��", "", ""};
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
        cardinalNums.put(200, "����");
        cardinalNums.put(300, "������");
        cardinalNums.put(400, "���������");
        cardinalNums.put(500, "�'�����");
        cardinalNums.put(600, "�������");
        cardinalNums.put(700, "�����");
        cardinalNums.put(800, "������");
        cardinalNums.put(900, "���'�����");


        ordinalNums.put(1, "������");
        ordinalNums.put(2, "������");
        ordinalNums.put(3, "�����");
        ordinalNums.put(4, "���������");
        ordinalNums.put(5, "�'����");
        ordinalNums.put(6, "������");
        ordinalNums.put(7, "������");
        ordinalNums.put(8, "�������");
        ordinalNums.put(9, "���'����");
        ordinalNums.put(10, "�������");
        ordinalNums.put(11, "�����������");
        ordinalNums.put(12, "�����������");
        ordinalNums.put(13, "�����������");
        ordinalNums.put(14, "�������������");
        ordinalNums.put(15, "�'����������");
        ordinalNums.put(16, "������������");
        ordinalNums.put(17, "����������");
        ordinalNums.put(18, "�����������");
        ordinalNums.put(19, "���'����������");
        ordinalNums.put(20, "���������");
        ordinalNums.put(30, "���������");
        ordinalNums.put(40, "���������");
        ordinalNums.put(50, "�'���������");
        ordinalNums.put(60, "�����������");
        ordinalNums.put(70, "���������");
        ordinalNums.put(80, "����������");
        ordinalNums.put(90, "���'�������");
        ordinalNums.put(100, "�����");

        ordinalComponentNums.put(1, "����");
        ordinalComponentNums.put(2, "����");
        ordinalComponentNums.put(3, "�����");
        ordinalComponentNums.put(4, "��������");
        ordinalComponentNums.put(5, "�'���");
        ordinalComponentNums.put(6, "�����");
        ordinalComponentNums.put(7, "����");
        ordinalComponentNums.put(8, "������");
        ordinalComponentNums.put(9, "���'���");
        ordinalComponentNums.put(10, "������");
        ordinalComponentNums.put(11, "����������");
        ordinalComponentNums.put(12, "����������");
        ordinalComponentNums.put(13, "����������");
        ordinalComponentNums.put(14, "������������");
        ordinalComponentNums.put(15, "�'���������");
        ordinalComponentNums.put(16, "�����������");
        ordinalComponentNums.put(17, "���������");
        ordinalComponentNums.put(18, "����������");
        ordinalComponentNums.put(19, "���'���������");
        ordinalComponentNums.put(20, "��������");
        ordinalComponentNums.put(30, "��������");
        ordinalComponentNums.put(40, "������");
        ordinalComponentNums.put(50, "����������");
        ordinalComponentNums.put(60, "�����������");
        ordinalComponentNums.put(70, "����������");
        ordinalComponentNums.put(80, "������������");
        ordinalComponentNums.put(90, "���'������");

    }
}
