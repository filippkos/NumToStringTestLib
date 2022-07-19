import java.util.*;

public class Main {

    public static void main(String[] args) {
        callConsole();
    }

    private static void callConsole() {
        Long[] nums = {1L, 11L, 21L, 50L, 101L, 202L, 134L, 555L, 1000L, 1001L, 12101L, 21000L, 21105L, 22105L, 25105L, 115103L, 234205L, 1000000L, 102000000L, 121000000L};

        for (Long num : nums) {
            Scanner in = new Scanner(System.in);
            //System.out.print("Input a number: ");
            Long inputValue = num;//in.nextLong();
            System.out.printf("Your number is: " + transformLongToOrdinalString(inputValue, new English()));
            System.out.printf("Your number is: " + transformLongToOrdinalString(inputValue, new Ukrainian()));
            System.out.printf("Your number is: " + transformLongToOrdinalString(inputValue, new German()) + "\n");
            in.close();
        }
    }

    private static String transformLongToOrdinalString(Long inputValue, Language language) {

        int nullCounter = 0;
        boolean degreeDeclension = false;

        //language settings
        String[] degreeNames = language.getDegreeNames();
        HashMap<Integer, String> cardinalNums = language.getCardinalNums();
        HashMap<Integer, String> ordinalNums = language.getOrdinalNums();
        HashMap<Integer, String> ordinalComponentNums = language.getOrdinalComponentNums();

        //int to string array
        String[] strDigits = inputValue.toString().split("");

        //digits array
        int[] digits = stringArrayToIntArray(strDigits);

        //words array
        String[] words = new String[language.getWordCount()];

        //words iterator
        int j = words.length - 1;

        //degree array iterator
        int degreeNamesNum = -1;

        String spacer = "";
        if (language.isSpacesBetweenWords()) {
            spacer = " ";
        }
        for (int i = digits.length - 1; i > -1; j--) {


            /** first number =======================================================*/
            if (digits[i] != 0) {
                //general algorithm
                if (i != digits.length - 1)
                    words[j] = cardinalNums.get(digits[i]);
                if (i == digits.length - 1)
                    words[j] = ordinalNums.get(digits[i]);
                if (degreeDeclension && ordinalComponentNums.containsKey(digits[i])) {
                    words[j] = ordinalComponentNums.get(digits[i]);
                } else {
                    words[j] += spacer;
                }
                // handling declension (ukrainian)
                if (i == digits.length - 4 && !degreeDeclension && !language.getFeminineNums()[0].isEmpty()) {
                    if (digits[i] == 1)
                        words[j] = language.getFeminineNums()[0];
                    if (digits[i] == 2)
                        words[j] = language.getFeminineNums()[1];
                }
                // handling word reverse (german)
                if (language.isDoubleDigitReverse()) {
                    if (digits.length == 1) {
                        words[j] = ordinalNums.get(digits[i]);
                    } else {
                        words[j] = cardinalNums.get(digits[i]);
                        if (i == digits.length - 1 && digits[i - 1] == 0)
                            words[j] = ordinalNums.get(digits[i]);
                        if (i != 0 && digits[i - 1] != 0)
                            words[j] += language.getConjunctions()[0];
                    }
                }
                if ((degreeNamesNum + 1) == nullCounter / 3 && digits[i] == 1 && digits.length > 1 && i == 0) {
                    words[j] = null;
                }
            } else {
                nullCounter++;
            }
            i--;
            j--;

            if (i == -1)
                break;
            /** second number =======================================================*/
            if (digits[i] != 0) {
                //general algorithm
                if (digits[i] == 1) {
                    words[j + 1] = null;
                    if (i == digits.length - 2) {
                        words[j] = ordinalNums.get(digits[i + 1] + 10);
                    } else {
                        words[j] = cardinalNums.get(digits[i + 1] + 10);
                    }
                } else {
                    if (digits[i + 1] == 0) {
                        words[j] = cardinalNums.get(digits[i] * 10);
                        if (i == digits.length - 2)
                            words[j] = ordinalNums.get(digits[i] * 10);
                    }
                    if (digits[i + 1] > 0)
                        words[j] = cardinalNums.get(digits[i] * 10) + (language.getConjunctions())[1];
                }
                // handling declension (ukrainian)
                if (degreeDeclension && ordinalComponentNums.containsKey(digits[i] * 10)) {
                    words[j] = ordinalComponentNums.get(digits[i] * 10);
                } else {
                    words[j] += spacer;
                }
                // handling word reverse (german)
                if (language.isDoubleDigitReverse()) {
                    String buffer = words[j + 1];
                    if (digits[i + 1] == 0 || digits[i] == 1) {
                        words[j + 1] = words[j];
                    } else {
                        words[j + 1] = words[j];
                        if (i == digits.length - 2) {
                            words[j + 1] += language.getEndings()[0];
                        }
                    }
                    words[j] = buffer;
                }
            } else {
                nullCounter++;
            }
            i--;
            j--;


            if (i == -1)
                break;
            /** third number =======================================================*/
            if (digits[i] != 0) {
                //general algorithm
                if (!language.isTwoWordHundreds()) {
                    words[j] = cardinalNums.get(digits[i] * 100);
                } else {
                    words[j] = cardinalNums.get(digits[i]) + language.getConjunctions()[2] + cardinalNums.get(100);
                    if (i == digits.length - 3 && nullCounter == 2)
                        words[j] += language.getEndings()[0];
                }
                //conjunctions (english)
                if (!language.isDoubleDigitReverse() && (digits[i + 1] != 0 || digits[i + 2] != 0)) {
                    words[j] += language.getConjunctions()[2] + language.getConjunctions()[0];
                }
                //ordinal hundreds handling (ukrainian)
                if (ordinalComponentNums.containsKey(digits[i]) && i == digits.length - 3 && nullCounter == 2) {
                    if (digits[i] != 1) {
                        words[j] = ordinalComponentNums.get(digits[i]) + ordinalNums.get(100);
                    } else {
                        words[j] = ordinalNums.get(100);
                    }
                }
                if (!degreeDeclension) {
                    words[j] += spacer;
                }
                if (language.isDoubleDigitReverse()) {
                    if (digits[i] == 1)
                        words[j] = cardinalNums.get(digits[i]) + cardinalNums.get(100);
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
                if (i - k >= 0 && digits[i - k] != 0) {
                    degreeNamesNum = ((language.getWordCount() - j) / language.getWordLoopSize()) - 1;
                    words[j] = degreeNames[degreeNamesNum];
                    //degree name handling
                    if ((degreeNamesNum + 1) == nullCounter / 3) {
                        words[j] = degreeNames[degreeNamesNum] + language.getEndings()[0];
                        degreeDeclension = true;
                    } else {
                        if (digits.length > 4 && digits[i - 1] == 1) {
                            words[j] += language.getEndings()[5];
                        } else {
                            if (i == digits.length - 4 && digits[i] == 1)
                                words[j] += language.getEndings()[1];
                            if (i == digits.length - 4 && digits[i] >= 2 && digits[i] <= 4)
                                words[j] += language.getEndings()[2];
                        }
                        if (i < digits.length - 4 && digits[i] >= 2 && digits[i] <= 4)
                            words[j] += language.getEndings()[3];
                        if (i < digits.length - 4 && digits[i] >= 5)
                            words[j] += language.getEndings()[4];
                    }
                    words[j] += " ";
                    //thousands conjunctions
                    if (digits[i + 1] == 0 && (digits[i + 2] != 0 || digits[i + 3] != 0)) {
                        words[j] += language.getConjunctions()[0];
                    }
                    if (i != 0)
                        words[j] = language.getConjunctions()[3] + words[j];
                    break;
                }
            }
        }
        return stringFormation(words, language);
    }

    private static int[] stringArrayToIntArray(String[] strDigits) {
        int[] numbers = new int[strDigits.length];
        for (int i = 0; i < strDigits.length; i++) {
            numbers[i] = Integer.parseInt(strDigits[i]);
        }
        return numbers;
    }

    private static String stringFormation(String[] words, Language language) {
        //removing null elements
        List<String> wordsWithoutNull = new ArrayList<>();
        for (String word : words) {
            if (word != null)
                wordsWithoutNull.add(word);
        }

        //string creation
        String result = "";
        for (String word : wordsWithoutNull) {
            result += word + "";
        }
        result = language.getArticles()[0] + language.getConjunctions()[3] + result + "\n";

        return result;
    }

}
