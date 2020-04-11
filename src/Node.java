import java.util.HashSet;

class Node {

  public boolean isFinal;
  String token;
  HashSet<Link> links = new HashSet<Link>();


  Node(boolean isFinal){
    this.isFinal = isFinal;
  }

  Node(boolean isFinal, String token) {
    this.isFinal = isFinal;
    this.token = token;
  }

  public void addLink(Node node, String input) {
    this.links.add(new Link(node, input));
    return;
  }
}
