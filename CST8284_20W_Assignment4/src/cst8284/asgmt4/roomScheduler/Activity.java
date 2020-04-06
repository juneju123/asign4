/*File name:[Activity.java]
Author:[Ziyue Wang 040919399]
Course:CST8384-OOP
Assignment:[3]
Date:2020-03-28
Professor:[Dave Houtman]
Purpose:[collect user's activity information] 
*/ 
package cst8284.asgmt4.roomScheduler;
import java.io.Serializable;
/**
 * @author:Ziyue Wang
 * @version 1.0
*/ 
public class Activity implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The description. */
	private String description;
	
	/** The category. */
	private String category;

	/**
	 * Chaining to next constructor 
	 */
	public Activity() {
		this("", "");
	}

	/**
	 * Instantiates a new activity.
	 *
	 * @param description  	the description
	 * @param category 		the category
	 */
	public Activity(String description, String category) {
		setDescription(description);
		setCategory(category);
	}

	/**
	 * if input is not null
	 * Sets the description.
	 * field description is set and modified by this method
	 * 
	 * @param description 		sets the new description
	 */
	// setters and getters for all private instances
	public void setDescription(String description) {
		if(RoomScheduler.isGoodGeneralInput(description))this.description = description;
	}

	/**
	 * if input is not null
	 * Sets the Category.
	 * field Category is set and modified by this method
	 * @param category 		sets the new category
	 */
	public void setCategory(String category) {
		if(RoomScheduler.isGoodGeneralInput(category))this.category = category;
	}

	/**
	 * Gets the description.
	 * field description is accessed only by this method
	 * @return the description of users 
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Gets the category.
	 * field category is accessed only by this method
	 * @return 		the category of users
	 */
	public String getCategory() {
		return this.category;
	}
	
	/**
	 * It returns a string with category and its description.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Event: " + this.getCategory() + "\n" + "Description: " + this.getDescription() + "\n";
	}

}
