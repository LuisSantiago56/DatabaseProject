package handler;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class JsonRespond {
	
	
	public final static String getAllCategories() {
		JSONParser parser = new JSONParser();
		String jsonObj = "";
        try
        {
            Object object = parser.parse(new FileReader("JSON Files/getAllCategories.json"));
            //convert Object to JSONObject
            JSONArray jsonObject = (JSONArray)object;
            //convert JSONObject to string
            jsonObj = jsonObject.toString();
         
        }
        catch(FileNotFoundException fnfe)
        {
        		fnfe.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		return jsonObj;
	}
	
	public final static String getCategoryById() {
		JSONParser parser = new JSONParser();
		String jsonObj = "";
        try
        {
            Object object = parser.parse(new FileReader("JSON Files/getCategoryById.json"));
            //convert Object to JSONObject
            JSONObject jsonObject = (JSONObject)object;
            //convert JSONObject to string
            jsonObj = jsonObject.toString();
         
        }
        catch(FileNotFoundException fnfe)
        {
        		fnfe.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		return jsonObj;
	}
	
	public final static String getAllCustomers() {
		JSONParser parser = new JSONParser();
		String jsonObj = "";
        try
        {
            Object object = parser.parse(new FileReader("JSON Files/getAllCustomers.json"));
            //convert Object to JSONObject
            JSONArray jsonObject = (JSONArray)object;
            //convert JSONObject to string
            jsonObj = jsonObject.toString();
         
        }
        catch(FileNotFoundException fnfe)
        {
        		fnfe.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		return jsonObj;
	}
	
	public final static String getCustomerById() {
		JSONParser parser = new JSONParser();
		String jsonObj = "";
        try
        {
            Object object = parser.parse(new FileReader("JSON Files/getAllCustomerById.json"));
            //convert Object to JSONObject
            JSONObject jsonObject = (JSONObject)object;
            //convert JSONObject to string
            jsonObj = jsonObject.toString();
         
        }
        catch(FileNotFoundException fnfe)
        {
        		fnfe.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		return jsonObj;
	}
	
	public final static String getAllRegions() {
		JSONParser parser = new JSONParser();
		String jsonObj = "";
        try
        {
            Object object = parser.parse(new FileReader("JSON Files/getAllRegions.json"));
            //convert Object to JSONObject
            JSONArray jsonObject = (JSONArray)object;
            //convert JSONObject to string
            jsonObj = jsonObject.toString();
         
        }
        catch(FileNotFoundException fnfe)
        {
        		fnfe.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		return jsonObj;
	}
	
	public final static String getRegionById() {
		JSONParser parser = new JSONParser();
		String jsonObj = "";
        try
        {
            Object object = parser.parse(new FileReader("JSON Files/getAllRegionById.json"));
            //convert Object to JSONObject
            JSONObject jsonObject = (JSONObject)object;
            //convert JSONObject to string
            jsonObj = jsonObject.toString();
         
        }
        catch(FileNotFoundException fnfe)
        {
        		fnfe.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		return jsonObj;
	}
	
	public final static String getAllResources() {
		JSONParser parser = new JSONParser();
		String jsonObj = "";
        try
        {
            Object object = parser.parse(new FileReader("JSON Files/getAllResources.json"));
            //convert Object to JSONObject
	            JSONArray jsonObject = (JSONArray)object;
            //convert JSONObject to string
            jsonObj = jsonObject.toString();
         
        }
        catch(FileNotFoundException fnfe)
        {
        		fnfe.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		return jsonObj;
	}
	
	public final static String getResourcesById() {
		JSONParser parser = new JSONParser();
		String jsonObj = "";
        try
        {
            Object object = parser.parse(new FileReader("JSON Files/getResourcesById.json"));
            //convert Object to JSONObject
            JSONObject jsonObject = (JSONObject)object;
            //convert JSONObject to string
            jsonObj = jsonObject.toString();
         
        }
        catch(FileNotFoundException fnfe)
        {
        		fnfe.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		return jsonObj;
	}
	
	public final static String getAllSuppliers() {
		JSONParser parser = new JSONParser();
		String jsonObj = "";
        try
        {
            Object object = parser.parse(new FileReader("JSON Files/getAllSuppliers.json"));
            //convert Object to JSONObject
            JSONArray jsonObject = (JSONArray)object;
            //convert JSONObject to string
            jsonObj = jsonObject.toString();
         
        }
        catch(FileNotFoundException fnfe)
        {
        		fnfe.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		return jsonObj;
	}
	public final static String getSupplierById() {
		JSONParser parser = new JSONParser();
		String jsonObj = "";
        try
        {
            Object object = parser.parse(new FileReader("JSON Files/getAllSupplierById.json"));
            //convert Object to JSONObject
            JSONObject jsonObject = (JSONObject)object;
            //convert JSONObject to string
            jsonObj = jsonObject.toString();
         
        }
        catch(FileNotFoundException fnfe)
        {
        		fnfe.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		return jsonObj;
	}
	
	public final static String getAllTowns() {
		JSONParser parser = new JSONParser();
		String jsonObj = "";
        try
        {
            Object object = parser.parse(new FileReader("JSON Files/getAllTowns.json"));
            //convert Object to JSONObject
            JSONArray jsonObject = (JSONArray)object;
            //convert JSONObject to string
            jsonObj = jsonObject.toString();
         
        }
        catch(FileNotFoundException fnfe)
        {
        		fnfe.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		return jsonObj;
	}
	
	public final static String getTownById() {
		JSONParser parser = new JSONParser();
		String jsonObj = "";
        try
        {
            Object object = parser.parse(new FileReader("JSON Files/getAllTownById.json"));
            //convert Object to JSONObject
            JSONArray jsonObject = (JSONArray)object;
            //convert JSONObject to string
            jsonObj = jsonObject.toString();
         
        }
        catch(FileNotFoundException fnfe)
        {
        		fnfe.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
		return jsonObj;
	}
        
}
