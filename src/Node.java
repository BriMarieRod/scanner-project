import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

class Node {

  public boolean isFinal;
  String type;
  HashSet<Link> links = new HashSet();
  //I'm using a hashset because an array requires you know how many elements it will contain
  //Link links[];

  Node(boolean isFinal,String type) {
    this.isFinal = isFinal;
    this.type = type;
    //this.numLink = numLink;
    //this.links = links;
  }

  public HashSet<Link> addLink(Node node,String input) {
    links.add(new Link(node, input));
    return links;
  }
  //public void add(char x, Node y) {
   // Link lnk = new Link(x,y);
  //}
}
