package bsu.by;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.IOException;
import java.util.Arrays;

public class BooleanVector {
    private boolean[] array;
    public BooleanVector(){
        array = new boolean[1];
        array[0] = false;
    }
    public BooleanVector(int n){
        array = new boolean[n];
        for(int i = 0; i<n; i++){
            this.array[i] =Math.random() * 100 <50;
        }
    }
    public BooleanVector(boolean[] array){
        for(int i = 0; i<array.length; i++){
            this.array[i] = array[i];
        }
    }
    public int get0() {
        int zero = 0;
        for (boolean anArray : array) {
            if (!anArray) {
                zero++;
            }
        }
        return zero;
    }
    public void setArrayI(int i, boolean a){
        array[i] = a;
    }

    public boolean[] getArray() {
        return array;
    }
    public boolean getValueI(int i){
        return array[i];
    }

    public void setArray(boolean[] array) {
        this.array = array;
    }

    public int get1(){
        int one = 0;
        for (boolean anArray : array) {
            if (anArray) {
                one++;
            }
        }
        return one;
    }
    public BooleanVector inverse() {
        BooleanVector s = new BooleanVector(array.length);
        for (int i = 0; i < array.length; i++) {
            s.setArrayI(i, !array[i]);
        }
        return s;
    }

    public BooleanVector conunc(BooleanVector a)throws ErrorSize{
        if(a.getArray().length != this.array.length){
            throw new ErrorSize();
        }
        BooleanVector s = new BooleanVector(this.getArray().length);
        for(int i = 0; i<array.length; i++){
            s.setArrayI(i, array[i] && a.getValueI(i));
        }
        return s;
    }

    public BooleanVector dizunc(BooleanVector a)throws ErrorSize{
        if(a.getArray().length != this.array.length){
            throw new ErrorSize();
        }
        BooleanVector s = new BooleanVector(this.getArray().length);
        for(int i = 0; i<array.length; i++){
            s.setArrayI(i, array[i] || a.getValueI(i));
        }
        return s;
    }
    @Override
    public String toString(){
        return Arrays.toString(this.array) + "\n";
    }

}
class ErrorSize extends IOException {}