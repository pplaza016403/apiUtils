/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.utils;

/**
 *
 * @author edisson.tapia
 * @param <A>
 * @param <B>
 */
public class ApiDoble<A extends Object, B extends Object> {

    private A objectoA;
    private B objectoB;

    public ApiDoble(A objectoA, B objectoB) {
        this.objectoA = objectoA;
        this.objectoB = objectoB;
    }

    public A getObjectoA() {
        return objectoA;
    }

    public void setObjectoA(A objectoA) {
        this.objectoA = objectoA;
    }

    public B getObjectoB() {
        return objectoB;
    }

    public void setObjectoB(B objectoB) {
        this.objectoB = objectoB;
    }

}
