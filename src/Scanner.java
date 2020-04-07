import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Scanner {

  public static void main(String args[]) {
    //TODO
    //get file input
    File file = new File(args[0]);
    Scanner sc = new Scanner();

    sc.scan(file);
    //call scan until end of file is reached

  }

  public void scan(File file) {
    //TODO
    Node graphPoint = null;
    try(FileReader fr = new FileReader(file)){
      int content;
      if((content = fr.read()) != -1){
        System.out.print((char) content);//just a test for now
      }
    }catch(IOException e){}

  }

  class Graph {
    //TODO

    //set up all the nodes and links here

    Node node1 = new Node(false,5);
    Node node2 = new Node(false,3);





  }

}
