package is.ru.honn.ruber.service;

import is.ru.honn.ruber.domain.History;
import is.ru.honn.ruber.domain.User;

import java.util.List;

/**
 * Created by Gvendur Stefáns on 27.9.2014.
 */
public class UserService implements RuberUserService{
	@Override
	public void addTrips() {

	}

	@Override
	public History getHistory(User user) {
		return null;
	}

	@Override
	public void signup(String userName, String firstName, String lastName, String password, String email, String picture, String promoCode) throws UsernameExistsException {

	}

	@Override
	public List<User> getUsers() {
		return null;
	}

	@Override
	public List<User> getUsers(int pageNumber, int pageSize) throws ServiceException {
		try{

		}
		catch(ArrayIndexOutOfBoundsException e){
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return null;
	}

	@Override
	public User getUser(String userName) throws UserNotFoundException {
		return null;
	}
}
