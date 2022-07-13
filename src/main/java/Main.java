import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    String outputString;


    public static void main (String [] args) {

            Scanner in = new Scanner(System.in);
            System.out.print("Input a number: ");
            Long inputValue = in.nextLong();
            System.out.printf("Your number: " + transformLongToOrdinalString(inputValue, new English()));
            in.close();

    }

    private static String transformLongToOrdinalString(Long inputValue, Language language) {

        //language settings
        String [] degreeNames = language.getDegreeNames();
        HashMap<Integer, String> cardinalNums = language.getCardinalNums();

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
                words[j] = cardinalNums.get(numbers[i]);
            }
            i--;
            j--;

            if (i == -1)
                break;
            // second number
            if (numbers[i] != 0) {
                if (numbers[i] == 1) {
                    words[j + 1] = null;
                    if (numbers[i + 1] == 0)
                        words[j] = cardinalNums.get(10);
                    if (numbers[i + 1] == 1)
                        words[j] = cardinalNums.get(11);
                    if (numbers[i + 1] == 2)
                        words[j] = cardinalNums.get(12);
                    if (numbers[i + 1] > 2)
                        words[j] = cardinalNums.get(numbers[i + 1])  + "teen";
                } else {
                    if (numbers[i + 1] == 0)
                        words[j] = cardinalNums.get(numbers[i] * 10);
                    if (numbers[i + 1] > 0)
                        words[j] = cardinalNums.get(numbers[i] * 10) + "-";
                }
            }
            i--;
            j--;

            if (i == -1)
                break;
            // third number
            if (numbers[i] != 0) {
                words[j - 1] = cardinalNums.get(numbers[i]);
                words[j] = cardinalNums.get(100);
                if (numbers[i + 1] !=0 || numbers[i + 2] != 0) {
                    words[j] += " and";
                }
            }
            i--;
            j -= 2;

            if (i == -1)
                break;
            //next trinity check
            for (int k = 0; k < 3; k++) {
                if (i - k >= 0 && numbers[i - k] != 0) {
                    words[j] = degreeNames[((language.getWordCount() - j) / 5) - 1];
                    //thousand "and"
                    if (j == 21 && numbers [i + 1] == 0 && (numbers[i + 2] != 0 || numbers[i + 3] != 0)) {
                        words[j] += " and";
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


        //finding the last digit of number
        int numberOfTheLastDigit = 0;
        for (int i = numbers.length - 1; i > -1; i--) {
            if (numberOfTheLastDigit == 4)
                numberOfTheLastDigit = 1;
            if (numbers[i] == 0) {
                numberOfTheLastDigit++;
            } else {
                break;
            }
        }
        System.out.println("nold" + numberOfTheLastDigit);

        //ending handle
        //0
        if (numberOfTheLastDigit == 0) {
            if (numbers.length > 1 && numbers[numbers.length - 2] == 1) {
                wordsWithoutNull.add(wordsWithoutNull.get(wordsWithoutNull.size() - 1) + "th");
                wordsWithoutNull.remove(wordsWithoutNull.size() - 2);
            } else {
                switch (numbers[numbers.length - 1]) {
                    case 1:
                        wordsWithoutNull.add("first");
                        wordsWithoutNull.remove(wordsWithoutNull.size() - 2);
                        break;
                    case 2:
                        wordsWithoutNull.add("second");
                        wordsWithoutNull.remove(wordsWithoutNull.size() - 2);
                        break;
                    case 3:
                        wordsWithoutNull.add("third");
                        wordsWithoutNull.remove(wordsWithoutNull.size() - 2);
                        break;
                    case 5:
                        wordsWithoutNull.add("fifth");
                        wordsWithoutNull.remove(wordsWithoutNull.size() - 2);
                        break;
                }
                if (numbers[numbers.length - 1] == 4 || numbers[numbers.length - 1] > 5) {
                    wordsWithoutNull.add(wordsWithoutNull.get(wordsWithoutNull.size() - 1) + "th");
                    wordsWithoutNull.remove(wordsWithoutNull.size() - 2);
                }
            }
        }
        //1
        if (numberOfTheLastDigit == 1) {
            if (numbers[numbers.length - 2] != 1){
                String newStr = wordsWithoutNull.get(wordsWithoutNull.size() - 1).substring(0, (wordsWithoutNull.get(wordsWithoutNull.size() - 1).length() - 1));
                wordsWithoutNull.add(newStr + "ieth");
                wordsWithoutNull.remove(wordsWithoutNull.size() - 2);
            } else {
                wordsWithoutNull.add(wordsWithoutNull.get(wordsWithoutNull.size() - 1) + "th");
                wordsWithoutNull.remove(wordsWithoutNull.size() - 2);
            }
        }
        //2,3
        if (numberOfTheLastDigit == 2 || numberOfTheLastDigit == 3) {
            wordsWithoutNull.add(wordsWithoutNull.get(wordsWithoutNull.size() - 1) + "th");
            wordsWithoutNull.remove(wordsWithoutNull.size() - 2);
        }

        //printing result
        String result = "";
        for(String word : wordsWithoutNull) {
            result += " " + word;
        }

        return result;
    }

}
