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
 * @param <C>
 * @param <D>
 */
public class ApiCuadruple<A extends Object, B extends Object, C extends Object, D extends Object> {

    private A objectoA;
    private B objectoB;
    private C objectoC;
    private D objectoD;

    public ApiCuadruple(A objectoA, B objectoB, C objectoC, D objectoD) {
        this.objectoA = objectoA;
        this.objectoB = objectoB;
        this.objectoC = objectoC;
        this.objectoD = objectoD;
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

    public D getObjectoD() {
        return objectoD;
    }

    public void setObjectoD(D objectoD) {
        this.objectoD = objectoD;
    }

}
