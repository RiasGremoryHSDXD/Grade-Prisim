package src;

import java.util.*;


public class MainMenu {
    public static void main(String[] args)
    {
        Scanner call_scanner = new Scanner(System.in);
        RoleSelection role = new RoleSelection();

        String[] T_info = {"", ""};

        String userRole = role.select_role(call_scanner);

        if (userRole.equals("T"))
        {
            role.RoleAsTeacher(call_scanner);
        }
        else if (userRole.equals("S"))
        {

        }
        else
        {

        }
    }
}
