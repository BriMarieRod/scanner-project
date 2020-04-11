import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

class Node {

  public boolean isFinal;
  String token;
  HashSet<Link> links = new HashSet<Link>();
  //I'm using a hashset because an array requires you know how many elements it will contain
  //Link links[];

  Node(boolean isFinal){
    this.isFinal = isFinal;
  }

  Node(boolean isFinal, String token) {
    this.isFinal = isFinal;
    this.token = token;
    //this.numLink = numLink;
    //this.links = links;
  }

  public void addLink(Node node, String input) {
    this.links.add(new Link(node, input));
    return;
  }
  //public void add(char x, Node y) {
   // Link lnk = new Link(x,y);
  //}
}
