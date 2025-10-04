package edu.grinnell.csc207.genericslab;

/**
 * An Optional<@T> is either empty or holds a single value of type @T.
 * 
 * @param T the type of value potentially held by this <code>Optional</code>.
 */
public class Optional<T> {
    private T val;

    private Optional(){
        //does notthing...?
    }

    static <T> Optional<T> empty(){
        Optional<T> emptyOp = new Optional();
        return emptyOp;
    }

    static <T> Optional<T> of(T value){
        Optional<T> nonEmptyOp = new Optional();       
        nonEmptyOp.val = value;
        return nonEmptyOp;
    }

    /*
     * WE were not sure on how to get these function to work. We will ask about them in class.
     */
    // static boolean isEmpty(){
    //     return (val != null)
    // }
    // static boolean isPresent(){}
    // static T get(){}
    // static T orElse(T other){}

}
