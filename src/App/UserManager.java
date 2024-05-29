package App;

import DataBaseConnection.DeleteData;
import DataBaseConnection.InsertData;
import DataBaseConnection.SelecetData;
import DataBaseConnection.UpdataData;

import java.util.ArrayList;


public class UserManager extends User {


    //kullanıcıadlarını ve şifrelerini özdeş indexlerde tutar
//    static ArrayList<String> usernames = new ArrayList<>();
//    static ArrayList<String> passwords = new ArrayList<>();

    // giriş yapmış olan kullanıcının kullanıcıadını tutar, bazı methodlarda lazım oluyor
    public static String [] loggedInUsername = new String[1];

    public UserManager(String name, String surname, String username, String password, String email) {
        super(name, surname, username, password, email);
    }

    // yeni bir kullanıcıyı kayıt yapmak için kullanılır
    @Override
    public void register(String name, String surname, String username, String password, String email) {

        InsertData insert = new InsertData();
        insert.insertUsers(name, surname, username, password,email);

    }

    // çıkış yapmak için kullanılır
    public void logout() {
        didLogin = false;
        loggedInUsername[0] = null;
        System.out.println("You logged out successfully");

        CartManager.clearCart();

        setName("");
        setSurname("");
        setUsername("");
        setPassword("");
        setEmail("");
    }

    // giriş yapmak için kullanılır
    @Override
    public void login(String username, String password) {

        ArrayList<String> userData;

        SelecetData select = new SelecetData();
        didLogin = select.selectUser(username,password);

        if(didLogin){
            System.out.println("You've logged in successfully");
            loggedInUsername[0] = username;

            userData = select.getUserData();
            setName(userData.get(0));
            setSurname(userData.get(1));
            setUsername(userData.get(2));
            setPassword(userData.get(3));
            setEmail(userData.get(4));
        } else {
            System.out.println("Password or username is wrong");
        }

    }

    // kullanıcının kayıtlı olan olan yerlerden kullanıcıadını günceller, database veya arraylistlerde
    @Override
    public void updateUsername(String oldUsername, String newUsername) {
        if (oldUsername != newUsername){
            if (didLogin == true) {
                this.username = newUsername;
                UpdataData update = new UpdataData();
                update.updateUsernameDatabase(oldUsername,newUsername);
                loggedInUsername[0] = newUsername;

            } else {
                System.out.println("YOU HAVE TO LOG IN !!!");
            }

        } else {
            System.out.println("New username must be different!");
        }

    }

    // kullanıcının kayıtlı olan yerlerden şifresini günceller, database veya arraylistlerde
    @Override
    public void updatePassword(String username, String newPassword) {

        if (didLogin == true) { // if you don't log in, you cannot update your password

            this.password = newPassword;

            UpdataData update = new UpdataData();
            update.updatePasswordDatabase(username,newPassword);
        } else {
            System.out.println("YOU HAVE TO LOG IN !!!");
        }
    }

    // kullanıcının kayıtlı olan yerlerden emailini günceller, database veya arraylistlerde
    @Override
    public void updateEmail(String newEmail) {

        if (didLogin == true) {

            this.email = newEmail;

            UpdataData update = new UpdataData();
            update.updateEmailDatabase(newEmail);

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

            UpdataData update = new UpdataData();
            update.updateNameAndSurnameDatabase(newName,newSurname);
        } else {
            System.out.println("YOU HAVE TO LOG IN !!!");
        }
    }

}
