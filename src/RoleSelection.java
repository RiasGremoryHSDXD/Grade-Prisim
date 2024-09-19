package src;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RoleSelection {

    String select_role(Scanner userInput)
    {
        String role_sel;

        System.out.println("Student Grade Prisim\n\n");


        System.out.println("+--------------------+----------+");
        System.out.println("|  TEACHER           |    T     |");
        System.out.println("|  STUDENT           |    S     |");
        System.out.println("|  EXIT              |    E     |");
        System.out.println("+--------------------+----------+");

        while (true)
        {
            System.out.print("Log in as: ");
            role_sel = userInput.nextLine().trim().toUpperCase();

            switch (role_sel)
            {
                case "T":
                    System.out.println("Log in as teacher");
                    return role_sel;

                case "S":
                    System.out.println("Log in as Student");
                    return role_sel;

                case "E":
                    System.out.println("Exit");
                    return role_sel;

                default:
                    System.out.println("Invalid Input");
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
            }
            else if (user_choose.equals("N"))
            {
                System.out.println("The teacher don't have account");
                String[] data = setupTeacherAcc(userInput);
                dataVerifier.addTeacherAcc(data[0], data[1]);
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
        String T_ID = input_check.InputID("Identification: ", userInput);

        String complete_name = T_last_name + ", " + T_first_name + " " + T_middle_name;
        String T_titleCase_complete_name = input_check.toTitleCase(complete_name);
        return new String[]{T_titleCase_complete_name, T_ID};
    }

    void RoleAsStudent()
    {

    }
}
