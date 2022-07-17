import java.util.*;

public class Main {

    String outputString;


    public static void main (String [] args) {

            Scanner in = new Scanner(System.in);
            System.out.print("Input a number: ");
            Long inputValue = in.nextLong();
            System.out.printf("Your number: " + transformLongToOrdinalString(inputValue, new English()));
            System.out.printf("Your number: " + transformLongToOrdinalString(inputValue, new Ukrainian()));
            System.out.printf("Your number: " + transformLongToOrdinalString(inputValue, new Deutch()));
            in.close();

    }

    private static String transformLongToOrdinalString(Long inputValue, Language language) {

        int nullCounter = 0;
        boolean degreeDeclension = false;

        //language settings
        String [] degreeNames = language.getDegreeNames();
        HashMap<Integer, String> cardinalNums = language.getCardinalNums();
        HashMap<Integer, String> ordinalNums = language.getOrdinalNums();
        HashMap<Integer, String> ordinalComponentNums = language.getOrdinalComponentNums();


        //int to string array
        String [] strNumbers = inputValue.toString().split("");

        //string to int
        int [] numbers = new int [strNumbers.length];
        for (int i = 0; i < strNumbers.length; i++) {
            numbers[i] = Integer.parseInt(strNumbers[i]);
        }

        //words array
        String [] words = new String[language.getWordCount()];

        //word iterator
        int j = words.length - 1;



        for (int i = numbers.length - 1; i > -1; j--) {




            /** first number =======================================================*/
            if (numbers[i] != 0) {
                if (i != numbers.length - 1)
                    words[j] = cardinalNums.get(numbers[i]);
                if (i == numbers.length - 1)
                    words[j] = ordinalNums.get(numbers[i]);
                if (degreeDeclension && ordinalComponentNums.containsKey(numbers[i])) {
                    words[j] = ordinalComponentNums.get(numbers[i]);
                }
                if (i == numbers.length - 4 && !degreeDeclension && !language.getFeminineNums()[0].isEmpty()) {
                    if (numbers[i] == 1)
                        words[j] = language.getFeminineNums()[0];
                    if (numbers[i] == 2)
                        words[j] = language.getFeminineNums()[1];
                }
            } else {
                nullCounter++;
            }
            i--;
            j--;




            if (i == -1)
                break;
            /** second number =======================================================*/
            if (numbers[i] != 0) {
                if (numbers[i] == 1) {
                    words[j + 1] = null;
                    words[j] = ordinalNums.get(numbers[i + 1] + 10);
                } else {
                    if (numbers[i + 1] == 0) {
                        words[j] = cardinalNums.get(numbers[i] * 10);
                        if (i == numbers.length - 2)
                            words[j] = ordinalNums.get(numbers[i] * 10);
                    }
                    if (numbers[i + 1] > 0)
                        words[j] = cardinalNums.get(numbers[i] * 10) + (language.getConjunctions())[1];

                }
                if (degreeDeclension && ordinalComponentNums.containsKey(numbers[i] * 10)) {
                    words[j] = ordinalComponentNums.get(numbers[i] * 10);
                }

            } else {
                nullCounter++;
            }
            i--;
            j--;




            if (i == -1)
                break;
            /** third number =======================================================*/
            if (numbers[i] != 0) {
                if (!language.isTwoWordHundreds()) {
                    words[j] = cardinalNums.get(numbers[i] * 100);
                } else {
                    words[j] = cardinalNums.get(numbers[i]) + " " + cardinalNums.get(100);
                    if (i == numbers.length - 3 && nullCounter == 2)
                        words[j] += language.getEndings()[0];
                }

                //conjunctions
                if (numbers[i + 1] !=0 || numbers[i + 2] != 0) {
                    words[j] += (language.getConjunctions())[0];
                }

                //ordinal hundreds handling ????????
                if (ordinalComponentNums.containsKey(numbers[i]) && i == numbers.length - 3 && nullCounter == 2) {
                    if (numbers[i] != 1) {
                        words[j] = ordinalComponentNums.get(numbers[i]) + ordinalNums.get(100);
                    } else {
                        words[j] = ordinalNums.get(100);
                    }
                }
            } else {
                nullCounter++;
            }
            i--;
            j--;




            if (i == -1)
                break;
            /** next trinity check =======================================================*/
            degreeDeclension = false;
            for (int k = 0; k < 3; k++) {
                if (i - k >= 0 && numbers[i - k] != 0) {
                    int degreeNamesNum = ((language.getWordCount() - j) / language.getWordLoopSize()) - 1;
                    words[j] = degreeNames[degreeNamesNum];

                    //degree name handling
                    if ((degreeNamesNum + 1) == nullCounter / 3) {
                        words[j] = degreeNames[degreeNamesNum] + language.getEndings()[0];
                        degreeDeclension = true;
                    } else {
                        if (i == numbers.length - 4 && numbers[i] == 1)
                            words[j] += language.getEndings()[1];
                        if (i == numbers.length - 4 && numbers[i] >= 2 && numbers[i] <= 4)
                            words[j] += language.getEndings()[2];
                        if (i < numbers.length - 4 && numbers[i] >= 2 && numbers[i] <= 4)
                            words[j] += language.getEndings()[3];
                        if (i < numbers.length - 4 && numbers[i] >= 5)
                            words[j] += language.getEndings()[4];
                    }

                    //thousand "and"
                    if (j == 21 && numbers [i + 1] == 0 && (numbers[i + 2] != 0 || numbers[i + 3] != 0)) {
                        words[j] += language.getConjunctions()[0];
                    }
                    break;
                }
            }
        }

        //removing null elements
        List<String> wordsWithoutNull = new ArrayList<>();
        for(String word : words) {
            if (word != null)
                wordsWithoutNull.add(word);
        }

        //printing result
        String result = "";
        //Collections.reverse(wordsWithoutNull);
        for(String word : wordsWithoutNull) {
            result += " " + word;
        }

        return result += "\n";
    }

}
