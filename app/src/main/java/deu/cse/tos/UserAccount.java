package deu.cse.tos;

public class UserAccount {
    private String hash_key;
    private static UserAccount singleton = new UserAccount();
    private UserAccount() {

    }

    public static UserAccount getInstance() {
        return singleton;
    }

    public String getHash_key() {
        return hash_key;
    }

    public void setHash_key(String hash_key) {
        this.hash_key = hash_key;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "hash_key='" + hash_key + '\'' +
                '}';
    }
}
