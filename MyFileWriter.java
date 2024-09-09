import java.io.*;

public class MyFileWriter {
    public static void main(String[] args) {
        String password = "helloworld1235";
        String data = "blorg";
        String hiddenFileName = ".supersecretexample.txt";
        String hiddenDirectoryName = ".confidential";
        String extraHiddenFileName = ".classified.gat";

        // BufferedOutputStream
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                new FileOutputStream(hiddenFileName))) {
            bufferedOutputStream.write(password.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        File hiddenDirectory = new File(hiddenDirectoryName);
        if (!hiddenDirectory.exists())
            hiddenDirectory.mkdir();

        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                new FileOutputStream(new File(hiddenDirectory, extraHiddenFileName)))) {
            bufferedOutputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        printFileSize(hiddenFileName);
    }

    // Calculate and print the file size using the File class
    private static void printFileSize(String fileName) {
        File file = new File(fileName);
        System.out.println(file.length());
    }
}