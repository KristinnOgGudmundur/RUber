package is.ru.honn.ruber.domain;

/**
 * Created by Kristinn on 26.9.2014.
 */
public class User {
    protected int id;
    protected String username;
    protected String firstName;
    protected String lastName;
    protected String password;
    protected String email;
    protected String picture;
    protected String promoCode;

    public User() {
    }

	public User(int id, String userName, String firstName, String lastName, String password, String email, String picture, String promoCode){
		setId(id);
		setUsername(userName);
		setFirstName(firstName);
		setLastName(lastName);
		setPassword(password);
		setEmail(email);
		setPicture(picture);
		setPromoCode(promoCode);
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }
}
