public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }
    public boolean checkThatStringIsNotNull(){
        return name!=null;
    }
    public boolean checkLengthOfTheStringMoreThenThreeAndLessThenNineteen(){
        return(name.length()>=3 && name.length()<=19);
    }
    public boolean checkThatIsOnlyOneSpaceInTheString(){
        return(name.chars().filter(ch -> ch == ' ').count()==1);
    }
    public boolean checkThatTheOnlyOneSpaceInTheStringNotInTheBeginAndNotInTheEndOfTheString(){
        return(name.charAt(0) != ' ' && name.charAt(name.length()-1) != ' ');
    }
    public boolean checkNameToEmboss() {
        if(checkThatStringIsNotNull())
            return  checkLengthOfTheStringMoreThenThreeAndLessThenNineteen() &&
                checkThatIsOnlyOneSpaceInTheString() &&
                checkThatTheOnlyOneSpaceInTheStringNotInTheBeginAndNotInTheEndOfTheString();
        else
            return false;
    }
}