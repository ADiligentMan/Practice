package basic;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wangpeng
 * @since 2021-01-26
 */
public class PECS {
    public void appleFruit() {
        List<Apple> apples = new LinkedList<>();
        List<? extends Fruit> fruits = apples;
        Fruit fruit = fruits.get(0);
        List<? super Apple> apples1 = new LinkedList<Fruit>();
        Object object = apples1.get(0);
    }

}

class Fruit {

}

class Apple extends Fruit {

}

class Strawberry extends Fruit{

}
