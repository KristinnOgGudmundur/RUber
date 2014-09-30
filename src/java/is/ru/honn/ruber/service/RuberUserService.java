package is.ru.honn.ruber.service;

import is.ru.honn.ruber.domain.History;
import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.domain.User;
import is.ru.honn.ruber.domain.UserPage;

import java.util.List;

/**
 * Contais methods that relate to user management. These methods were put in a separate interface
 * from RuberService in order to make the program more loosely coupled and to better adhere
 * to the separation of concerns principle.
 */
public interface RuberUserService {
	/**
	 * Adds a trip to a user with the given user name<br>
	 * Http endpoint:<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;PUT v1/trip<br>
	 * Response:<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;Status-Code: 200 OK<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;{}
	 * @param userName The user name of the user
	 * @param trip The trip that should be added
	 * @throws UserNotFoundException Thrown if there is no user with the given user name
	 */
	public void addTrip(String userName, Trip trip) throws UserNotFoundException;
	/**
	 * Get the trip history of the user with the given user name<br>
	 * Http endpoint:<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;GET v1/history<br>
	 * Response:<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;Status-Code: 200 OK<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;{<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"offset": 0,<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"limit": 0,<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"count": 0,<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"history":<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"uuid": "7354db54-cc9b-4961-81f2-0094b8e2d215",<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"request_time": 1401884467,<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"product_id": "edf5e5eb-6ae6-44af-bec6-5bdcf1e3ed2c",<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"status": "completed",<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"distance": 0.0279562,<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"start_time": 1401884646,<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"end_time": 1401884732<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;]<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;}
	 * @param userName The user name of the user
	 * @return The history of the user's trips
	 * @throws UserNotFoundException Thrown if there is no user with the given user name
	 */
	public History getHistory(String userName) throws UserNotFoundException;
	/**
	 * Create a new user if no user exists with the given user name<br>
	 * Http endpoint:<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;PUT v1/user<br>
	 * Response:<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;Status-Code: 200 OK<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;{}
	 * @param userName The user name of the user
	 * @param firstName The first name of the user
	 * @param lastName The last name of the user
	 * @param password The password of the user
	 * @param email The email of the user
	 * @param picture An url to the user's picture
	 * @param promoCode A promo code for the user
	 * @throws UsernameExistsException Thrown if the given user name already exists.
	 */
	public void signup(String userName, String firstName, String lastName, String password, String email, String picture, String promoCode) throws UsernameExistsException;
	/**
	 * Get a paginated list of users at most 100 users<br>
	 * Http endpoint:<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;GET v1/user<br>
	 * Response:<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;Status-Code: 200 OK<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;{<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"users":<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"uuid": "7354db54-cc9b-4961-81f2-0094b8e2d215",<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"user_name": "Bobby123,<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"first_name": "Bob",<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"last_name": "the builder",<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"e_mail": "bob@builder.com",<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"password": "YesWeCan1",<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"picture": "bob.png",<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"promo_code": "bobby"<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;]<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"pageNumber": 0,<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"numberOfPages": 1<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;}
	 * @param pageNumber The number of the page that should be retrieved
	 * @return A paginated list of 0-100 users
	 * @throws ServiceException If the page number if too high. I.e. if there are not enough users to fill pageNumber pages
	 * @throws IllegalArgumentException Thrown if the given page number if less than 0
	 */
	public UserPage getUsers(int pageNumber) throws ServiceException, IllegalArgumentException;
	/**
	 * Get the user with the given user name<br>
	 * Http endpoint:<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;GET v1/user<br>
	 * Response:<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;Status-Code: 200 OK<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;{<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"uuid": "7354db54-cc9b-4961-81f2-0094b8e2d215",<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"user_name": "Bobby123,<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"first_name": "Bob",<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"last_name": "the builder",<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"e_mail": "bob@builder.com",<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"password": "YesWeCan1",<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"picture": "bob.png",<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"promo_code": "bobby"<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;}<br>
	 * @param userName The user name of the user
	 * @return A user with the given user name
	 * @throws UserNotFoundException Thrown if there is no user with the given user name
	 */
	public User getUser(String userName) throws UserNotFoundException;
}
