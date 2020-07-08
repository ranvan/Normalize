public class Normalize {

    public static String toCamelCase(String string) {
        boolean isPrevLowerCase = false;  // указывает на регистр предыдущего символа
        boolean isNextUpperCase = false;  // указывает на регистр следующего символа

        String regex = "[^0-9a-zA-Z ]";   // регулярное выражение для исключения всех символом кроме латинских (верхний и нижний регистры), цифр и пробела
        String stringAfterRegex = string.replaceAll(regex, " ");

        StringBuilder result = new StringBuilder();                      // isLetterOrDigit(char ch) - определяет, является ли символ буквой или цифрой.
        // В принципе, с этим методом, применять регулярку нет смысла,
        for (int i = 0; i < stringAfterRegex.length(); i++) {            // но раз уж я начал показывать решение через регулярку, то не стал исключать из решения фильтрацию исходной строки
            char currentChar = stringAfterRegex.charAt(i);
            if(Character.isLetterOrDigit(currentChar)) {
                result.append(isNextUpperCase ? Character.toUpperCase(currentChar) :
                        isPrevLowerCase ? currentChar : Character.toLowerCase(currentChar));
                isNextUpperCase = false;
            } else {
                isNextUpperCase = result.length() > 0 || isNextUpperCase;
            }
            isPrevLowerCase = result.length() > 0 && Character.isLowerCase(currentChar);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(Normalize.toCamelCase("-CSharp/Case1_case"));
    }
}
