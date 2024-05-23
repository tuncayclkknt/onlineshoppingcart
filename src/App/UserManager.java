package App;

import DataBaseConnection.Create;
import DataBaseConnection.DeleteData;
import DataBaseConnection.UpdataData;

import java.util.ArrayList;


public class UserManager extends User {

    // her kullanıcıya özgü artan bir id verir, ex: 1,2,3,4,...
    private static int nextID = 1;
    private int userID;

    //kullanıcıadlarını ve şifrelerini özdeş indexlerde tutar
    static ArrayList<String> usernames = new ArrayList<>();
    static ArrayList<String> passwords = new ArrayList<>();

    // giriş yapmış olan kullanıcının kullanıcıadını tutar, bazı methodlarda lazım oluyor
    public static String [] loggedInUsername = new String[1];

    public UserManager(String name, String surname, String username, String password, String email) {
        super(name, surname, username, password, email);
    }

    // yeni bir kullanıcıyı kayıt yapmak için kullanılır
    @Override
    public void register(String name, String surname, String username, String password, String email) {

        if (usernames.contains(username))
            System.out.println("This username already taken, please try another usernames.");
        else {
            this.username = username;
            usernames.add(username);
            this.password = password;
            passwords.add(password);

            this.email = email;
            this.name = name;
            this.surname = surname;
            System.out.println("Account created, now you can log in.");
            this.userID = nextID++;
        }
    }

    // çıkış yapmak için kullanılır
    public void logout() {
        didLogin = false;
        loggedInUsername[0] = null;

        DeleteData delete = new DeleteData();
        delete.dropTable("Cart");
    }

    // giriş yapmak için kullanılır
    @Override
    public void login(String username, String password) {

        if (usernames.contains(username)) {
            int indexOfUsername = usernames.indexOf(username);

            if (passwords.get(indexOfUsername).equals(password)) {
                didLogin = true;
                System.out.printf("You logged in, %s!%n", name);

                loggedInUsername[0] = username;

                Create.createCartTable();

            } else {
                System.out.println("There is a mistake on your password!");
            }

        } else {
            System.out.println("This username is not fount!");
        }

    }

    // kullanıcının kayıtlı olan olan yerlerden kullanıcıadını günceller, database veya arraylistlerde
    @Override
    public void updateUsername(String oldUsername, String newUsername) {

        if (didLogin == true) {
            if (getUsername().equals(oldUsername)) {
                this.username = newUsername;
                usernames.set(usernames.indexOf(oldUsername), newUsername);
                System.out.printf("Your username updated to \"%s\" from \"%s\"!%n", newUsername, oldUsername);

                UpdataData update = new UpdataData();
                update.updateUsernameDataBase(oldUsername,newUsername);

            } else {
                System.out.println("You cannot rewrite another username!!!");
            }
        } else {
            System.out.println("YOU HAVE TO LOG IN !!!");
        }
    }

    // kullanıcının kayıtlı olan yerlerden şifresini günceller, database veya arraylistlerde
    @Override
    public void updatePassword(String username, String newPassword) {

        if (didLogin == true) { // if you don't log in, you cannot update your password

            if (getUsername().equals(username)) {
                this.password = newPassword;
                passwords.set(usernames.indexOf(username), newPassword);
                System.out.println("Your password changed!");

                UpdataData update = new UpdataData();
                update.updatePasswordDataBase(username,newPassword);

            } else {
                System.out.println("You cannot rewrite another password!!!");
            }
        } else {
            System.out.println("YOU HAVE TO LOG IN !!!");
        }
    }

    // kullanıcının kayıtlı olan yerlerden emailini günceller, database veya arraylistlerde
    @Override
    public void updateEmail(String newEmail) {

        if (didLogin == true) {

            this.email = newEmail;
            System.out.printf("Your email updated to \"%s\"!%n", email);

            UpdataData update = new UpdataData();
            update.updateEmailDataBase(newEmail);

        } else {
            System.out.println("YOU HAVE TO LOG IN !!!");
        }
    }

    // kullanıcının kayıtlı olan yerlerden isim ve soyismini günceller, database veya arraylistlerde
    @Override
    public void updateNameAndSurname(String newName, String newSurname) {
        if (didLogin) {
            this.name = newName;
            this.surname = newSurname;
            System.out.printf("Your name and surname updated as %s and %s%n", name, surname);

            UpdataData update = new UpdataData();
            update.updateNameAndSurnameDataBase(newName,newSurname);
        } else {
            System.out.println("YOU HAVE TO LOG IN !!!");
        }
    }

}
