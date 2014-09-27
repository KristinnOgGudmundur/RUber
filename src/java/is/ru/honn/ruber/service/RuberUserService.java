package is.ru.honn.ruber.service;

import is.ru.honn.ruber.domain.History;
import is.ru.honn.ruber.domain.User;

import java.util.List;

/**
 * Created by Gvendur Stefáns on 27.9.2014.
 */
public interface RuberUserService {
	//TODO: Make sure the parameters and return values make sense
	public void addTrips();
	public History getHistory(User user);
	public void signup(String userName, String firstName, String lastName, String password, String email, String picture, String promoCode) throws UsernameExistsException;
	public List<User> getUsers();
	public List<User> getUsers(int pageNumber) throws ArrayIndexOutOfBoundsException;
	public User getUser() throws UserNotFoundException;
}
