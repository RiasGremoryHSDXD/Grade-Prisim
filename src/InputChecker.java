package src;

import java.util.Scanner;

public class InputChecker
{

    public String InputString(String inputInstruction, Scanner userInput)
    {
        String strTemStore;
        do
        {
            System.out.print(inputInstruction);
            strTemStore = userInput.nextLine().trim();

            if(!isLetter(strTemStore))
            {
                System.out.println("Invalid input, Try again.");
            }

        }while (!isLetter(strTemStore));
        return strTemStore;
    }


    public String InputID(String inputInstruction, int limit_digit,Scanner userInput)
    {
        String intTemStore;
        while (true)
        {
            System.out.print(inputInstruction);
            intTemStore = userInput.nextLine();

            if(isNumber(intTemStore) && intTemStore.length() == limit_digit)
            {
                return intTemStore;
            }
            System.out.println("The student ID must contain exactly 8 digit.");
        }
    }


    public String toTitleCase(String text) {
        text = text.trim();

        text = text.replaceAll("\\s+", " ");

        StringBuilder titleCase = new StringBuilder();
        String[] words = text.split(" ");

        for (String word : words) {
            if (word.length() > 0) {
                String capitalizedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                titleCase.append(capitalizedWord).append(" ");
            }
        }

        return titleCase.toString();
    }

    public boolean isLetter(String letterChecker)
    {
        return letterChecker.matches("[a-zA-Z\\s]+");
    }

    public boolean isNumber(String numberChecker)
    {
        return numberChecker.matches("^\\d+$");
    }

}
