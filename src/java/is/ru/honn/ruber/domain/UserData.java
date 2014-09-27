package is.ru.honn.ruber.domain;

/**
 * Created by Gvendur Stefáns on 27.9.2014.
 */
public class UserData {
	protected User user;
	protected History history;

	public UserData(){

	}

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
