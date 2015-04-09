package com.tc.entity;

public class Product {
	//condition、city、location_countries、overall_status、phase、gender、criteria、
	//<condition>Gastrointestinal Stromal Tumor</condition>
	/*
	 * <location>
    <facility>
      <name>Aria Health-Torresdale Campus</name>
      <address>
        <city>Philadelphia</city>
        <state>Pennsylvania</state>
        <zip>19114</zip>
        <country>United States</country>
      </address>
    </facility>
  </location>
	 * */
	/* <location_countries>
    *<country>United States</country>
    *<country>Canada</country>
  	*</location_countries>
	 * 
	 * */
	/*
	 * <overall_status>Active, not recruiting</overall_status>
	 * */
	/*
	 * <phase>Phase 3</phase>
	 * */
	
	/*
	 * <gender>Both</gender>
	 * */
	/*
	 * <criteria>
	      <textblock>
	        Inclusion Criteria:
	       </textblock>
    	</criteria>
	 * */
	
	  private String id ; 				//基因ID
	  private String condition;			//片段1
	  private String city;  			//片段2
	  private String location_countries;  //片段3
	  private String overall_status;	//片段4
	  private String phase;				//片段5
	  private String gender;			//片段6
	  private String criteria;			//片段7
	  
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocation_countries() {
		return location_countries;
	}
	public void setLocation_countries(String location_countries) {
		this.location_countries = location_countries;
	}
	public String getOverall_status() {
		return overall_status;
	}
	public void setOverall_status(String overall_status) {
		this.overall_status = overall_status;
	}
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCriteria() {
		return criteria;
	}
	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	
}
