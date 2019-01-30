package com.thoughtworks.movierental;

class HTMLStatement {
    public String display(String name, Rentals rentals) {
        String result = "<h1>Rental Record for <b>" + name + "</b></h1><br/>";
        for (Rental each : rentals) {
            result += "" + each.getMovie().getTitle() + "" +
                    String.valueOf(each.amountFor()) + "<br/>";
        }

        result += "Amount owed is <b>" + String.valueOf(rentals.totalAmount()) + "</b><br/>";
        result += "You earned <b>" + String.valueOf(rentals.frequentRenterPoints())
                + "</b> frequent renter points";
        return result;
    }
}
