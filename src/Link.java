
class Link {

  Node nextNode;
  String validInput;


  Link(Node nextNode, String validInput) {
    this.validInput = validInput;
    this.nextNode = nextNode;
  }

  boolean checkInput(String fileInput) {

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
