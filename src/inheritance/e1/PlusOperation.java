package inheritance.e1;

/**
 * User: Alexandr
 * Date: 19.11.2014
 */
public class PlusOperation extends Operation {

    //Begin
    //Вот это компилятор допишет за тебя
    public PlusOperation() {
        super(); //обязан быть первой строчкой в конструкторе
        /*
            оставшееся тело
         */
    }
    //End

    @Override
    public float calc(float a, float b) {
        return a + b;
    }


}
