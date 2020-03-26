package scanner;

import java.util.Collection;
import java.util.HashSet;

class Node {

  public boolean isFinal;

  HashSet<Link> links;

  Node(boolean isFinal, HashSet<Link> links) {
    this.isFinal = isFinal;
    this.links = links;
  }

}
