public class Login {
    private String username;
    private String password;
    private boolean authenticated = false;

    // Konstruktor untuk membuat akun awal
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Login / autentikasi
    public boolean authenticate(String inputUser, String inputPass) {
        if (inputUser == null || inputPass == null) return false;
        if (inputUser.equals(this.username) && inputPass.equals(this.password)) {
            this.authenticated = true;
            return true;
        }
        return false;
    }

    // Logout
    public void logout() {
        this.authenticated = false;
    }

    // Cek status login
    public boolean isAuthenticated() {
        return this.authenticated;
    }
}