package edu.ncsu.csc326.coffeemaker;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

public class EditRecipeTest {
	private CoffeeMaker cm;
	private Recipe r1;
	private Recipe r2;
	private Recipe r3;
	private Recipe r4;

	@Before
	public void setUp() throws Exception {
		cm = new CoffeeMaker();

		// Set up for r1
		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setAmtChocolate("0");
		r1.setAmtCoffee("3");
		r1.setAmtMilk("1");
		r1.setAmtSugar("1");
		r1.setPrice("50");

		// Set up for r2
		r2 = new Recipe();
		r2.setName("Mocha");
		r2.setAmtChocolate("20");
		r2.setAmtCoffee("3");
		r2.setAmtMilk("1");
		r2.setAmtSugar("1");
		r2.setPrice("75");

		// Set up for r3
		r3 = new Recipe();
		r3.setName("Latte");
		r3.setAmtChocolate("0");
		r3.setAmtCoffee("3");
		r3.setAmtMilk("3");
		r3.setAmtSugar("1");
		r3.setPrice("100");

		// Set up for r4
		r4 = new Recipe();
		r4.setName("Hot Chocolate");
		r4.setAmtChocolate("4");
		r4.setAmtCoffee("0");
		r4.setAmtMilk("1");
		r4.setAmtSugar("1");
		r4.setPrice("65");

		cm.addRecipe(r1);
		cm.addRecipe(r2);
		cm.addRecipe(r3);
	}

	@Test
	public void checkRecipeCount() {
		Assert.assertThat(cm.getRecipes().length, Is.is(3));
		for (int i = 0; i < cm.getRecipes().length; i++) {
			Assert.assertNotNull(cm.getRecipes()[i]);
		}
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void chooseInvalifRecipe() {
		int outOfBounce = Integer.MAX_VALUE;
		Recipe recipe = cm.getRecipes()[outOfBounce];
	}

	@Test(expected = NumberFormatException.class)
	public void wrongNumber() {
		Recipe recipe = cm.getRecipes()[Integer.valueOf("Test")];
	}

	@Test
	public void nullRecipe() throws RecipeException {
		cm.addRecipe(new Recipe());
		Recipe newOne = new Recipe();
		newOne.setName("Hot Chocolate2");
		newOne.setAmtChocolate("4");
		newOne.setAmtCoffee("0");
		newOne.setAmtMilk("1");
		newOne.setAmtSugar("1");
		newOne.setPrice("65");

		Assert.assertNull(cm.editRecipe(cm.getRecipes().length - 1, newOne));
	}

	@Test
	public void changeRecipeName() {
		int number = 0;

		Recipe recipe = cm.getRecipes()[number];
		Assert.assertNotNull(recipe);

		String oldName = recipe.getName();
		recipe.setName("ChangedName");
		Assert.assertNull(cm.editRecipe(number, recipe));

		recipe = cm.getRecipes()[number];
		Assert.assertEquals(oldName, recipe.getName());
	}

	@Test
	public void testPropertyChange() throws RecipeException {
		int number = 0;

		Recipe recipe = cm.getRecipes()[number];
		Assert.assertNotNull(recipe);

		recipe.setAmtChocolate("20");
		Assert.assertEquals(recipe.getName(), cm.editRecipe(number, recipe));

		recipe = cm.getRecipes()[number];
		Assert.assertEquals(20, recipe.getAmtChocolate());
	}

}
