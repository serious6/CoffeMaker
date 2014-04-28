package edu.ncsu.csc326.coffeemaker;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

public class AddRecipeTest {

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
	}

	@Test
	public void addMoreThan3Recipes() {
		Assert.assertTrue(cm.addRecipe(r1));
		Assert.assertTrue(cm.addRecipe(r2));
		Assert.assertTrue(cm.addRecipe(r3));
		Assert.assertFalse(cm.addRecipe(r4));
	}

	@Test
	public void addRecipeTwice() {
		Assert.assertTrue(cm.addRecipe(r1));
		Assert.assertFalse(cm.addRecipe(r1));
	}

	@Test
	public void addIdenticalRecipe() throws RecipeException {
		Assert.assertTrue(cm.addRecipe(r1));

		Recipe r5 = new Recipe();
		r5.setAmtChocolate(String.valueOf(r1.getAmtChocolate()));
		r5.setAmtCoffee(String.valueOf(r1.getAmtCoffee()));
		r5.setAmtMilk((String.valueOf(r1.getAmtMilk())));
		r5.setAmtSugar((String.valueOf(r1.getAmtSugar())));
		r5.setPrice((String.valueOf(r1.getPrice())));
		r5.setName((String.valueOf(r1.getName())));

		Assert.assertFalse(cm.addRecipe(r1));
	}

	@Test
	public void addInconsistentRecipe() {
		Recipe recipe = new Recipe();
		recipe.setName("Test");

		Assert.assertFalse(cm.addRecipe(recipe));
	}
	
	@Test(expected = RecipeException.class)
	public void setPrice() throws RecipeException{
		r1.setPrice("-3");
	}

	@Test(expected = RecipeException.class)
	public void addRecipeWithWrongPrice() throws RecipeException {
		r1.setPrice("7.5");
	}

	@Test(expected = RecipeException.class)
	public void addRecipeWithWrongUnit() throws RecipeException {
		r1.setAmtChocolate("7.0");
	}

	@Test(expected = RecipeException.class)
	public void addRecipeWithWrongUnit2() throws RecipeException {
		r1.setAmtChocolate("-7");
	}

	@Test(expected = RecipeException.class)
	public void addRecipeWithWrongUnit3() throws RecipeException {
		r1.setAmtCoffee("7.0");
	}

	@Test(expected = RecipeException.class)
	public void addRecipeWithWrongUnit4() throws RecipeException {
		r1.setAmtCoffee("-7");
	}

	@Test(expected = RecipeException.class)
	public void addRecipeWithWrongUnit5() throws RecipeException {
		r1.setAmtMilk("7.0");
	}

	@Test(expected = RecipeException.class)
	public void addRecipeWithWrongUnit6() throws RecipeException {
		r1.setAmtMilk("-7");
	}

	@Test(expected = RecipeException.class)
	public void addRecipeWithWrongUnit7() throws RecipeException {
		r1.setAmtSugar("7.0");
	}

	@Test(expected = RecipeException.class)
	public void addRecipeWithWrongUnit8() throws RecipeException {
		r1.setAmtSugar("-7");
	}
	
	@Test
	public void testToString(){
		Assert.assertNotNull(r1.toString());
	}
	
	@Test
	public void testHashcode(){
		Assert.assertNotNull(r1.hashCode());
	}

}
