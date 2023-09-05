/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gortiz.api;

/**
 *
 * @author edisson.tapia
 * @param <A>
 * @param <B>
 * @param <C>
 */
public class ApiTriple<A extends Object, B extends Object, C extends Object> {

    private A objectoA;
    private B objectoB;
    private C objectoC;

    public ApiTriple(A objectoA, B objectoB, C objectoC) {
        this.objectoA = objectoA;
        this.objectoB = objectoB;
        this.objectoC = objectoC;
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

    public C getObjectoC() {
        return objectoC;
    }

    public void setObjectoC(C objectoC) {
        this.objectoC = objectoC;
    }

}
