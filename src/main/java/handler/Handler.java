package handler;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;

import PlainObjects.Announcement;
import PlainObjects.AnnouncementSearch;
import PlainObjects.Category;
import PlainObjects.City;
import PlainObjects.CreditCard;
import PlainObjects.CustomerAddress;
import PlainObjects.CustomerSearch;
import PlainObjects.Customers;
import PlainObjects.Location;
import PlainObjects.Purchase;
import PlainObjects.PurchaseSearch;
import PlainObjects.Request;
import PlainObjects.RequestSearch;
import PlainObjects.ResourceSearch;
import PlainObjects.Resources;
import PlainObjects.SubCategory;
import PlainObjects.SupplierAddress;
import PlainObjects.SupplierSearch;
import PlainObjects.Suppliers;
import PlainObjects.Supplies;
import dao.DAO;
import main.Controller;

public class Handler {

	private final static Logger logger = LogManager.getLogger(Controller.class);
	DAO dao = new DAO();

	public ArrayList<Resources> getAllResources(HttpServletRequest request) throws UnsupportedEncodingException, SQLException {
		String req = request.getQueryString();
		Map<String, String> query_pairs = null;
		logger.info("Im in getAllResources Method");

		if (req != null) {
			query_pairs = splitQuery(request);

			for(Entry<String, String> entry: query_pairs.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}

		ArrayList<Resources> resourcesList = dao.getAllResources(query_pairs);

		return resourcesList;
	}

	public ArrayList<ResourceSearch> searchResource(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		String searchTerm = "";
		logger.info("Im in searchResources Method");
		Map<String, String> query_pairs = null;
		if (req != null) {
			query_pairs = splitQuery(request);
			if(query_pairs.containsKey("searchterm")) {
				searchTerm = query_pairs.get("searchterm");
			}
		}

		ArrayList<ResourceSearch> resourceList = dao.searchResource(searchTerm);

		return resourceList;
	}

	public Resources getResourceById(@PathVariable int rid) {
		logger.info("Im in getResourcesById Method");
		return dao.getResourcesById(rid);
	}

	/*
	 * En el update no tengo que incluir todas las columnas, por lo que
	 * en el if puedo probar que columnas no son null y solo añadir esas
	 */
	public Resources updateResource(Map<String, Object> payload) throws IOException {

//		String req = request.getReader().readLine();
//		System.out.println("Estoy aqui: " + req);
		Resources resource = new Resources();
//
//		Map<String, String> resourceObj = null;
//		if (req != null) {
//			resourceObj = splitQueryFromHtml(req);

//			for(Entry<String, String> entry: resourceObj.entrySet()) {
			for(Entry<String, Object> entry: payload.entrySet()) {

				System.out.println(entry.getKey() + " : " + entry.getValue());

				if(entry.getValue() == null) {
					System.out.println("You have to fill all information");
					break;
				}
				else {
					if(entry.getKey().equals("name")) {

						entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
						System.out.println(entry.getValue());

						resource.setName((String) entry.getValue());
						System.out.println(entry.getKey());

					}
					else if(entry.getKey().equals("id")) {
						resource.setId(Long.parseLong((String) entry.getValue()));
						System.out.println(entry.getKey());}
					else if(entry.getKey().equals("price")) {
						resource.setPrice(Float.parseFloat((String) entry.getValue()));
						System.out.println(entry.getKey());}
					else if(entry.getKey().equals("qtyperpk")) {
						resource.setQtyPerPk(Integer.valueOf((String) entry.getValue()));
						System.out.println(entry.getKey());}
					else if(entry.getKey().equals("catid")) {
						resource.setCatId(Integer.valueOf((String) entry.getValue()));	
						System.out.println(entry.getKey());}
					else if(entry.getKey().equals("subcatid")) {
						resource.setSubCatId(Integer.valueOf((String) entry.getValue()));
						System.out.println(entry.getKey());}
					else if(entry.getKey().equals("rid")) {
						resource.setId(Integer.valueOf((String) entry.getValue()));
						System.out.println(entry.getKey());}
				}
			}
//		}

		if (dao.getResourcesById(resource.getId()) == null) {
			//jsonify error Response http
			System.out.println("No resource with that id.");
			return null;
		}
		dao.updateResource(resource);
		return resource;
	}

	/*
	 * En el insert se tienen que proveer todas las columnas
	 * En vez de verificar el length de la data inserted puedo
	 * probar if(col1!=null && col2!=null && ... )
	 */
	public Resources insertResource(Map<String, Object> payload) throws IOException {

//		String req = request.getReader().readLine();
//		System.out.println("Estoy aqui: " + req);
//
//		Map<String, String> resourceObj = null;
//		if (req != null) {
//			resourceObj = splitQueryFromHtml(req);
			Resources resource = new Resources();

//			for(Entry<String, String> entry: resourceObj.entrySet()) {
			for(Entry<String, Object> entry: payload.entrySet()) {

				System.out.println(entry.getKey() + " : " + entry.getValue());

				if(entry.getValue() == null) {
					System.out.println("You have to fill all information");
					break;
				}
				else {
					if(entry.getKey().equals("name")) {

						entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
						System.out.println(entry.getValue());

						resource.setName((String) entry.getValue());
						System.out.println(entry.getKey());

					}
					else if(entry.getKey().equals("price")) {
						resource.setPrice(Float.parseFloat((String) entry.getValue()));
						System.out.println(entry.getKey());}
					else if(entry.getKey().equals("qtyperpk")) {
						resource.setQtyPerPk(Integer.valueOf((String) entry.getValue()));
						System.out.println(entry.getKey());}
					else if(entry.getKey().equals("catid")) {
						resource.setCatId(Integer.valueOf((String) entry.getValue()));	
						System.out.println(entry.getKey());}
					else if(entry.getKey().equals("subcatid")) {
						resource.setSubCatId(Integer.valueOf((String) entry.getValue()));
						System.out.println(entry.getKey());}
				}
			}
			System.out.println(resource);
			dao.insertResource(resource);
//		}	
		return null;
	}

	public ArrayList<Suppliers> getAllSuppliers(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		Map<String, String> query_pairs = null;
		logger.info("Im in getAllSuppliers Method");

		if (req != null) {
			query_pairs = splitQuery(request);

			for(Entry<String, String> entry: query_pairs.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}
		ArrayList<Suppliers> supplierList = dao.getAllSuppliers(query_pairs);

		return supplierList;
	}

	public ArrayList<SupplierSearch> searchSupplier(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		String searchTerm = "";
		logger.info("Im in searchSuppliers Method");
		Map<String, String> query_pairs = null;
		if (req != null) {
			query_pairs = splitQuery(request);
			if(query_pairs.containsKey("searchterm")) {
				searchTerm = query_pairs.get("searchterm");
			}
		}

		ArrayList<SupplierSearch> supplierList = dao.searchSuppliers(searchTerm);

		return supplierList;
	}

	public Suppliers getSupplierById(int sid) {
		logger.info("Im in getSupplierById Method");
		return dao.getSupplierById(sid);
	}

	/*
	 * En el update no tengo que incluir todas las columnas, por lo que
	 * en el if puedo probar que columnas no son null y solo añadir esas
	 */
	public Suppliers updateSupplier(Map<String, Object> payload) throws IOException {

//		String req = request.getReader().readLine();
//		System.out.println("Estoy aqui: " + req);
		Suppliers supplier = new Suppliers();
		SupplierAddress supplierAddr = new SupplierAddress();

//		Map<String, String> supplierObj = null;
//		if (req != null) {
//			supplierObj = splitQueryFromHtml(req);

//			for(Entry<String, String> entry: supplierObj.entrySet()) {
			for(Entry<String, Object> entry: payload.entrySet()) {

				System.out.println(entry.getKey() + " : " + entry.getValue());

				if(entry.getValue() == null) {
					System.out.println("You have to fill all information");
					break;
				}
				else {
					if(entry.getKey().equals("sname")) {

						entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
						System.out.println(entry.getValue());

						supplier.setFirstName((String) entry.getValue());
						System.out.println(entry.getKey());

					}
					else if(entry.getKey().equals("sid")) {

						supplier.setId(Long.parseLong((String)entry.getValue()));
						System.out.println(entry.getKey());

					}
					else if(entry.getKey().equals("slastname")) {

						entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
						System.out.println(entry.getValue());

						supplier.setLastName((String) entry.getValue());
						System.out.println(entry.getKey());

					}
					else if(entry.getKey().equals("sphone")) {

						entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
						System.out.println(entry.getValue());

						supplier.setPhone((String) entry.getValue());
						System.out.println(entry.getKey());

					}
					else if(entry.getKey().equals("street")) {

						entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
						System.out.println(entry.getValue());

						supplierAddr.setStreet((String) entry.getValue());
						System.out.println(entry.getKey());

					}
					else if(entry.getKey().equals("city")) {

						entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
						System.out.println(entry.getValue());

						supplierAddr.setCity((String) entry.getValue());
						System.out.println(entry.getKey());

					}
					else if(entry.getKey().equals("state")) {

						entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
						System.out.println(entry.getValue());

						supplierAddr.setState((String) entry.getValue());
						System.out.println(entry.getKey());

					}
					else if(entry.getKey().equals("zcode")) {

						entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
						System.out.println(entry.getValue());

						supplierAddr.setZcode((String) entry.getValue());
						System.out.println(entry.getKey());

					}
				}
			}
//		}

		if (dao.getSupplierById(supplier.getId()) == null) {
			//jsonify error Response http
			System.out.println("No supplier with that id.");
			return null;
		}
		dao.updateSupplier(supplier, supplierAddr);
		return supplier;
	}

	/*
	 * En el insert se tienen que proveer todas las columnas
	 * En vez de verificar el length de la data inserted puedo
	 * probar if(col1!=null && col2!=null && ... )
	 */
	public Suppliers insertSupplier(Map<String,Object> payload) throws IOException {

//		String req = request.getReader().readLine();
//		System.out.println("Estoy aqui: " + req);
//
//		Map<String, String> resourceObj = null;
//		if (req != null) {
//			resourceObj = splitQueryFromHtml(req);
			Suppliers supplier = new Suppliers();
			SupplierAddress supplierAddr = new SupplierAddress();

//			for(Entry<String, String> entry: resourceObj.entrySet()) {
			for(Entry<String, Object> entry: payload.entrySet()) {
				

				System.out.println(entry.getKey() + " : " + entry.getValue());

				if(entry.getValue() == null) {
					//length of data inserted is not equal to the number of columns
					System.out.println("You have to fill all information");
					break;
				}
				else {
					if(entry.getKey().equals("sname")) {

						entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
						System.out.println(entry.getValue());

						supplier.setFirstName((String) entry.getValue());
						System.out.println(entry.getKey());

					}
					else if(entry.getKey().equals("sid")) {

						supplier.setId((long) entry.getValue());
						System.out.println(entry.getKey());

					}
					else if(entry.getKey().equals("slastname")) {

						entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
						System.out.println(entry.getValue());

						supplier.setLastName((String) entry.getValue());
						System.out.println(entry.getKey());

					}
					else if(entry.getKey().equals("sphone")) {

						entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
						System.out.println(entry.getValue());

						supplier.setPhone((String) entry.getValue());
						System.out.println(entry.getKey());

					}
					else if(entry.getKey().equals("street")) {

						entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
						System.out.println(entry.getValue());

						supplierAddr.setStreet((String) entry.getValue());
						System.out.println(entry.getKey());

					}
					else if(entry.getKey().equals("city")) {

						entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
						System.out.println(entry.getValue());

						supplierAddr.setCity((String) entry.getValue());
						System.out.println(entry.getKey());

					}
					else if(entry.getKey().equals("state")) {

						entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
						System.out.println(entry.getValue());

						supplierAddr.setState((String) entry.getValue());
						System.out.println(entry.getKey());

					}
					else if(entry.getKey().equals("zcode")) {

						entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
						System.out.println(entry.getValue());

						supplierAddr.setZcode((String) entry.getValue());
						System.out.println(entry.getKey());

					}

				}
			}
			System.out.println(supplier);
			dao.insertSuppliers(supplier);
			System.out.println(supplierAddr);
			dao.insertSupplierAddress(supplierAddr, supplier);
//		}	
		return null;
	}

	public ArrayList<Customers> getAllCustomers(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		Map<String, String> query_pairs = null;
		logger.info("Im in getAllCustomers Method");

		if (req != null) {
			query_pairs = splitQuery(request);
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}

		ArrayList<Customers> customersList = dao.getAllCustomers(query_pairs);

		return customersList;
	}

	public ArrayList<CustomerSearch> searchCustomer(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		String searchTerm = "";
		logger.info("Im in searchCustomer Method");
		Map<String, String> query_pairs = null;
		if (req != null) {
			query_pairs = splitQuery(request);
			if(query_pairs.containsKey("searchterm")) {
				searchTerm = query_pairs.get("searchterm");
			}
		}

		ArrayList<CustomerSearch> customerList = dao.searchCustomers(searchTerm);

		return customerList;
	}

	public Customers getCustomerById(int cid) {
		logger.info("Im in getCustomerById Method");
		return dao.getCustomerById(cid);
	}

	/*
	 * En el update no tengo que incluir todas las columnas, por lo que
	 * en el if puedo probar que columnas no son null y solo añadir esas
	 */
	public Customers updateCustomers(Map<String, Object> payload) throws IOException {

//			String req = request.getReader().readLine();
//			System.out.println("Estoy aqui: " + req);
			CreditCard creditcard = new CreditCard();
			Customers customer = new Customers();
			CustomerAddress customerAddr = new CustomerAddress();

//			Map<String, String> supplierObj = null;
//			if (req != null) {
//				supplierObj = splitQueryFromHtml(req);
//
//				for(Entry<String, String> entry: supplierObj.entrySet()) {
				for(Entry<String, Object> entry: payload.entrySet()) {
			

					System.out.println(entry.getKey() + " : " + entry.getValue());

					if(entry.getValue() == null) {
						System.out.println("You have to fill all information");
						break;
					}
					else {
						if(entry.getKey().equals("cname")) {

							entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
							System.out.println(entry.getValue());

							customer.setFirstName((String) entry.getValue());
							System.out.println(entry.getKey());

						}
						else if(entry.getKey().equals("id")) {
							customer.setId(Long.parseLong((String)entry.getValue()));
						}
						else if(entry.getKey().equals("cid")) {

							//entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
							System.out.println(entry.getValue());

							customer.setId((Integer) entry.getValue());
							System.out.println(entry.getKey());

						}
						else if(entry.getKey().equals("clastname")) {

							entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
							System.out.println(entry.getValue());

							customer.setLastName((String) entry.getValue());
							System.out.println(entry.getKey());

						}
						else if(entry.getKey().equals("cphone")) {

							entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
							System.out.println(entry.getValue());

							customer.setPhone((String) entry.getValue());
							System.out.println(entry.getKey());

						}
						else if(entry.getKey().equals("street")) {

							entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
							System.out.println(entry.getValue());

							customerAddr.setStreet((String) entry.getValue());
							System.out.println(entry.getKey());

						}
						else if(entry.getKey().equals("city")) {

							entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
							System.out.println(entry.getValue());

							customerAddr.setCity((String) entry.getValue());
							System.out.println(entry.getKey());

						}
						else if(entry.getKey().equals("state")) {

							entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
							System.out.println(entry.getValue());

							customerAddr.setState((String) entry.getValue());
							System.out.println(entry.getKey());

						}
						else if(entry.getKey().equals("zcode")) {

							entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
							System.out.println(entry.getValue());

							customerAddr.setZcode((String) entry.getValue());
							System.out.println(entry.getKey());

						}
						else if(entry.getKey().equals("credcardnumber")) {

							creditcard.setCredcardnumber((String) entry.getValue());
							System.out.println(entry.getKey());

						}
						else if(entry.getKey().equals("cvcnumber")) {

							creditcard.setCvcnumber(Integer.parseInt((String) entry.getValue()));
							System.out.println(entry.getKey());

						}
						else if(entry.getKey().equals("expdate")) {

							creditcard.setExpdate(Date.valueOf((String) entry.getValue()));
							System.out.println(entry.getKey());

						}
					}
				}
//			}

			if (dao.getCustomerById(customer.getId()) == null) {
				//jsonify error Response http
				System.out.println("No customer with that id.");
				return null;
			}
			dao.updateCustomer(customer, customerAddr);
			dao.updateCreditCard(creditcard, customer);
			return customer;
	}

	/*
	 * En el insert se tienen que proveer todas las columnas
	 * En vez de verificar el length de la data inserted puedo
	 * probar if(col1!=null && col2!=null && ... )
	 */
	public Customers insertCustomer(Map<String, Object> payload) throws IOException {
//		String req = request.getReader().readLine();
//		System.out.println("Estoy aqui: " + req);
//
//		Map<String, String> resourceObj = null;
//		if (req != null) {
//			resourceObj = splitQueryFromHtml(req);
			Customers customer = new Customers();
			CustomerAddress customerAddr = new CustomerAddress();
			CreditCard creditcard = new CreditCard();

//			for(Entry<String, String> entry: resourceObj.entrySet()) {
			for(Entry<String, Object> entry: payload.entrySet()) {

				System.out.println(entry.getKey() + " : " + entry.getValue());

				if(entry.getValue() == null) {
					//length of data inserted is not equal to the number of columns
					System.out.println("You have to fill all information");
					break;
				}
				else {
					if(entry.getKey().equals("cname")) {

						entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
						System.out.println(entry.getValue());

						customer.setFirstName((String) entry.getValue());
						System.out.println(entry.getKey());

					}
					else if(entry.getKey().equals("clastname")) {

						entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
						System.out.println(entry.getValue());

						customer.setLastName((String) entry.getValue());
						System.out.println(entry.getKey());

					}
					else if(entry.getKey().equals("cphone")) {

						entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
						System.out.println(entry.getValue());

						customer.setPhone((String) entry.getValue());
						System.out.println(entry.getKey());

					}
					else if(entry.getKey().equals("street")) {

						entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
						System.out.println(entry.getValue());

						customerAddr.setStreet((String) entry.getValue());
						System.out.println(entry.getKey());

					}
					else if(entry.getKey().equals("city")) {

						entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
						System.out.println(entry.getValue());

						customerAddr.setCity((String) entry.getValue());
						System.out.println(entry.getKey());

					}
					else if(entry.getKey().equals("state")) {

						entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
						System.out.println(entry.getValue());

						customerAddr.setState((String) entry.getValue());
						System.out.println(entry.getKey());

					}
					else if(entry.getKey().equals("zcode")) {

						entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
						System.out.println(entry.getValue());

						customerAddr.setZcode((String) entry.getValue());
						System.out.println(entry.getKey());

					}
					else if(entry.getKey().equals("credcardnumber")) {

						creditcard.setCredcardnumber((String) entry.getValue());
						System.out.println(entry.getKey());

					}
					else if(entry.getKey().equals("cvcnumber")) {

						creditcard.setCvcnumber(Integer.parseInt((String) entry.getValue()));
						System.out.println(entry.getKey());

					}
					else if(entry.getKey().equals("expdate")) {

						creditcard.setExpdate(Date.valueOf((String) entry.getValue()));
						System.out.println(entry.getKey());

					}

				}
			}
			System.out.println(customer);
			dao.insertCustomers(customer);
			System.out.println(customerAddr);
			dao.insertCustomerAddress(customerAddr, customer);
			dao.insertCreditCard(creditcard, customer);
//		}	
		return null;
	}

	public ArrayList<Category> getAllCategories(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		Map<String, String> query_pairs = null;
		logger.info("Im in getAllCategories Method");

		if (req != null) {
			query_pairs = splitQuery(request);

			for(Entry<String, String> entry: query_pairs.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}

		ArrayList<Category> categoryList = dao.getAllCategories(query_pairs);

		return categoryList;
	}

	public Category getCategoryById(int cat_id) {
		logger.info("Im on getCategoryById Method");
		return dao.getCategoryById(cat_id);
	}

	public ArrayList<SubCategory> getAllSubCategories(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		Map<String, String> query_pairs = null;
		logger.info("Im in getAllSubCategories Method");

		if (req != null) {
			query_pairs = splitQuery(request);

			for(Entry<String, String> entry: query_pairs.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}

		ArrayList<SubCategory> subcategoryList = dao.getAllSubCategories(query_pairs);

		return subcategoryList;
	}

	public SubCategory getSubCategoryById(int subcat_id) {
		logger.info("Im on getSubCategoryById Method");
		return dao.getSubCategoryById(subcat_id);
	}

	public ArrayList<SupplierAddress> getAllSupplierAddress(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		Map<String, String> query_pairs = null;
		logger.info("Im in getAllSupplierAddress Method");

		if (req != null) {
			query_pairs = splitQuery(request);

			for(Entry<String, String> entry: query_pairs.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}

		ArrayList<SupplierAddress> supplieraddressList = dao.getAllSupplierAddress(query_pairs);

		return supplieraddressList;
	}

	public SupplierAddress getSupplierAddressById(int supadd_id) {
		logger.info("Im on getSupplierAddressById Method");
		return dao.getSupplierAddressById(supadd_id);
	}
	
	public SupplierAddress getSupplierAddressBySupplierId(long sid) {
		logger.info("Im on getSupplierAddressBySupplierId Method");
		return dao.getSupplierAddressBySupplierId(sid);
	}

	public ArrayList<CustomerAddress> getAllCustomerAddress(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		Map<String, String> query_pairs = null;
		logger.info("Im in getAllCustomerAddress Method");

		if (req != null) {
			query_pairs = splitQuery(request);

			for(Entry<String, String> entry: query_pairs.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}

		ArrayList<CustomerAddress> customeraddressList = dao.getAllCustomerAddress(query_pairs);

		return customeraddressList;
	}

	public CustomerAddress getCustomerAddressById(int cusadd_id) {
		logger.info("Im on getCustomerAddressById Method");
		return dao.getCustomerAddressById(cusadd_id);
	}

	public CustomerAddress getCustomerAddressByCustomerId(long cid) {
		logger.info("Im on getCustomerAddressByCustomerId Method");
		return dao.getCustomerAddressByCustomerId(cid);
	}
	
	public ArrayList<City> getAllCities(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		Map<String, String> query_pairs = null;
		logger.info("Im in getAllCities Method");

		if (req != null) {
			query_pairs = splitQuery(request);

			for(Entry<String, String> entry: query_pairs.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}

		ArrayList<City> cityList = dao.getAllCities(query_pairs);

		return cityList;
	}

	public City getCityById(int cityId) {
		logger.info("Im on getCityById Method");
		return dao.getCityByID(cityId);
	}

	public ArrayList<Announcement> getAllAnnouncements(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		Map<String, String> query_pairs = null;
		logger.info("Im in getAllAnnouncement Method");

		if (req != null) {
			query_pairs = splitQuery(request);

			for(Entry<String, String> entry: query_pairs.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}

		ArrayList<Announcement> announcementList = dao.getAllAnnouncements(query_pairs);

		return announcementList;
	}

	public ArrayList<AnnouncementSearch> searchAnnouncement(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		String searchTerm = "";
		logger.info("Im in searchAnnouncement Method");
		Map<String, String> query_pairs = null;
		if (req != null) {
			query_pairs = splitQuery(request);
			if(query_pairs.containsKey("searchterm")) {
				searchTerm = query_pairs.get("searchterm");
			}
		}

		ArrayList<AnnouncementSearch> annoucementsList = dao.searchAnnouncement(searchTerm);

		return annoucementsList;
	}

	public Announcement getAnnouncementById(int annid) {
		logger.info("Im on getAnnouncementById Method");
		return dao.getAnnouncementById(annid);
	}

	/*
	 * En el insert se tienen que proveer todas las columnas
	 * En vez de verificar el length de la data inserted puedo
	 * probar if(col1!=null && col2!=null && ... )
	 */
	public Announcement insertAnnouncement(Map<String, Object> payload) throws IOException {
//		String req = request.getReader().readLine();
//		System.out.println("Estoy aqui: " + req);
//
//		Map<String, String> announcementObj = null;
//		if (req != null) {
//			announcementObj = splitQueryFromHtml(req);
			Announcement announcement = new Announcement();

//			for(Entry<String, String> entry: announcementObj.entrySet()) {
			for(Entry<String, Object> entry: payload.entrySet()) {

				System.out.println(entry.getKey() + " : " + entry.getValue());

				if(entry.getValue() == null) {
					System.out.println("You have to fill all information");
					break;
				}
				else {
					if(entry.getKey().equals("date")) {
						announcement.setAnndate(Date.valueOf((String) entry.getValue()));
						System.out.println(entry.getKey());}
					else if(entry.getKey().equals("price")) {
						announcement.setPrice(Float.parseFloat((String) entry.getValue()));
						System.out.println(entry.getKey());}
					else if(entry.getKey().equals("qty")) {
						announcement.setQty(Integer.valueOf((String) entry.getValue()));
						System.out.println(entry.getKey());}
					else if(entry.getKey().equals("sid")) {
						announcement.setSid(Integer.valueOf((String) entry.getValue()));	
						System.out.println(entry.getKey());}
					else if(entry.getKey().equals("rid")) {
						announcement.setRid((Integer)entry.getValue());	
						System.out.println(entry.getKey());}
					else if(entry.getKey().equals("expdate")) {
						announcement.setExpdate(Date.valueOf((String) entry.getValue()));
						System.out.println(entry.getKey());}
				}
			}
			System.out.println(announcement);
			dao.insertAnnouncement(announcement);
//		}	
		return null;
	}

	public ArrayList<Request> getAllRequests(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		Map<String, String> query_pairs = null;
		logger.info("Im in getAllRequests Method");

		if (req != null) {
			query_pairs = splitQuery(request);

			for(Entry<String, String> entry: query_pairs.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}

		ArrayList<Request> requestList = dao.getAllRequests(query_pairs);

		return requestList;
	}

	public ArrayList<RequestSearch> searchRequests(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		String searchTerm = "";
		logger.info("Im in searchRequests Method");
		Map<String, String> query_pairs = null;
		if (req != null) {
			query_pairs = splitQuery(request);
			if(query_pairs.containsKey("searchterm")) {
				searchTerm = query_pairs.get("searchterm");
			}
		}

		ArrayList<RequestSearch> requestList = dao.searchRequests(searchTerm);

		return requestList;
	}

	public Request getRequestById(int reqid) {
		logger.info("Im on getRequestById Method");
		return dao.getRequestById(reqid);
	}

	/*
	 * En el insert se tienen que proveer todas las columnas
	 * En vez de verificar el length de la data inserted puedo
	 * probar if(col1!=null && col2!=null && ... )
	 */
	public Request insertRequest(Map<String, Object> payload) throws IOException {
//		String req = request.getReader().readLine();
//		System.out.println("Estoy aqui: " + req);
//
//		Map<String, String> requestObj = null;
//		if (req != null) {
//			requestObj = splitQueryFromHtml(req);
			Request requ = new Request();
			Location loc = new Location();

//			for(Entry<String, String> entry: requestObj.entrySet()) {
			for(Entry<String, Object> entry: payload.entrySet()) {

				System.out.println(entry.getKey() + " : " + entry.getValue());

				if(entry.getValue() == null) {
					System.out.println("You have to fill all information");
					break;
				}
				else {
					if(entry.getKey().equals("qty")) {
						requ.setQty(Integer.valueOf((String) entry.getValue()));
						System.out.println(entry.getKey());}
					else if(entry.getKey().equals("cid")) {
						requ.setCid(Integer.valueOf((String) entry.getValue()));	
						System.out.println(entry.getKey());}
					else if(entry.getKey().equals("rid")) {
						requ.setRid((Integer) entry.getValue());
						System.out.println(entry.getKey());}
					else if(entry.getKey().equals("latitude")) {
						loc.setLatitude((String) entry.getValue());
						System.out.println(entry.getKey());}
					else if(entry.getKey().equals("longitude")) {
						loc.setLongitude((String) entry.getValue());
						System.out.println(entry.getKey());}
					else if(entry.getKey().equals("reqdate")) {
						requ.setReqdate(Date.valueOf((String) entry.getValue()));
						System.out.println(entry.getKey());}
					}
				}
			System.out.println(requ);
			dao.insertRequest(requ, loc);
//		}	
		return null;
	}

	public ArrayList<Location> getAllLocations(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		Map<String, String> query_pairs = null;
		logger.info("Im in getAllLocations Method");

		if (req != null) {
			query_pairs = splitQuery(request);

			for(Entry<String, String> entry: query_pairs.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}

		ArrayList<Location> locationList = dao.getAllLocations(query_pairs);

		return locationList;
	}

	public Location getLocationById(int locid) {
		logger.info("Im on getLocationsById Method");
		return dao.getLocationById(locid);
	}

	public ArrayList<Purchase> getAllPurchases(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		Map<String, String> query_pairs = null;
		logger.info("Im in getAllPurchases Method");

		if (req != null) {
			query_pairs = splitQuery(request);

			for(Entry<String, String> entry: query_pairs.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}

		ArrayList<Purchase> purchaseList = dao.getAllPurchases(query_pairs);

		return purchaseList;
	}

	public ArrayList<PurchaseSearch> searchPurcahses(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		String searchTerm = "";
		logger.info("Im in searchPurchases Method");
		Map<String, String> query_pairs = null;
		if (req != null) {
			query_pairs = splitQuery(request);
			if(query_pairs.containsKey("searchterm")) {
				searchTerm = query_pairs.get("searchterm");
			}
		}

		ArrayList<PurchaseSearch> purchaseList = dao.searchPurchase(searchTerm);

		return purchaseList;
	}

	public Purchase getPurchaseById(int purid) {
		logger.info("Im on getPurchaseById Method");
		return dao.getPurchaseById(purid);
	}

	/*
	 * En el insert se tienen que proveer todas las columnas
	 * En vez de verificar el length de la data inserted puedo
	 * probar if(col1!=null && col2!=null && ... )
	 */
	public Purchase insertPurchase(Map<String, Object> payload) throws IOException {
//		String req = request.getReader().readLine();
//		System.out.println("Estoy aqui: " + req);
//
//		Map<String, String> purchaseObj = null;
//		if (req != null) {
//			purchaseObj = splitQueryFromHtml(req);
			Purchase purchase = new Purchase();

//			for(Entry<String, String> entry: purchaseObj.entrySet()) {
			for(Entry<String, Object> entry: payload.entrySet()) {

				System.out.println(entry.getKey() + " : " + entry.getValue());

				if(entry.getValue() == null) {
					System.out.println("You have to fill all information");
					break;
				}
				else {
					if(entry.getKey().equals("qty")) {
						purchase.setQty(Integer.valueOf((String) entry.getValue()));
						System.out.println(entry.getKey());}
					else if(entry.getKey().equals("cid")) {
						purchase.setCid(Integer.valueOf((String) entry.getValue()));	
						System.out.println(entry.getKey());}
					else if(entry.getKey().equals("rid")) {
						purchase.setRid((Integer) entry.getValue());
						System.out.println(entry.getKey());}
					else if(entry.getKey().equals("sid")) {
						purchase.setSid(Integer.parseInt((String) entry.getValue()));
						System.out.println(entry.getKey());}
					else if(entry.getKey().equals("credcardnumber")) {
						purchase.setCredcardnumber((String) entry.getValue());
						System.out.println(entry.getKey());}
					else if(entry.getKey().equals("purprice")) {
						purchase.setPurprice(Float.parseFloat((String)entry.getValue()));
						System.out.println(entry.getKey());}
				}
			}
			//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			//Date date = new Date(0);
			//purchase.setPurdate(Date.);
			String credNum = getCreditCardByCustomerId(purchase.getCid()).getCredcardnumber();
			purchase.setCredcardnumber(credNum);
			System.out.println(purchase);
			dao.insertPurchase(purchase);
//		}	
		return null;
	}

	public ArrayList<CreditCard> getAllCreditCards(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		Map<String, String> query_pairs = null;
		logger.info("Im in getAllCreditCards Method");

		if (req != null) {
			query_pairs = splitQuery(request);

			for(Entry<String, String> entry: query_pairs.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}

		ArrayList<CreditCard> creditcardList = dao.getAllCreditCards(query_pairs);

		return creditcardList;
	}

	public CreditCard getCreditCardById(String credcardnumber) {
		logger.info("Im on getCreditCardById Method");
		return dao.getCreditCardById(credcardnumber);
	}
	
	public CreditCard getCreditCardByCustomerId(long cid) {
		logger.info("Im on getCreditCardById Method");
		return dao.getCreditCardByCustomerId(cid);
	}

	/*
	 * En el update no tengo que incluir todas las columnas, por lo que
	 * en el if puedo probar que columnas no son null y solo añadir esas
	 */
	public CreditCard updateCreditCard(Map<String, Object> payload) throws IOException {
		
//		String req = request.getReader().readLine();
//		System.out.println("Estoy aqui: " + req);
		CreditCard creditcard = new CreditCard();

//		Map<String, String> resourceObj = null;
//		if (req != null) {
//			resourceObj = splitQueryFromHtml(req);

//			for(Entry<String, String> entry: resourceObj.entrySet()) {
		for(Entry<String, Object> entry: payload.entrySet()) {

				System.out.println(entry.getKey() + " : " + entry.getValue());

				if(entry.getValue() == null) {
					System.out.println("You have to fill all information");
					break;
				}
				else {
					if(entry.getKey().equals("holdername")) {

						entry.setValue(((String) entry.getValue()).replaceAll("%20", " "));
						System.out.println(entry.getValue());

						creditcard.setHoldername((String) entry.getValue());
						System.out.println(entry.getKey());

					}
					else if(entry.getKey().equals("credcardnumber")) {
						creditcard.setCredcardnumber((String) entry.getValue());
						System.out.println(entry.getKey());}
					else if(entry.getKey().equals("qtyperpk")) {
						creditcard.setExpdate(Date.valueOf((String) entry.getValue()));
						System.out.println(entry.getKey());}
					else if(entry.getKey().equals("cvcnumber")) {
						creditcard.setCvcnumber(Integer.valueOf((String) entry.getValue()));	
						System.out.println(entry.getKey());}
					else if(entry.getKey().equals("cid")) {
						creditcard.setCid(Integer.valueOf((String) entry.getValue()));
						System.out.println(entry.getKey());}
				}
			}
//		}

		if (dao.getCreditCardById(creditcard.getCredcardnumber()) == null) {
			//jsonify error Response http
			System.out.println("No credit card with that id.");
			return null;
		}
		//dao.updateCreditCard(creditcard);
		return creditcard;
	}

	public ArrayList<Supplies> getAllSupplies(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		Map<String, String> query_pairs = null;
		logger.info("Im in getAllSupplies Method");

		if (req != null) {
			query_pairs = splitQuery(request);

			for(Entry<String, String> entry: query_pairs.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}

		ArrayList<Supplies> suppliesList = dao.getAllSupplies(query_pairs);

		return suppliesList;
	}

	public ArrayList<Supplies> getSuppliesBySupplierId(int sid) {
		logger.info("Im on getSuppliesBySupplierId Method");
		return dao.getSuppliesBySupplierId(sid);
	}

	
	
	
	
	
	//=================================================================

	private static Map<String, String> splitQuery(HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String, String> query_pairs = new HashMap<String, String>();
		String req = request.getQueryString();
		String[] pairs = req.split("&");
		for (String pair : pairs) {
			int idx = pair.indexOf("=");
			query_pairs.put(pair.substring(0, idx), pair.substring(idx + 1));
		}
		return query_pairs;
	}

	private static Map<String, String> splitQueryFromHtml(String req) throws UnsupportedEncodingException {
		Map<String, String> query_pairs = new HashMap<String, String>();
		//String req = req.getQueryString();
		String[] pairs = req.split("&");
		for (String pair : pairs) {
			int idx = pair.indexOf("=");
			query_pairs.put(pair.substring(0, idx), pair.substring(idx + 1));
		}
		return query_pairs;
	}

}
