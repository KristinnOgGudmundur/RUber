package is.ru.honn.ruber.service;

import is.ru.honn.ruber.domain.History;
import is.ru.honn.ruber.domain.Price;
import is.ru.honn.ruber.domain.Product;
import is.ru.honn.ruber.domain.User;

import java.util.List;

public interface RuberService
{
	//Functions from assignment 1
	public List<Product> getProducts(double latitude, double longitude) throws ServiceException;
	public List<Price> getPriceEstimates(double startLatitude, double startLongitude,
										 double endLatitude, double endLongitude) throws ServiceException;

	//Functions from assignment 2
	//TODO: Make sure the parameters and return values make sense
	public void addTrips();
	public History getHistory(User user);
	public void signup(String userName, String firstName, String lastName, String password, String email, String picture, String promoCode) throws UsernameExistsException;
	public List<User> getUsers();
	public List<User> getUsers(int pageNumber) throws ArrayIndexOutOfBoundsException;
	public User getUser() throws UserNotFoundException;
}
