package is.ru.honn.ruber.service;

import is.ru.honn.ruber.domain.History;
import is.ru.honn.ruber.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gvendur Stefáns on 27.9.2014.
 */
public class UserService implements RuberUserService{
	//TODO: Get messages from the resource bundle

	private List<User> users = new ArrayList<User>();


	@Override
	public void addTrips() {
		//TODO: Figure out and implement
	}

	@Override
	public History getHistory(User user) {
		//TODO: Implement
		return null;
	}

	@Override
	public void signup(String userName, String firstName, String lastName, String password, String email, String picture, String promoCode) throws UsernameExistsException {
		for(User u : users){
			if(u.getUsername() == userName){
				throw new UsernameExistsException("That user name is already taken. Please choose another one");
			}
		}

		users.add(new User(	users.size(),
							userName,
							firstName,
							lastName,
							password,
							email,
							picture,
							promoCode));
	}

	@Override
	public List<User> getUsers(int pageNumber) throws ServiceException{
		int pageSize = 100;
		if(pageNumber < 0){
			throw new IllegalArgumentException("Illegal page number");
		}
		if((pageNumber - 1) * pageSize > users.size()){
			throw new ServiceException("Page number is too high");
		}

		List<User> returnValue = new ArrayList<User>(100);

		for(int i = pageNumber * pageSize; i < Math.min(((pageNumber + 1) * pageSize), users.size()); i++){
			returnValue.add(users.get(i));
		}

		return returnValue;
	}

	public List<User> getUsers(int pageNumber, int pageSize) throws ServiceException {
		//TODO: Implement
		try{

		}
		catch(ArrayIndexOutOfBoundsException e){
			throw new ServiceException(e.getMessage(), e.getCause());
		}
		return null;
	}

	@Override
	public User getUser(String userName) throws UserNotFoundException {
		for(User u : users){
			if(u.getUsername() == userName){
				return u;
			}
		}

		throw new UserNotFoundException("There is no user with that user name");
	}
}
