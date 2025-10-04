package edu.grinnell.csc207.genericslab;

/**
 * An Optional<@T> is either empty or holds a single value of type @T.
 * 
 * @param T the type of value potentially held by this <code>Optional</code>.
 */
public class Optional<T> {
    private T val;


    static <T> Optional<T> empty(){
        return null;
    }

    static <T> Optional<T> of(T value){
        Optional<T> optionalVal = new Optional<>();
        optionalVal.val = value;
        return optionalVal;
    }

    static boolean isEmpty(){
        if(this.Optional<T>.val)
    }
}
