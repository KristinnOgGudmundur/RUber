package is.ru.honn.ruber.service;

import is.ru.honn.ruber.domain.History;
import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gvendur Stefáns on 27.9.2014.
 */
public class UserService implements RuberUserService{
	//TODO: Get messages from the resource bundle

	private List<User> users = new ArrayList<User>();
	private List<History> userHistories = new ArrayList<History>();


	@Override
	public void addTrips(String userId, Trip trip) throws UserNotFoundException {
		//TODO: Test
		getHistory(userId).getHistory().add(trip);
	}

	@Override
	public History getHistory(String userName) throws UserNotFoundException {
		//TODO: Test
		int index = getIndexByUserId(getUser(userName).getId());

		return userHistories.get(index);
	}

	@Override
	public void signup(String userName, String firstName, String lastName, String password, String email, String picture, String promoCode) throws UsernameExistsException {
		for(User u : users){
			if(u.getUsername() == userName){
				throw new UsernameExistsException("That user name is already taken. Please choose another one");
			}
		}

		int index = users.size();
		users.add(new User(	((Integer)index).toString(),
							userName,
							firstName,
							lastName,
							password,
							email,
							picture,
							promoCode));
		userHistories.add(index, new History(0,0,0));
	}

	@Override
	public List<User> getUsers(int pageNumber) throws ServiceException, IllegalArgumentException{
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

	@Override
	public User getUser(String userName) throws UserNotFoundException {
		for(User u : users){
			if(u.getUsername() == userName){
				return u;
			}
		}

		throw new UserNotFoundException("There is no user with that user name");
	}

	// region Helper functions

	private int getIndexByUserId(String uuid){
		return Integer.parseInt(uuid);
	}

	// endregion Helper functions
}
