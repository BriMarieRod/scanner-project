package scanner;

import java.util.Collections;
import java.util.HashSet;

class Link {

  Node nextNode;

  HashSet<String> validInputs;

  boolean inputIsValid(String fileInput) {
    //TODO
    return true; //temporary line only; replace later
  }

  Link(HashSet<String> validInputs, Node nextNode) {
    this.validInputs = validInputs;
    this.nextNode = nextNode;
  }

}
