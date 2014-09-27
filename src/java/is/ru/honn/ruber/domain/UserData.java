package is.ru.honn.ruber.domain;

/**
 * A POJO class that maps a User to it's coresponding History.
 */
public class UserData {
	/**
	 * The user
	 */
	protected User user;
	/**
	 * The user's history
	 */
	protected History history;

	/**
	 * A default constructor
	 */
	public UserData(){

	}

	/**
	 * A parametric constructor
	 * @param user The user
	 * @param history The user's history
	 */
	public UserData(User user, History history){
		setUser(user);
		setHistory(history);
	}

	public User getUser(){
		return user;
	}

	public void setUser(User user){
		this.user = user;
	}

	public History getHistory(){
		return history;
	}

	public void setHistory(History history){
		this.history = history;
	}
}
