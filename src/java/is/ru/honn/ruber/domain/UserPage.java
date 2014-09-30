package is.ru.honn.ruber.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * A DTO class that contains information about numerous users
 * in a paginated way.
 */
public class UserPage{
	/**
	 * The list of users
	 */
	protected List<User> users;
	/**
	 * The number of the current page
	 */
	protected int pageNumber;
	/**
	 * The total number of pages
	 */
	protected int numberOfPages;

	/**
	 * A parametric constructor
	 * @param users The list of users
	 * @param pageNumber The number of the current page
	 * @param numberOfPages The total number of pages
	 */
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
