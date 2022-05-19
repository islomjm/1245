package ij;

import java.util.InputMismatchException;

class TestCalc extends RomanArabianCalc {
    public static void main(String[] args) {
        System.out.println("Введите число, например (2+2) или (V+V)");
        String userInput = scanner.nextLine();
        char[] line = new char[10];
        for (int i = 0; i < userInput.length(); i++) {
            line[i] = userInput.charAt(i);
            if (line[i] == '+') {
                operation = '+';
            }
            if (line[i] == '-') {
                operation = '-';
            }
            if (line[i] == '*') {
                operation = '*';
            }
            if (line[i] == '/') {
                operation = '/';
            }
        }
        String under_charString = String.valueOf(line);
        String[] blacks = under_charString.split("[+-/*]");
        String stable00 = blacks[0];
        String stable01 = blacks[1];
        String string03 = stable01.trim();

        String[] s1 = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (String s : s1) {
            if (s.equals(stable00)) {
                flag1 = true;
                break;
            }
        }
        for (String s : s1) {
            if (s.equals(string03)) {
                flaq2 = true;
                break;
            }
        }
        if (flag1 && flaq2) {
            num1 = romanToNumber(stable00);
            num2 = romanToNumber(string03);
            if (num1 < 0 || num2 < 0) {
                throw new ArithmeticException();
            } else {
                result = calculate(num1, num2, operation);
                String resultRoman = convertArabToRoman(result);
                if (resultRoman.equals("O")) {
                    throw new ArithmeticException();
                }
                System.out.println("Результат для римских цифр:");
                System.out.println(resultRoman);
            }

        } else {

            num1 = Integer.parseInt(stable00);
            num2 = Integer.parseInt(string03);
            if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
                throw new IllegalArgumentException();
            } else {
                result = calculate(num1, num2, operation);
                System.out.println("Результат для арабских цифр:");
                System.out.println(result);
            }
        }
    }

    public static int calculate(int num1, int num2, char operation) {
        int result = 0;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    break;
                }
                break;

            default:
                throw new IllegalArgumentException();
        }
        return result;
    }

    public static String convertArabToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        return roman[numArabian];
    }


    public static int romanToNumber(String roman) {
        try {
            switch (roman) {
                case "I":
                    return 1;
                case "II":
                    return 2;
                case "III":
                    return 3;
                case "IV":
                    return 4;
                case "V":
                    return 5;
                case "VI":
                    return 6;
                case "VII":
                    return 7;
                case "VIII":
                    return 8;
                case "IX":
                    return 9;
                case "X":
                    return 10;
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
        return -1;
    }
}