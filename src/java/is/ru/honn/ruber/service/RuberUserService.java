package is.ru.honn.ruber.service;

import is.ru.honn.ruber.domain.History;
import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.domain.User;

import java.util.List;

/**
 * Created by Gvendur Stefáns on 27.9.2014.
 */
public interface RuberUserService {
	//TODO: Make a javadoc for addTrips() and getHistory()
	public void addTrips(String userId, Trip trip) throws UserNotFoundException;
	public History getHistory(String userName) throws UserNotFoundException;
	/**
	 * Create a new user if no user exists with the given user name
	 * @param userName The user name of the user
	 * @param firstName The first name of the user
	 * @param lastName The last name of the user
	 * @param password The password of the user
	 * @param email The email of the user
	 * @param picture An url to the user's picture
	 * @param promoCode A promo code for the user
	 * @throws UsernameExistsException If the given user name already exists.
	 */
	public void signup(String userName, String firstName, String lastName, String password, String email, String picture, String promoCode) throws UsernameExistsException;
	/**
	 * Get a list of users. At most 100 users are retrieved at a time.
	 * @param pageNumber The number of the page that should be retrieved
	 * @return A list of 0-100 users
	 * @throws ServiceException If the page number if too high. I.e. if there are not enough users to fill pageNumber pages
	 * @throws IllegalArgumentException If the given page number if less than 0
	 */
	public List<User> getUsers(int pageNumber) throws ServiceException, IllegalArgumentException;
	/**
	 * Returns the user with the given user name
	 * @param userName The user name of the user
	 * @return A user with the given user name
	 * @throws UserNotFoundException If there is no user with the given user name
	 */
	public User getUser(String userName) throws UserNotFoundException;
}
