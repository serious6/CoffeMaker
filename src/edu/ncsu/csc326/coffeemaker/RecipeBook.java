package edu.ncsu.csc326.coffeemaker;

public class RecipeBook {

	/** Array of recipes in coffee maker */
	private Recipe[] recipeArray;
	/** Number of recipes in coffee maker */
	private final int NUM_RECIPES = 3;

	/**
	 * Default constructor for a RecipeBook.
	 */
	public RecipeBook() {
		recipeArray = new Recipe[NUM_RECIPES];
	}

	/**
	 * Returns the recipe array.
	 * 
	 * @param r
	 * @return Recipe[]
	 */
	public synchronized Recipe[] getRecipes() {
		Recipe[] copy = new Recipe[recipeArray.length];
		for (int i = 0; i < recipeArray.length; i++) {
			if (recipeArray[i] != null) {
				copy[i] = new Recipe(recipeArray[i]);
			} else {
				copy[i] = null;
			}
		}
		return copy;
	}

	public synchronized boolean addRecipe(Recipe r) {
		// Assume recipe doesn't exist in the array until
		// find out otherwise
		boolean exists = false;
		// Check that recipe doesn't already exist in array
		for (int i = 0; i < recipeArray.length; i++) {
			if (r.equals(recipeArray[i])) {
				exists = true;
			}
		}
		// Assume recipe cannot be added until find an empty
		// spot
		boolean added = false;
		// Check for first empty spot in array
		if (!exists) {
			if (validate(r)) {
				for (int i = 0; i < recipeArray.length && !added
						&& i <= recipeArray.length; i++) {
					if (recipeArray[i] == null) {
						recipeArray[i] = r;
						added = true;
					}
				}
			}
		}
		return added;
	}

	private boolean validate(Recipe r) {
		return r != null && r.getAmtChocolate() >= 0 && r.getAmtCoffee() >= 0
				&& r.getAmtMilk() >= 0 && r.getAmtSugar() >= 0
				&& r.getName() != null && r.getPrice() >= 0;
	}

	/**
	 * Returns the name of the recipe deleted at the position specified and null
	 * if the recipe does not exist.
	 * 
	 * @param recipeToDelete
	 * @return String
	 */
	public synchronized String deleteRecipe(int recipeToDelete) {
		if (recipeArray[recipeToDelete] != null) {
			String recipeName = recipeArray[recipeToDelete].getName();
			recipeArray[recipeToDelete] = new Recipe();
			return recipeName;
		} else {
			return null;
		}
	}

	/**
	 * Returns the name of the recipe edited at the position specified and null
	 * if the recipe does not exist.
	 * 
	 * @param recipeToEdit
	 * @param newRecipe
	 * @return String
	 */
	public synchronized String editRecipe(int recipeToEdit, Recipe newRecipe) {
		if (recipeArray[recipeToEdit] != null) {
			String recipeName = recipeArray[recipeToEdit].getName();
			if (recipeName.equals(newRecipe.getName())) { // Name darf nicht
															// geändert werden
				newRecipe.setName("");
				recipeArray[recipeToEdit] = newRecipe;
				return recipeName;
			}
		}
		return null;
	}

}
