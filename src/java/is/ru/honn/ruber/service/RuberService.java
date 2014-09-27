package is.ru.honn.ruber.service;

import is.ru.honn.ruber.domain.History;
import is.ru.honn.ruber.domain.Price;
import is.ru.honn.ruber.domain.Product;
import is.ru.honn.ruber.domain.User;

import java.util.List;

public interface RuberService extends RuberUserService
{
	//Functions from assignment 1
	public List<Product> getProducts(double latitude, double longitude) throws ServiceException;
	public List<Price> getPriceEstimates(double startLatitude, double startLongitude,
										 double endLatitude, double endLongitude) throws ServiceException;
}
