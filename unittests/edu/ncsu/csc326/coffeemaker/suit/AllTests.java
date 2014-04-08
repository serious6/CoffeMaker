package edu.ncsu.csc326.coffeemaker.suit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import edu.ncsu.csc326.coffeemaker.CoffeeMakerTest;
import edu.ncsu.csc326.coffeemaker.AddReciepeTest;

@RunWith(Suite.class)
@SuiteClasses({CoffeeMakerTest.class, AddReciepeTest.class})
public class AllTests {

}
