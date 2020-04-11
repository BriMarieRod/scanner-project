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

    /*if(fileInput.equals("non-newline") && fileInput.charAt(0) != '\n') {
      return true;
    }
    else if(Character.isLetter(fileInput.charAt(0))){
      fileInput= "letter";
    }
    else if(Character.isDigit(fileInput.charAt(0))){
      fileInput= "digit";
    }*/

    switch(validInput) {
      case "non-*":
        if(fileInput.charAt(0) != '*')
          return true;
      case "non-newline":
        if(fileInput.charAt(0) != '\n')
          return true;
      case "non-/ or *":
        if(fileInput.charAt(0) != '/' && fileInput.charAt(0) != '*')
          return true;
      case "digit":
        if(Character.isDigit(fileInput.charAt(0)))
          return true;
      case "letter":
      if(Character.isLetter(fileInput.charAt(0)))
        return true;

      default:
        if(fileInput.equals(this.validInput)) {
          return true;
        }
    }
    return false;
  }
}
