package com.thoughtworks.movierental;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

    private Customer testCustomer;
    private Movie regularMovie;
    private Movie newRelease;
    private Movie childrenMovie;

    @Before
    public void setup() {
        testCustomer = new Customer("Dummy Customer");
        regularMovie = new Movie("Regular Movie Name", Movie.REGULAR);
        newRelease = new Movie("New Release Movie Name", Movie.NEW_RELEASE);
        childrenMovie = new Movie("Children Movie Name", Movie.CHILDRENS);
    }

    @Test
    public void testStatementReturnString() {
        Assert.assertTrue(testCustomer.statement() instanceof String);
    }

    @Test
    public void testStatementForNoRentals() {
        StringBuilder expectedStatement = new StringBuilder();
        expectedStatement.append("Rental Record for " + testCustomer.getName() + "\n");
        expectedStatement.append("Amount owed is " + String.valueOf(0.0) + "\n");
        expectedStatement.append("You earned " + String.valueOf(0)
                + " frequent renter points");

        Assert.assertEquals(expectedStatement.toString(),
                testCustomer.statement());
    }

    @Test
    public void testStatementForNoRentalsHtml() {
        StringBuilder expectedStatement = new StringBuilder();
        expectedStatement.append("<h1>Rental Record for <b>" + testCustomer.getName() + "</b></h1><br/>");
        expectedStatement.append("Amount owed is <b>" + String.valueOf(0.0) + "</b><br/>");
        expectedStatement.append("You earned <b>" + String.valueOf(0)
                + "</b> frequent renter points");

        Assert.assertEquals(expectedStatement.toString(),
                testCustomer.htmlStatement());
    }

    @Test
    public void testStatementForTwoRegularMovies() {

        testCustomer.addRental(new Rental(regularMovie, 2));
        testCustomer.addRental(new Rental(regularMovie, 3));

        StringBuilder expectedStatement = new StringBuilder();
        expectedStatement.append("Rental Record for " + testCustomer.getName() + "\n");

        expectedStatement.append("\t" + regularMovie.getTitle() + "\t" +
                String.valueOf(2.0) + "\n");
        expectedStatement.append("\t" + regularMovie.getTitle() + "\t" +
                String.valueOf(3.5) + "\n");

        expectedStatement.append("Amount owed is " + String.valueOf(5.5) + "\n");
        expectedStatement.append("You earned " + String.valueOf(2)
                + " frequent renter points");

        Assert.assertEquals(expectedStatement.toString(),
                testCustomer.statement());
    }

    @Test
    public void testStatementForTwoNewRelease() {

        testCustomer.addRental(new Rental(newRelease, 1));
        testCustomer.addRental(new Rental(newRelease, 3));

        StringBuilder expectedStatement = new StringBuilder();
        expectedStatement.append("Rental Record for " + testCustomer.getName() + "\n");
        expectedStatement.append("\t" + newRelease.getTitle() + "\t" + String.valueOf(3.0) + "\n");
        expectedStatement.append("\t" + newRelease.getTitle() + "\t" + String.valueOf(9.0) + "\n");
        expectedStatement.append("Amount owed is " + String.valueOf(12.0) + "\n");
        expectedStatement.append("You earned " + String.valueOf(3) + " frequent renter points");

        Assert.assertEquals(expectedStatement.toString(),
                testCustomer.statement());
    }

    @Test
    public void testStatementForTwoChildrenMovies() {

        testCustomer.addRental(new Rental(childrenMovie, 3));
        testCustomer.addRental(new Rental(childrenMovie, 6));

        StringBuilder expectedStatement = new StringBuilder();
        expectedStatement.append("Rental Record for " + testCustomer.getName() + "\n");
        expectedStatement.append("\t" + childrenMovie.getTitle() + "\t" + String.valueOf(1.5) + "\n");
        expectedStatement.append("\t" + childrenMovie.getTitle() + "\t" + String.valueOf(6.0) + "\n");
        expectedStatement.append("Amount owed is " + String.valueOf(7.5) + "\n");
        expectedStatement.append("You earned " + String.valueOf(2) + " frequent renter points");

        Assert.assertEquals(expectedStatement.toString(),
                testCustomer.statement());
    }

    @Test
    public void testStatementForMultipleMoviesRental() {

        testCustomer.addRental(new Rental(regularMovie, 3));
        testCustomer.addRental(new Rental(newRelease, 1));
        testCustomer.addRental(new Rental(childrenMovie, 6));

        StringBuilder expectedStatement = new StringBuilder();
        expectedStatement.append("Rental Record for " + testCustomer.getName() + "\n");
        expectedStatement.append("\t" + regularMovie.getTitle() + "\t" + String.valueOf(3.5) + "\n");
        expectedStatement.append("\t" + newRelease.getTitle() + "\t" + String.valueOf(3.0) + "\n");
        expectedStatement.append("\t" + childrenMovie.getTitle() + "\t" + String.valueOf(6.0) + "\n");
        expectedStatement.append("Amount owed is " + String.valueOf(12.5) + "\n");
        expectedStatement.append("You earned " + String.valueOf(3) + " frequent renter points");

        Assert.assertEquals(expectedStatement.toString(),
                testCustomer.statement());
    }

    @Test
    public void testStatementForMultipleMoviesRentalHtml() {

        testCustomer.addRental(new Rental(regularMovie, 3));
        testCustomer.addRental(new Rental(newRelease, 1));
        testCustomer.addRental(new Rental(childrenMovie, 6));

        StringBuilder expectedStatement = new StringBuilder();
        expectedStatement.append("<h1>Rental Record for <b>" + testCustomer.getName() + "</b></h1><br/>");
        expectedStatement.append("" + regularMovie.getTitle() + "" + String.valueOf(3.5) + "<br/>");
        expectedStatement.append("" + newRelease.getTitle() + "" + String.valueOf(3.0) + "<br/>");
        expectedStatement.append("" + childrenMovie.getTitle() + "" + String.valueOf(6.0) + "<br/>");
        expectedStatement.append("Amount owed is <b>" + String.valueOf(12.5) + "</b><br/>");
        expectedStatement.append("You earned <b>" + String.valueOf(3) + "</b> frequent renter points");

        Assert.assertEquals(expectedStatement.toString(),
                testCustomer.htmlStatement());
    }
}