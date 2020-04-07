import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
    char digit = '0'|'1'|'2'|'3'|'4'|'5'|'6'|'7'|'8'|'9';
    char letter = 'a'|'b'|'c'|'d'|'e'|'f'|'g'|'h'|'i'|'j'|'k'|'l'|'m'|'n'|'o'|'p'|'q'
            |'r'|'s'|'t'|'u'|'v'|'w'|'x'|'y'|'z'|'A'|'B'|'C'|'D'|'E'|'F'|'G'|'H'|'I'
            |'J'|'K'|'L'|'M'|'N'|'O'|'P'|'Q'|'R'|'S'|'T'|'U'|'V'|'W'|'X'|'Y'|'Z';
    //set up all the nodes and links here
    Link[] link1 = new Link[10];
    Link[] link2 = new Link[2];
    Link[] link3 = new Link[2];
    Link[] link4 = new Link[2];
    Link[] link5 = new Link[2];
    Link[] link11 = new Link[1];
    Link[] link13 = new Link[1];
    Link[] link14 = new Link[2];
    Link[] link15 = new Link[1];
    Link[] link16 = new Link[1];


    Node node1 = new Node(false,link1);
    Node node2 = new Node(true,link2);
    Node node3 = new Node(false,link3);
    Node node4 = new Node(false,link4);
    Node node5 = new Node(false,link5);
    Node node6 = new Node(true,null);
    Node node7 = new Node(true,null);
    Node node8 = new Node(true,null);
    Node node9 = new Node(true,null);
    Node node10 = new Node(true,null);
    Node node11 = new Node(false,link11);
    Node node12 = new Node(true,null);
    Node node13 = new Node(false,link13);
    Node node14 = new Node(true,link14);
    Node node15 = new Node(true,link15);
    Node node16 = new Node(true,link16);

    //all the links from node 1
    Link lk1_1 = new Link(node1,' ');
    Link lk1_2 = new Link(node2,'/');
    Link lk1_6 = new Link(node6,'(');
    Link lk1_7 = new Link(node7,')');
    Link lk1_8 = new Link(node8,'+');
    Link lk1_9 = new Link(node9,'-');
    Link lk1_10 = new Link(node10,'*');
    Link lk1_11 = new Link(node11,':');
    Link lk1_13 = new Link(node13,'.');
    Link lk1_14 = new Link(node14,digit);
    Link lk1_16 = new Link(node16,letter);

    //all the links from node 2
    Link lk2_3 = new Link(node3,'/');
    Link lk2_4 = new Link(node4,'*');

    //all the links from node 3
    Link lk3_1 = new Link(node1,'\n');
    Link lk3_3 = new Link(node3,'\n'); //needs to be NOT newline

    //all the links from node 4
    Link lk4_4 = new Link(node4,'*'); //needs to be NOT *
    Link lk4_5 = new Link(node5,'*');

    //links node 5
    Link lk5_1 = new Link(node1,'/');
    Link lk5_5 = new Link(node5,'*');
    Link lk5_3 = new Link(node1,' ');//NOT '/' or '*'

    //links node 11
    Link lk11_12 = new Link(node12,'=');

    //links node 13
    Link lk13_15 = new Link(node15,digit);

    //links node 14
    Link lk14_14 = new Link(node14,digit);
    Link lk14_15 = new Link(node15,'.');

    //link node 15
    Link lk15_115 = new Link(node15,digit);

    //link node 16
    Link lk16_16 = new Link(node16,' ');//id or keyword






  }

}
