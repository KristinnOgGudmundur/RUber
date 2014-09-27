package is.ru.honn.ruber.domain;

/**
 * A POJO class containing information about a user.
 */
public class User {
	/**
	 * The id of the user
	 */
    protected String uuid;
	/**
	 * The user name of the user
	 */
    protected String username;
	/**
	 * The first name of the user
	 */
    protected String firstName;
	/**
	 * The last name of the user
	 */
    protected String lastName;
	/**
	 * The password of the user
	 */
    protected String password;
	/**
	 * The e-mail of the user
	 */
    protected String email;
	/**
	 * An URL of the user's picture
	 */
    protected String picture;
	/**
	 * The promo code of the user
	 */
    protected String promoCode;

	/**
	 * A default constructor
	 */
    public User() {
    }

	/**
	 * A parametric constructor
	 * @param uuid The user's id
	 * @param userName The user name of the user
	 * @param firstName The first name of the user
	 * @param lastName The last name of the user
	 * @param password The password of the user
	 * @param email The e-mail of the user
	 * @param picture An url of the User's picture
	 * @param promoCode The promo code of the user
	 */
	public User(String uuid, String userName, String firstName, String lastName, String password, String email, String picture, String promoCode){
		setId(uuid);
		setUsername(userName);
		setFirstName(firstName);
		setLastName(lastName);
		setPassword(password);
		setEmail(email);
		setPicture(picture);
		setPromoCode(promoCode);
	}

    public String getId() {
        return uuid;
    }

    public void setId(String uuid) {
        this.uuid = uuid;
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
