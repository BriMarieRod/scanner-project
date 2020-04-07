import java.util.Collections;
//import java.util.HashSet;

class Link {

  Node nextNode;
  String validInput;
  //only one validInput per link rather than LinkedList
  //a string is used for certain cases, like when the input is non-newline

  Link(String validInput, Node nextNode) {
    this.validInput = validInput;
    this.nextNode = nextNode;
  }

  boolean checkInput(String fileInput) {
    switch(fileInput) {
      case "non-*":
        if(fileInput[0] != '*')
          return true;
      case "non-newline":
        if(fileInput[0] != '\n')
          return true;
      default:
        if(fileInput[0] == this.validInput)
          return true;
    }
    return false;
  }

}
