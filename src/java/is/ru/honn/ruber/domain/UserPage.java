package is.ru.honn.ruber.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gvendur Stefáns on 30.9.2014.
 */
public class UserPage{
	protected List<User> users;
	protected int pageNumber;
	protected int numberOfPages;

	public UserPage(List<User> users, int pageNumber, int numberOfPages){
		setUsers(users);
		setPageNumber(pageNumber);
		setNumberOfPages(numberOfPages);
	}

	public List<User> getUsers(){
		return this.users;
	}

	public int getPageNumber(){
		return this.pageNumber;
	}

	public int getNumberOfPages(){
		return this.numberOfPages;
	}

	public void setUsers(List<User> users){
		this.users = users;
	}

	public void setPageNumber(int pageNumber){
		this.pageNumber = pageNumber;
	}

	public void setNumberOfPages(int numberOfPages){
		this.numberOfPages = numberOfPages;
	}
}
