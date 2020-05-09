public class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int level = 0;
        int levelOne = 0;
        // find max level that is smaller than candies
        while (true) {
            levelOne = 1 + level;
            if (num_people * levelOne * (num_people * levelOne + 1) > 2 * candies) {
                break;
            }
            level++;
        }

        int[] result = new int[num_people];
        if(level > 0) {
            for (int i = 0; i < num_people; i++) {
                result[i] = ((level - 1) * level * num_people) / 2 + level * (i + 1);
            }
        }


        int rest = candies - (num_people * level * (num_people * level + 1)) / 2;

        int nthPeople = 1;
        int sum = 0;
        while (rest > (sum = (level * num_people + nthPeople))) {
            result[nthPeople - 1] += sum;
            rest -= sum;
            nthPeople++;
        }

        result[nthPeople - 1] += rest;

        return result;
    }

    public static void main(String[] args) {
//        new Solution().distributeCandies(7, 4);
        Shape shape = (Shape)new Rectangle(2,4);
        System.out.println(shape.getArea());
    }

}

class Shape {
    int width, height;


    Shape(int a, int b) {
        width = a;
        height = b;
    }

    int getArea(){
        System.out.println("Shape class area :");
        return 0;
    }
}

class Rectangle extends Shape{
    Rectangle(int a, int b){
        super(a,b);
    }

    int getArea(){
        System.out.println("Rectangle class area :");
        return width*height;
    }
}
