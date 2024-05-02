import java.util.HashMap;
import java.util.Map;

public class UserManager extends User{

    private boolean didLogin = false; //giriş yaptıktan sonra yapılabilecek işlemler için kullan örn. updateUsername.

    public HashMap<String, String> users = new HashMap<>();

    public UserManager(String name, String surname, String username, String password, String email) {
        super(name, surname, username, password, email);
    }


    @Override
    public void register(String name, String surname,String username, String password, String email) {

        if (users.containsKey(username))
            System.out.println("This username already taken!");

        else {
            this.username = username;
            users.put(username, password);
            this.email = email;
            this.name = name;
            this.surname = surname;
            System.out.println("Account created, now you can log in.");
        }
    }

    @Override
    public void login(String username, String password) {

        didLogin = true;
        if (users.containsKey(username) && users.get(username).equals(password)) {

            System.out.printf("You logged in, %s!%n", name);
        }
        else {
            System.out.println("There is a mistake on username or password!");
        }
    }

    // loginden sonra yapılsınn düzelt -- düzelttim
    public void updateUsername(String oldUsername, String newUsername) {

        if (didLogin == true){  // if you don't log in, you cannot update your username

            if (users.containsKey(oldUsername)) {

                this.username = newUsername;
                String user = users.remove(oldUsername);
                users.put(newUsername, user);
                System.out.printf("Your username updated to \"%s\" from \"%s\"!%n", newUsername, oldUsername);
            } else {
                System.out.println("Username does not found!");
            }
        }
        else {
            System.out.println("You have to login !!!");
        }
    }
    // loginden sonra yapılsınn düzelt -- düzelttim
    public void updatePassword(String username, String newPassword) {

        if (didLogin == true){ // if you don't log in, you cannot update your password

            if (users.containsKey(username)) {

                this.password = newPassword;
                users.put(username, newPassword);
                System.out.println("Your password changed!");
            } else {
                System.out.println("Username does not found!");
            }
        }
        else {
            System.out.println("YOU HAVE TO LOG IN !!!");
        }
    }

    public void updateEmail(String newEmail){

        if (didLogin == true) {

            this.email = newEmail;
            System.out.printf("Your email updated to \"%s\"!%n", email);
        }
        else {
            System.out.println("YOU HAVE TO LOG IN !!!");
        }
    }

    // adminler için
    public void toplamkisiler(){

        for (Map.Entry<String, String> entry : users.entrySet()) {
            System.out.println("Username: " + entry.getKey() + ", Password: " + entry.getValue());
        }
    }

}
