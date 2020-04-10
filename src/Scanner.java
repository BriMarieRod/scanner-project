import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Scanner {

  public static void main(String args[]) {
    //TODO
    //get file input
    File file = new File(args[0]);
    Scanner sc = new Scanner();
    Graph gra = new Scanner.Graph();
    Node graphPoint = gra.node1;

    sc.scan(file, graphPoint, gra);
    //call scan until end of file is reached

  }

  public void scan(File file,Node point,Graph gra) {
    //TODO
    String output;
    Node startPoint = gra.node1;
    try (FileReader fr = new FileReader(file)) {
      int content;
      while (!(point.isFinal))
        if ((content = fr.read()) != -1) {
          System.out.print((char) content);//just a test for now
          String input = String.valueOf((char) content);


          for (Link L : point.links) {
            if (L.checkInput(input)) {
              point = L.nextNode;

              scan(file, point, gra);
            } else if (point.isFinal) {
              //add point.type to an output string
              //or return point.type
            } else {//return an error
            }

          }


        }
    } catch (IOException e) {
    }

  }

  static class Graph {
    //TODO
    Node point = null;

    //;
    //set up all the nodes and links here

    Graph() {

      Node node1 = new Node(false);
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
      /*HashSet<Link> lk1_1 = */node1.addLink(node1," ");
      node1.addLink(node1,"\t");
      node1.addLink(node1,"\n");
      /*HashSet<Link> lk1_2 = */node1.addLink(node2,"/");
      /*HashSet<Link> lk1_6 = */node1.addLink(node6,"(");
      /*HashSet<Link> lk1_7 = */node1.addLink(node7,")");
      /*HashSet<Link> lk1_8 = */node1.addLink(node8,"+");
      /*HashSet<Link> lk1_9 = */node1.addLink(node9,"-");
      /*HashSet<Link> lk1_10 = */node1.addLink(node10,"*");
      /*HashSet<Link> lk1_11 = */node1.addLink(node11,":");
      /*HashSet<Link> lk1_13 = */node1.addLink(node13,".");
      /*HashSet<Link> lk1_14 = */node1.addLink(node14,"digit");
      /*HashSet<Link> lk1_16 = */node1.addLink(node16,"letter");



      //all the links from node 2
      /*HashSet<Link> lk2_3 = */node2.addLink(node3,"/");
      /*HashSet<Link> lk2_4 = */node2.addLink(node4,"*");

      //all the links from node 3
      /*HashSet<Link> lk3_1 = */node3.addLink(node1,"\n");
      /*HashSet<Link> lk3_3 = */node3.addLink(node3,"non-newline");

      //all the links from node 4
      /*HashSet<Link> lk4_4 = */node4.addLink(node4,"non-*");
      /*HashSet<Link> lk4_5 = */node4.addLink(node5,"*");

      //links node 5
      /*HashSet<Link> lk5_1 = */node5.addLink(node1,"/");
      /*HashSet<Link> lk5_5 = */node5.addLink(node5,"*");
      /*HashSet<Link> lk5_3 = */node5.addLink(node4,"non-/");
      node5.addLink(node4,"non-*");

      //links node 11
      /*HashSet<Link> lk11_12 = */node11.addLink(node12,"=");

      //links node 13
      /*HashSet<Link> lk13_15 = */node13.addLink(node15,"digit");

      //links node 14
      /*HashSet<Link> lk14_14 = */node14.addLink(node14,"digit");
      /*HashSet<Link> lk14_15 = */node14.addLink(node15,".");

      //link node 15
      /*HashSet<Link> lk15_115 = */node15.addLink(node15,"digit");

      //link node 16
      /*HashSet<Link> lk16_16 = */node16.addLink(node16,"letter");
      node16.addLink(node16,"digit");

  }


  }

}
