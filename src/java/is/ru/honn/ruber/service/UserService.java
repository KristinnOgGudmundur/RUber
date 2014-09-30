package is.ru.honn.ruber.service;

import is.ru.honn.ruber.domain.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gvendur Stefáns on 27.9.2014.
 */
public class UserService implements RuberUserService{
	//TODO: Get messages from the resource bundle

	private List<UserData> userData = new ArrayList<UserData>();

	@Override
	public void addTrip(String uuid, Trip trip) throws UserNotFoundException {
		getHistory(uuid).getHistory().add(trip);
	}

	@Override
	public History getHistory(String uuid) throws UserNotFoundException {
		for(UserData ud : userData){
			if(ud.getUser().getId().equals(uuid)){
				return ud.getHistory();
			}
		}

		throw new UserNotFoundException("There is no user with that user name");
	}

	@Override
	public void signup(String userName, String firstName, String lastName, String password, String email, String picture, String promoCode) throws UsernameExistsException {
		for(UserData ud : userData){
			if(ud.getUser().getUsername() == userName){
				throw new UsernameExistsException("That user name is already taken. Please choose another one");
			}
		}

		int index = userData.size();
		userData.add(new UserData(
						new User(	((Integer)index).toString(),
									userName,
									firstName,
									lastName,
									password,
									email,
									picture,
									promoCode),
						new History()));
	}

	@Override
	public UserPage getUsers(int pageNumber) throws ServiceException, IllegalArgumentException{
		int pageSize = 100;
		if(pageNumber < 0){
			throw new IllegalArgumentException("Illegal page number");
		}
		if((pageNumber - 1) * pageSize > userData.size()){
			throw new ServiceException("Page number is too high");
		}

		int numberOfPages = (userData.size() / pageSize) + 1;

		List<User> returnValue = new ArrayList<User>(100);

		for(int i = pageNumber * pageSize; i < Math.min(((pageNumber + 1) * pageSize), userData.size()); i++){
			returnValue.add(userData.get(i).getUser());
		}

		return new UserPage(returnValue, pageNumber, numberOfPages);
	}

	@Override
	public User getUser(String userName) throws UserNotFoundException {
		for(UserData ud : userData){
			if(ud.getUser().getUsername().equals(userName)){
				return ud.getUser();
			}
		}

		throw new UserNotFoundException("There is no user with that user name");
	}
}
