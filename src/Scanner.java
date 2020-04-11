import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Scanner {

  public static void main(String args[]) {
    //TODO
    //get file input
    File file = new File("test text.txt");
    Scanner sc = new Scanner();
    Graph gra = new Scanner.Graph();

    System.out.println("Hello");

    String output="( ";
    try (FileReader fr = new FileReader(file)) {
      System.out.println("Test");
      int content;
      if((content = fr.read()) != -1) {
      output =  sc.scan(fr,content, gra.start, gra, output);
    }
    }catch(IOException e){}
    //call scan until end of file is reached
    System.out.println(output + ")");

  }

  public String scan(FileReader fr,int content,Node point,Graph gra, String output) {
    //TODO
    try{
    String input = String.valueOf((char) content);
    boolean check = false;

    for (Link L : point.links) {
      if (L.checkInput(input)) {
        point = L.nextNode;
        System.out.println(input);
        check = true;


          if((content = fr.read()) != -1){
            input = String.valueOf((char) content);
            output = scan(fr,content, point, gra, output);
            return output;
          }


      }

    }

        if (check == false) {
          if (point.isFinal) {
            output = output + (point.token) + ",";
            point = gra.start;
            output = scan(fr,content, point, gra, output);
            return output;
          } else {
             output =output + "input error,";
          }
        }
    }catch (IOException e){}
    return output;

  }


  static class Graph {
    //TODO
    Node start;
    Node point;
    //;
    //set up all the nodes and links here
    Graph() {

      Node node1 = new Node(false);
      point = node1;
      start = node1;
      Node node2 = new Node(true,"div");
      Node node3 = new Node(false);
      Node node4 = new Node(false);
      Node node5 = new Node(false);
      Node node6 = new Node(true,"lParen");
      Node node7 = new Node(true,"rParen");
      Node node8 = new Node(true,"plus");
      Node node9 = new Node(true,"minus");
      Node node10 = new Node(true,"times");
      Node node11 = new Node(false);
      Node node12 = new Node(true,"assign");
      Node node13 = new Node(false);
      Node node14 = new Node(true,"number");
      Node node15 = new Node(true,"number");
      Node node16 = new Node(true,"id");





      //all the links from node 1
      node1.addLink(node1," ");
      node1.addLink(node1,"\t");
      node1.addLink(node1,"\n");
      node1.addLink(node2,"/");
      node1.addLink(node6,"(");
      node1.addLink(node7,")");
      node1.addLink(node8,"+");
      node1.addLink(node9,"-");
      node1.addLink(node10,"*");
      node1.addLink(node11,":");
      node1.addLink(node13,".");
      node1.addLink(node14,"digit");
      node1.addLink(node16,"letter");



      //all the links from node 2
      /*HashSet<Link> lk2_3 = */node2.addLink(node3,"/");
      /*HashSet<Link> lk2_4 = */node2.addLink(node4,"*");

      //all the links from node 3
      /*HashSet<Link> lk3_1 = */node3.addLink(node1,"\n");
      /*HashSet<Link> lk3_3 = */node3.addLink(node3,"non-newline");

      //all the links from node 4
      node4.addLink(node4,"non-*");
      node4.addLink(node5,"*");

      //links node 5
      node5.addLink(node1,"/");
      node5.addLink(node5,"*");
      node5.addLink(node4,"non-/");
      node5.addLink(node4,"non-*");

      //links node 11
      node11.addLink(node12,"=");

      //links node 13
      node13.addLink(node15,"digit");

      //links node 14
      node14.addLink(node14,"digit");
      node14.addLink(node15,".");

      //link node 15
      node15.addLink(node15,"digit");

      //link node 16
      node16.addLink(node16,"letter");
      node16.addLink(node16,"digit");

  }


  }

}
