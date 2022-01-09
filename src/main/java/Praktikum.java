public class Praktikum {
    public static void main(String[] args) {
        final String CARDHOLDER_NAME = "Тимотей Шевроле";
        Account account = new Account(CARDHOLDER_NAME);
        account.checkNameToEmboss();
    }
}