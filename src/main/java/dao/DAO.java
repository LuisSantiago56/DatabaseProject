package dao;

import handler.JsonRespond;

public class DAO {

	
	public String getAllResources() {
		// TODO Auto-generated method stub
		return JsonRespond.getAllResources();
	}
	
	public String getResourcesById(int rid) {
		
		return JsonRespond.getResourcesById();
	}

	public String getAllSuppliers() {
		// TODO Auto-generated method stub
		return JsonRespond.getAllSuppliers();
	}
	
	public String getSupplierById(int sid) {
		// TODO Auto-generated method stub
		return JsonRespond.getSupplierById();
	}

	public String getAllCustomers() {
		// TODO Auto-generated method stub
		return JsonRespond.getAllCustomers();
	}

	public String getCustomerById(int cid) {
		// TODO Auto-generated method stub
		return JsonRespond.getCustomerById();
	}

	public String getAllTowns() {
		// TODO Auto-generated method stub
		return JsonRespond.getAllTowns();
	}

	public String getTownById(int tid) {
		// TODO Auto-generated method stub
		return JsonRespond.getTownById();
	}

	public String getRegionById(int reg_id) {
		// TODO Auto-generated method stub
		return JsonRespond.getRegionById();
	}

	public String getAllCategories() {
		// TODO Auto-generated method stub
		return JsonRespond.getAllCategories();
	}

	public String getCategoryById(int cat_id) {
		// TODO Auto-generated method stub
		return JsonRespond.getCategoryById();
	}

	

	

}
