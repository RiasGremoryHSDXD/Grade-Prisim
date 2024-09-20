package src;

import java.util.*;


public class MainMenu {
    public static void main(String[] args)
    {
        Scanner call_scanner = new Scanner(System.in);
        RoleSelection role = new RoleSelection();

        while (true)
        {
            String userRole = role.setRole_select(call_scanner);

            switch (userRole) {
                case "T" -> role.userIsTeacher(call_scanner);
                case "S" -> System.out.println("Log in as Student");
                case "E" ->
                {
                    System.out.println("Exit");
                    System.exit(0);
                }
                default -> System.out.println("Invalid Keyword");
            }
        }
    }
}
