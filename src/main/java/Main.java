import java.util.*;

public class Main {

    String outputString;


    public static void main (String [] args) {
        callUserInterface();
    }

    private static void callUserInterface() {
        Long [] nums = {1L, 11L, 21L, 50L, 101L, 202L, 134L, 555L, 1000L, 12101L, 21000L, 21105L, 22105L, 25105L, 115103L, 234205L, 1000000L, 102000000L, 121000000L};

        for (Long num: nums) {
            Scanner in = new Scanner(System.in);
            //System.out.print("Input a number: ");
            Long inputValue = num;//in.nextLong();
            System.out.printf("Your number: " + transformLongToOrdinalString(inputValue, new English()));
            System.out.printf("Your number: " + transformLongToOrdinalString(inputValue, new Ukrainian()));
            System.out.printf("Your number: " + transformLongToOrdinalString(inputValue, new German()) + "\n");
            in.close();
        }
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

        int degreeNamesNum = -1;

        for (int i = numbers.length - 1; i > -1; j--) {




            /** first number =======================================================*/
            if (numbers[i] != 0) {
                //general algorithm
                if (i != numbers.length - 1)
                    words[j] = cardinalNums.get(numbers[i]);
                if (i == numbers.length - 1)
                    words[j] = ordinalNums.get(numbers[i]);
                if (degreeDeclension && ordinalComponentNums.containsKey(numbers[i])) {
                    words[j] = ordinalComponentNums.get(numbers[i]);
                }
                // handling declension (ukrainian)
                if (i == numbers.length - 4 && !degreeDeclension && !language.getFeminineNums()[0].isEmpty()) {
                    if (numbers[i] == 1)
                        words[j] = language.getFeminineNums()[0];
                    if (numbers[i] == 2)
                        words[j] = language.getFeminineNums()[1];
                }
                // handling word reverse (deutch)
                if (language.isDoubleDigitReverse()) {
                    if (numbers.length == 1) {
                        words[j] = ordinalNums.get(numbers[i]);
                    } else {
                        words[j] = cardinalNums.get(numbers[i]);
                        if (i == numbers.length - 1 && numbers[i - 1] == 0)
                            words[j] = ordinalNums.get(numbers[i]);
                        if (i != 0 && numbers[i - 1] != 0)
                            words[j] += language.getConjunctions()[0];
                    }
                }
                if ((degreeNamesNum + 1) == nullCounter / 3 && numbers[i] == 1 && i == 0) {
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
            if (numbers[i] != 0) {
                //general algorithm
                if (numbers[i] == 1) {
                    words[j + 1] = null;
                    if (i == numbers.length - 2) {
                        words[j] = ordinalNums.get(numbers[i + 1] + 10);
                    } else {
                        words[j] = cardinalNums.get(numbers[i + 1] + 10);
                    }
                } else {
                    if (numbers[i + 1] == 0) {
                        words[j] = cardinalNums.get(numbers[i] * 10);
                        if (i == numbers.length - 2)
                            words[j] = ordinalNums.get(numbers[i] * 10);
                    }
                    if (numbers[i + 1] > 0)
                        words[j] = cardinalNums.get(numbers[i] * 10) + (language.getConjunctions())[1];

                }
                // handling declension (ukrainian)
                if (degreeDeclension && ordinalComponentNums.containsKey(numbers[i] * 10)) {
                    words[j] = ordinalComponentNums.get(numbers[i] * 10);
                }

                // handling word reverse (deutch)
                if (language.isDoubleDigitReverse()) {
                    String buffer = words[j + 1];
                    if (numbers[i + 1] == 0 || numbers[i] == 1) {
                        words[j + 1] = words[j];
                    } else {
                        words[j + 1] = words[j] + language.getEndings()[0];
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
            if (numbers[i] != 0) {
                //general algorithm
                if (!language.isTwoWordHundreds()) {
                    words[j] = cardinalNums.get(numbers[i] * 100);
                } else {
                    words[j] = cardinalNums.get(numbers[i]) + " " + cardinalNums.get(100);
                    if (i == numbers.length - 3 && nullCounter == 2)
                        words[j] += language.getEndings()[0];
                }

                //conjunctions (english)
                if (!language.isDoubleDigitReverse() && (numbers[i + 1] !=0 || numbers[i + 2] != 0)) {
                    words[j] += (language.getConjunctions())[0];
                }

                //ordinal hundreds handling (ukrainian)
                if (ordinalComponentNums.containsKey(numbers[i]) && i == numbers.length - 3 && nullCounter == 2) {
                    if (numbers[i] != 1) {
                        words[j] = ordinalComponentNums.get(numbers[i]) + ordinalNums.get(100);
                    } else {
                        words[j] = ordinalNums.get(100);
                    }
                }

                if (language.isDoubleDigitReverse()) {
                    if (numbers[i] == 1)
                        words[j] = cardinalNums.get(numbers[i]) + cardinalNums.get(100);
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
                    degreeNamesNum = ((language.getWordCount() - j) / language.getWordLoopSize()) - 1;
                    words[j] = degreeNames[degreeNamesNum];

                    //degree name handling
                    if ((degreeNamesNum + 1) == nullCounter / 3) {
                        words[j] = degreeNames[degreeNamesNum] + language.getEndings()[0];
                        degreeDeclension = true;
                    } else {
                        if ( numbers.length > 4 && numbers[i - 1] == 1) {
                            words[j] += language.getEndings()[5];
                        } else {
                            if (i == numbers.length - 4 && numbers[i] == 1)
                                words[j] += language.getEndings()[1];
                            if (i == numbers.length - 4 && numbers[i] >= 2 && numbers[i] <= 4)
                                words[j] += language.getEndings()[2];
                        }

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
