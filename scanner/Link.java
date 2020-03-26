package scanner;

class Link {

  Node nextNode;

  Set<String> validInputs;

  boolean inputIsValid(String fileInput) {
    //TODO
  }

  Link(Set<String> validInputs, Node nextNode) {
    this.validInputs = validInputs;
    this.nextNode = nextNode;
  }

}
