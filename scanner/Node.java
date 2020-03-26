package scanner;

import java.util.Collection;
import java.util.HashSet;

class Node {

  public boolean isFinal;

  Set<Link> links;

  Node(boolean isFinal, links) {
    this.isFinal = isFinal;
    this.links = links;
  }

}
