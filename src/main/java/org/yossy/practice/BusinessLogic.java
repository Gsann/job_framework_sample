package org.yossy.practice;

import java.util.ArrayList;
import java.util.List;


public class BusinessLogic {
    private List<Rental> rentals = new ArrayList<>();

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String statement(String name) {
        Customer customer = new Customer(name);
        double totalAmount = 0;
        int frequentREnterPoints = 0;

        StringBuffer buf = new StringBuffer();
        buf.append("Rental Record for " + customer.getName() + "\n");
        for (Rental each : this.rentals) {

            // レンタルポイントを加算
            frequentREnterPoints ++;
            // 新作を二日以上借りた場合はボーナスポイント
            if (calBornusPoint(each)) frequentREnterPoints ++;

            // この貸し出しに関する数値の表示
            buf.append("\t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(getAmount(each)) + "\n");
            totalAmount += getAmount(each);
        }
        buf.append(makeMessage(totalAmount, frequentREnterPoints));
        return buf.toString();
    }

    private double getAmount(Rental each) {
        // 1行ごとに金額を計算
        switch( each.getMovie().getPriceCode() ) {
            case Movie.REGULAR:
                return 2 + calcOverRented(each, 2);
            case Movie.NEW_RELEASE:
                return each.getDaysRented() * 3;
            case Movie.CHILDRENS:
                return 1.5 + calcOverRented(each, 3);
        }
        return 0;
    }

    private double calcOverRented(Rental each, int num) {
        if ( each.getDaysRented() > num) return ( each.getDaysRented() -1 * num) * 1.5;
        return 0;
    }

    private boolean calBornusPoint(Rental each) {
        return (each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
        each.getDaysRented() > 1;
    }

    private String makeMessage(double totalAmount, int frequentREnterPoints) {
        StringBuffer buf = new StringBuffer();
        buf.append("Amount owed is " + String.valueOf(totalAmount) + "\n" +
                "You earned " + String.valueOf(frequentREnterPoints) +
                " frequent renter points");
        return buf.toString();
    }
}