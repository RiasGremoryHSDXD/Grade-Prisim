package src;

import java.util.*;

class RoleSelection
{
    private String role_select;

    RoleSelection()
    {
        this.role_select = "";
    }

    String setRole_select(Scanner userInput)
    {
        System.out.println("Student Grade Prisim\n\n");

        System.out.println("+--------------------+----------+");
        System.out.println("|  TEACHER           |    T     |");
        System.out.println("|  STUDENT           |    S     |");
        System.out.println("|  EXIT              |    E     |");
        System.out.println("+--------------------+----------+");

        System.out.print("Log in as: ");

        this.role_select = userInput.nextLine().toUpperCase().trim();

        switch (this.role_select)
        {
            case "T", "S", "E" ->
            {
                return this.role_select;
            }
            default ->
            {
                return " ";
            }
        }
    }


    void userIsTeacher(Scanner userInput)
    {
        boolean loop_control;
        do {
            loop_control = true;

            System.out.println("+--------------------+----------+");
            System.out.println("|  CREATE ACCOUNT    |     C    |");
            System.out.println("|  HAVE AN ACCOUNT   |     H    |");
            System.out.println("|  BACK              |     B    |");
            System.out.println("+--------------------+----------+");

            System.out.print("Selected option: ");
            String selected_option = userInput.nextLine().toUpperCase().trim();

            switch (selected_option)
            {
                case "C" -> TeacherCreateAccount(userInput);
                case "H" -> TeacherLoginAccount(userInput);
                case "B" -> loop_control = false;
                default ->
                {
                    System.out.println("Invalid Keyword! Try Again.");
                    loop_control = true;
                }
            }
        }while (loop_control);
    }

    void TeacherCreateAccount(Scanner userInput)
    {
        InputChecker inputChecker = new InputChecker();
        DataVerifier dataVerifier = new DataVerifier();

        String T_first_name, T_middle_name, T_last_name, T_ID, T_complete_name;

        T_first_name =  inputChecker.InputString("First name: ", userInput);
        T_middle_name = inputChecker.InputString("Middle name: ", userInput);
        T_last_name = inputChecker.InputString("Last name: ", userInput);
        T_ID = inputChecker.InputID("Identification: ", 8, userInput);
        T_complete_name = inputChecker.toTitleCase(T_last_name + ", " + T_first_name + " " + T_middle_name);

        dataVerifier.addTeacherAcc(T_complete_name, T_ID);
    }

    void TeacherLoginAccount(Scanner userInput)
    {
        String T_email, T_password;

        System.out.print("Email: ");
        T_email = userInput.nextLine();
        System.out.print("Password: ");
        T_password = userInput.nextLine();

        if (T_email.equals(T_password))
        {
            System.out.println("Correct Authentication");
        }
        else
        {
            System.out.println("Invalid Authentication");
        }
    }
}