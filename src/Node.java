import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

class Node {

  public boolean isFinal;
  public int numLink;
  //HashSet<Link> links;
  Link links[];
  Node(boolean isFinal, int numLink) {
    this.isFinal = isFinal;
    this.numLink = numLink;
    this.links = null;


  }
  public void add(char x, Node y) {
    Link lnk = new Link(x,y);
  }
}


