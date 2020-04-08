import java.util.Collections;
//import java.util.HashSet;

class Link {

  Node nextNode;
  String validInput;
  //only one validInput per link rather than LinkedList
  //a string is used for certain cases, like when the input is non-newline

  Link(Node nextNode, String validInput) {
    this.validInput = validInput;
    this.nextNode = nextNode;
  }

  boolean checkInput(String fileInput) {
    switch(fileInput) {
      case "non-*":
        if(fileInput.charAt(0) != '*')
          return true;
      case "non-newline":
        if(fileInput.charAt(0) != '\n')
          return true;
      default:
        if(fileInput == (this.validInput))
          return true;
    }
    return false;
  }

}
