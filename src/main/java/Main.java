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

        //language settings
        String [] degreeNames = language.getDegreeNames();
        HashMap<Integer, String> cardinalNums = language.getCardinalNums();
        HashMap<Integer, String> ordinalNums = language.getOrdinalNums();

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

            // first number
            if (numbers[i] != 0) {
                if (i != numbers.length - 1)
                    words[j] = cardinalNums.get(numbers[i]);
                if (i == numbers.length - 1)
                    words[j] = ordinalNums.get(numbers[i]);
            }
            i--;
            j--;

            if (i == -1)
                break;
            // second number
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
            }
            i--;
            j--;

            if (i == -1)
                break;
            // third number
            if (numbers[i] != 0) {
                if (cardinalNums.containsKey(numbers[i] * 100)) {
                    words[j] = cardinalNums.get(numbers[i] * 100);
                } else
                    words[j] = cardinalNums.get(numbers[i]) + " " + cardinalNums.get(100);
                //conjunctions
                if (numbers[i + 1] !=0 || numbers[i + 2] != 0) {
                    words[j] += (language.getConjunctions())[0];
                }

                //ordinal hundreds handling
                if (i == numbers.length - 3 && numbers[i + 1] == 0 && numbers[i + 2] == 0) {
                    if (ordinalNums.containsKey(numbers[i] * 100)) {
                        words[j] = ordinalNums.get(numbers[i] * 100);
                    } else {
                        words[j] += language.getEndings()[0];
                    }
                }
            }
            i--;
            j--;

            if (i == -1)
                break;
            //next trinity check
            for (int k = 0; k < 3; k++) {
                if (i - k >= 0 && numbers[i - k] != 0) {
                    words[j] = degreeNames[((language.getWordCount() - j) / language.getWordLoopSize()) - 1];
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
