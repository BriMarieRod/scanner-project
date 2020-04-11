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
    ;
    if((fileInput.equals("*"))){

    }
    else if(Character.isLetter(fileInput.charAt(0))){
      fileInput= "letter";
    }
    else if(Character.isDigit(fileInput.charAt(0))){
      fileInput= "digit";
    }

    /*switch(fileInput) {
      case "non-*":
        if(fileInput.charAt(0) != '*')
          return true;
      case "non-newline":
        if(fileInput.charAt(0) != '\n')
          return true;
      case "non-/":
        if(fileInput.charAt(0) != '/')
          return true;


      default:*/
        if(fileInput.equals(this.validInput)) {
          return true;
        }
    return false;
  }

}
