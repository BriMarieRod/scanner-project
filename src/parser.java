import java.io.FileReader;
import java.io.IOException;


public class parser {
    public static void main(String args[]) {
        //TODO
        Scanner sc = new Scanner();

        Scanner.Graph gra = new Scanner.Graph();

        String output="";
        try (FileReader fr = new FileReader("test text.txt")) {
            int content;
            if((content = fr.read()) != -1) {
                output =  sc.scan(fr,content, gra.start, gra, output);
            }
        }catch(IOException e){System.out.println("file not found");}
        //call scan until end of file is reached
        System.out.println(output);



    }
}
