package ce204_hw3_app;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunAndCompile {
    public void file_create(String class_name, String text_area, String codeLanguage_Extention) {
        try {
            // Create a file object with the provided class name and extension
            File myObj = new File(class_name + codeLanguage_Extention);
            
            // Create a FileWriter object to write the text area content to the file
            FileWriter myWriter = new FileWriter(class_name + codeLanguage_Extention);
            myWriter.write(text_area);
            myWriter.close();
            
            if (myObj.createNewFile()) {
                // The file was successfully created
                System.out.println("File created: " + myObj.getName());
            } else {
                // The file already exists
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            // An error occurred while creating or writing to the file
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void compiler(String class_name, String codeLanguage_Extention) {
        ProcessBuilder processBuilder = new ProcessBuilder();
        System.out.println(System.getProperty("user.dir"));

        if (codeLanguage_Extention.equals(".java")) {
            // If the code language extension is ".java", compile the Java source file using "javac" command
            processBuilder.command("cmd.exe", "/c", "javac " + class_name + codeLanguage_Extention);
        } else if (codeLanguage_Extention.equals(".cpp")) {
            // If the code language extension is ".cpp", compile the C++ source file using "g++" command
            processBuilder.command("cmd.exe", "/c", "g++ " + class_name + codeLanguage_Extention + " -o " + class_name);
        } else if (codeLanguage_Extention.equals(".cs")) {
            // If the code language extension is ".cs", compile the C# source file using "csc" command
            processBuilder.command("cmd.exe", "/c", "csc " + class_name + codeLanguage_Extention);
            System.out.println("Worked");
        }

        try {
            // Start the compilation process
            Process process = processBuilder.start();

            // Read the output from the process and print it
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the process to complete and get the exit code
            int exitCode = process.waitFor();
            System.out.println("\nExited with error code: " + exitCode);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void runner(String class_name, String codeExtention_String) {
        Runtime rt = Runtime.getRuntime();
        try {
            // Execute the appropriate command based on the code extension
            if (codeExtention_String.equals(".java")) {
                // If the code extension is ".java", execute the Java program using "java" command
                rt.exec("cmd.exe /c start cmd.exe /k \"java " + class_name);
            } else if (codeExtention_String.equals(".cpp")) {
                // If the code extension is ".cpp", execute the C++ program using its executable
                rt.exec("cmd.exe /c start cmd.exe /k \"" + class_name + ".exe");
            } else if (codeExtention_String.equals(".cs")) {
                // If the code extension is ".cs", execute the C# program using its executable
                rt.exec("cmd.exe /c start cmd.exe /k \"" + class_name + ".exe");
            }
        } catch (IOException e) {
            // An error occurred while executing the program
            e.printStackTrace();
        }
    }

	}
