package src;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RoleSelectionSave {

    String select_role(Scanner userInput)
    {
        String role_sel;

        System.out.println("Student Grade Prisim\n\n");

        System.out.println("+--------------------+----------+");
        System.out.println("|  TEACHER           |    T     |");
        System.out.println("|  STUDENT           |    S     |");
        System.out.println("|  EXIT              |    E     |");
        System.out.println("+--------------------+----------+");

        System.out.print("Log in as: ");
        role_sel = userInput.nextLine().trim().toUpperCase();

        switch (role_sel)
        {
            case "T", "S", "E" -> {
                return role_sel;
            }
            default ->
            {
                return "0";
            }
        }
    }

    void RoleAsTeacher(Scanner userInput)
    {
        DataVerifier dataVerifier = new DataVerifier();
        String user_choose;
        boolean loop_con = true;
        do
        {
            System.out.print("Already have a teacher account (Y/N): ");
            user_choose = userInput.nextLine().toUpperCase().trim();

            if (user_choose.equals("Y"))
            {
                System.out.println("The teacher have a account already");
                String[] data = LogInAsTeacher(userInput);
                dataVerifier.checkTeacherAcc(data[0], data[1]);
                break;

            }
            else if (user_choose.equals("N"))
            {
                System.out.println("The teacher don't have account");
                String[] data = setupTeacherAcc(userInput);
                dataVerifier.addTeacherAcc(data[0], data[1]);
                break;
            }
            else
            {
                System.out.println("Invalid Keyword");
            }
        }while (loop_con);
    }

    String[] setupTeacherAcc(Scanner userInput)
    {
        InputChecker input_check = new InputChecker();

        String T_first_name = input_check.InputString("First name: ", userInput);
        String T_middle_name = input_check.InputString("Middle name: ", userInput);
        String T_last_name = input_check.InputString("Last name: ", userInput);
        String T_ID = input_check.InputID("Identification: ", 8 ,userInput);

        String complete_name = T_last_name + ", " + T_first_name + " " + T_middle_name;
        String T_titleCase_complete_name = input_check.toTitleCase(complete_name);
        return new String[]{T_titleCase_complete_name, T_ID};
    }

    String[] LogInAsTeacher(Scanner userInput)
    {
        System.out.print("Email: ");
        String T_email = userInput.nextLine();
        System.out.print("Password: ");
        String T_password = userInput.nextLine();
        return new String[]{T_email, T_password};
    }

    void RoleAsStudent()
    {

    }
}
