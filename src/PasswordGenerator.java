import java.util.Random;

public class PasswordGenerator {

    public String generatePassword(boolean isLowerChar, boolean isUpperChar, boolean isDigitChar, boolean isSpecialChar, int length) {
        Random rnd = new Random();
        String symbols = "~`!@#$%^&*()_-+={[}]|\\:;\"'<,>.?/";
        StringBuilder password = new StringBuilder();

        if(!isLowerChar && !isUpperChar && !isDigitChar && !isSpecialChar) {
            return "Choose characters for password.";
        }

        for (int i = 0; i < length; i++) {
            int random = rnd.nextInt(4);
            if (random == 0) {
                if (isLowerChar) {
                    char letter = (char) (rnd.nextInt('z' - 'a' + 1) + 'a');
                    password.append(letter);
                } else {
                    i--;
                }
            } else if (random == 1) {
                if (isUpperChar) {
                    char letter = (char) (rnd.nextInt('Z' - 'A' + 1) + 'A');
                    password.append(letter);
                } else {
                    i--;
                }
            } else if (random == 2) {
                if (isDigitChar) {
                    char number = (char) (rnd.nextInt(10) + '0');
                    password.append(number);
                } else {
                    i--;
                }
            } else {
                if (isSpecialChar) {
                    char symbol = symbols.charAt(rnd.nextInt(symbols.length()));
                    password.append(symbol);
                } else {
                    i--;
                }
            }
        }
        return password.toString();
    }
}
