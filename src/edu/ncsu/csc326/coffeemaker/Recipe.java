package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

/**
 * @author Sarah Heckman
 */
public class Recipe implements Cloneable {
	private String name;
	private int price;
	private int amtCoffee;
	private int amtMilk;
	private int amtSugar;
	private int amtChocolate;

	/**
	 * Creates a default recipe for the coffee maker.
	 */
	public Recipe() {
		this.name = "";
		this.price = -1;
		this.amtCoffee = -1;
		this.amtMilk = -1;
		this.amtSugar = -1;
		this.amtChocolate = -1;
	}

	public Recipe(Recipe r) {
		this();
		if (r != null) {
			this.name = r.getName();
			this.price = r.getPrice();
			this.amtChocolate = r.getAmtChocolate();
			this.amtCoffee = r.getAmtCoffee();
			this.amtMilk = r.getAmtMilk();
			this.amtSugar = r.getAmtSugar();
		}
	}

	/**
	 * @return Returns the amtChocolate.
	 */
	public int getAmtChocolate() {
		return amtChocolate;
	}

	/**
	 * @param amtChocolate
	 *            The amtChocolate to set.
	 */
	public void setAmtChocolate(String chocolate) throws RecipeException {
		int amtChocolate = 0;
		try {
			amtChocolate = Integer.parseInt(chocolate);
		} catch (NumberFormatException e) {
			throw new RecipeException(
					"Units of chocolate must be a positive integer");
		}
		if (amtChocolate >= 0) {
			this.amtChocolate = amtChocolate;
		} else {
			throw new RecipeException(
					"Units of chocolate must be a positive integer");
		}
	}

	/**
	 * @return Returns the amtCoffee.
	 */
	public int getAmtCoffee() {
		return Integer.valueOf(amtCoffee);
	}

	/**
	 * @param amtCoffee
	 *            The amtCoffee to set.
	 */
	public void setAmtCoffee(String coffee) throws RecipeException {
		int amtCoffee = 0;
		try {
			amtCoffee = Integer.parseInt(coffee);
		} catch (NumberFormatException e) {
			throw new RecipeException(
					"Units of coffee must be a positive integer");
		}
		if (amtCoffee >= 0) {
			this.amtCoffee = amtCoffee;
		} else {
			throw new RecipeException(
					"Units of coffee must be a positive integer");
		}
	}

	/**
	 * @return Returns the amtMilk.
	 */
	public int getAmtMilk() {
		return Integer.valueOf(amtMilk);
	}

	/**
	 * @param amtMilk
	 *            The amtMilk to set.
	 */
	public void setAmtMilk(String milk) throws RecipeException {
		int amtMilk = 0;
		try {
			amtMilk = Integer.parseInt(milk);
		} catch (NumberFormatException e) {
			throw new RecipeException(
					"Units of milk must be a positive integer");
		}
		if (amtMilk >= 0) {
			this.amtMilk = amtMilk;
		} else {
			throw new RecipeException(
					"Units of milk must be a positive integer");
		}
	}

	/**
	 * @return Returns the amtSugar.
	 */
	public int getAmtSugar() {
		return Integer.valueOf(amtSugar);
	}

	/**
	 * @param amtSugar
	 *            The amtSugar to set.
	 */
	public void setAmtSugar(String sugar) throws RecipeException {
		int amtSugar = 0;
		try {
			amtSugar = Integer.parseInt(sugar);
		} catch (NumberFormatException e) {
			throw new RecipeException(
					"Units of sugar must be a positive integer");
		}
		if (amtSugar >= 0) {
			this.amtSugar = amtSugar;
		} else {
			throw new RecipeException(
					"Units of sugar must be a positive integer");
		}
	}

	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            The name to set.
	 */
	public void setName(String name) {
		if (name != null) {
			this.name = name;
		}
	}

	/**
	 * @return Returns the price.
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            The price to set.
	 */
	public void setPrice(String price) throws RecipeException {
		int amtPrice = 0;
		try {
			amtPrice = Integer.parseInt(price);
		} catch (NumberFormatException e) {
			throw new RecipeException("Price must be a positive integer");
		}
		if (amtPrice >= 0) {
			this.price = amtPrice;
		} else {
			throw new RecipeException("Price must be a positive integer");
		}
	}

	/**
	 * Returns the name of the recipe.
	 * 
	 * @return String
	 */
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Recipe other = (Recipe) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	protected Recipe clone() {
		return new Recipe(this);
	}

}
