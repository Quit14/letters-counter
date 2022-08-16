import java.util.HashMap;
import java.util.Map;

public class Main {
    static final String TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {
        Map<Character, Integer> charsNum = new HashMap<>(createMap(delSymbols(TEXT)));
        maxCh(charsNum);
        minCh(charsNum);

    }


static Map<Character,Integer> createMap (String txt) { //заводим мапу буква - количество использований
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < txt.length(); i++) {
        if (map.get(txt.charAt(i)) == null) {
            map.put(txt.charAt(i), 1);
        } else {
            int val = map.get(txt.charAt(i)) + 1;
            map.put(txt.charAt(i), val);
        }
    }
    return map;
}

    static void maxCh (Map<Character, Integer> ch) {
        char maxCh = 0;
        int maxChNum = Integer.MIN_VALUE;
        for (Map.Entry <Character, Integer> kv : ch.entrySet()) {
            if (kv.getValue() > maxChNum) {
                maxChNum = kv.getValue();
                maxCh = kv.getKey();
            }
        }
        System.out.println("В этом тексте чаще всего встречается символ: " + maxCh + ". Всего - " + maxChNum + " раз" + addA(maxChNum) + ".");
    }

    static void minCh (Map<Character, Integer> ch) {
        char minCh = 0;
        int minChNum = Integer.MAX_VALUE;
        for (Map.Entry <Character, Integer> kv : ch.entrySet()) {
            if (kv.getValue() < minChNum) {
                minChNum = kv.getValue();
                minCh = kv.getKey();
            }
        }
        System.out.println("В этом тексте реже всего встречается символ: " + minCh + ". Всего - " + minChNum + " раз" + addA(minChNum) + ".");
    }
    static String addA(int split) {
        int split100 = split % 100;
        int split10 = split % 10;
        return (split100 <= 10 || split100 >= 20) && split10 >= 2 && split10 <= 4 ? "а" : "";
    }
    static String delSymbols (String text) {
        StringBuilder textNoMarks = new StringBuilder();
        String textLowerCase = text.toLowerCase(); //приводим текст к нижнему регистру
        for (char ch : textLowerCase.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) { //удаляем из текста всё кроме букв и цифр
                textNoMarks.append(ch);
            }
        }
        return textNoMarks.toString();
    }
}
