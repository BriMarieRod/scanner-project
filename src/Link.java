import java.util.Collections;
import java.util.HashSet;

class Link {

  Node nextNode;

  //HashSet<String> validInputs;
  char validInputs;
  boolean checkInput(String fileInput) {
    //TODO
    return true; //temporary line only; replace later
  }

  Link(/*HashSet<String>*/Node nextNode, char validInputs) {
    this.validInputs = validInputs;
    this.nextNode = nextNode;
  }

}
