
public abstract class User {
    protected String username;
    protected String password;
    protected String email;
    protected String name;
    protected String surname;

    public User(String name, String surname,String username, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }

    public abstract void login(String username, String password);
    public abstract void register(String name, String surname, String username, String password, String email);

//---------------------------get set----------------------------
        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getEmail() {
            return email;
        }

        public String getName() {
        return name;
    }

        public String getSurname(){return surname;}

        public void setUsername(String username) {
            this.username = username;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setName(String name) {
        this.name = name;
    }

        public void setSurname(String surname){this.surname = surname;}


}
