package scanner;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Scanner {

  public static void main(String args[]) {
    //TODO
    //get file input
    File file = new File(args[0]);

    try(scan(file);){}
    catch(IOException e){

    }
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
    }

  }

  class Graph {
    //TODO

    //set up all the nodes and links here
    Node node1 = new Node();


  }

}
