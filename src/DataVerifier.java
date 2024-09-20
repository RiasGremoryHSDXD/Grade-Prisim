package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataVerifier {
    void addTeacherAcc(String T_name, String T_id)
    {
        String file_path = "src/Teacher_DB";

        if(isTeacherExist(file_path, T_name, T_id))
        {
            System.out.println("The teacher name or ID already exist.");
        }
        else
        {
            try (FileWriter write_data = new FileWriter(file_path, true))
            {
                write_data.write(T_name + " " + T_id + "\n");
                System.out.println("Successfully Create Account");
            }
            catch (Exception e)
            {}
        }
    }

    void checkTeacherAcc(String T_email, String T_password)
    {
        String file_path = "src/Teacher_DB";

        if(!T_email.equals(T_password))
        {
            System.out.println("Invalid Authentication");
        }
        else
        {
            if(TeacherAuthentication(file_path, T_email))
            {
                System.out.println("Teacher Account Exist");
            }
            else
            {
                System.out.println("Invalid Authentication");
            }
        }
    }

    private boolean isTeacherExist(String file_path, String T_name, String T_id)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(file_path)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                if(line.contains(T_name) || line.contains(T_id))
                {
                    return true;
                }
            }
        }catch (IOException e)
        {}
        return false;
    }

    private boolean TeacherAuthentication(String file_path, String T_email)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(file_path))){
            String line;
            while ((line = reader.readLine()) != null)
            {
                if (line.contains(T_email))
                {
                    return true;
                }
            }
        }
        catch (IOException e)
        {}
        return false;
    }
}
