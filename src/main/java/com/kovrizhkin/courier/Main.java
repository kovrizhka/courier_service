package com.kovrizhkin.courier;

import com.kovrizhkin.courier.entity.Courier;
import com.kovrizhkin.courier.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //создание листа заказов для курьера
        List<Order> newOrderList = new ArrayList<>();
        newOrderList.add(new Order(12));
        newOrderList.add(new Order(13));
        newOrderList.add(new Order(15));
        newOrderList.add(new Order(19));

        //курьер выходит на работу
        Courier courier1 = new Courier((ArrayList<Order>) newOrderList);

        //и вдруг курьер опаздывает/не успевает доставить заказ
        courier1.toLate();


    }
}