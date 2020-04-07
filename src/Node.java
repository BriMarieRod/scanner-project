import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

class Node {

  public boolean isFinal;
  public int numLink;
  HashSet<Link> links;
  //I'm using a hashset because an array requires you know how many elements it will contain
  //Link links[];

  Node(boolean isFinal) {
    this.isFinal = isFinal;
    //this.numLink = numLink;
    //this.links = links;
  }

  public void addLink(String input, Node node) {
    links.add(new Link(input, node));
  }
  //public void add(char x, Node y) {
   // Link lnk = new Link(x,y);
  //}
}
