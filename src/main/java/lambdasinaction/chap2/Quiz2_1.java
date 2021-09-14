package lambdasinaction.chap2;

import java.util.*;

public class Quiz2_1 {

    public static void main(String ... args){

        List<Apple> inventory = Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red"));

        // Apple{weight=80} Apple{weight=155} Apple{weight=120}
        prettyPrintApple(inventory, new AppleStringfyWeight());

        // Apple{color='green'} Apple{color='green'} Apple{color='red'}
        prettyPrintApple(inventory, new AppleStringfyColor());

        // Apple{weight=80color='green'} Apple{weight=155color='green'} Apple{weight=120color='red'}
        prettyPrintApple(inventory, new AppleStringfyWeightAndColor());
    }

    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color){
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }

    interface AppleStringfy {
        public String stringfy(Apple a);
    }

    static class AppleStringfyWeight implements AppleStringfy {
        public String stringfy(Apple a) {
            return "Apple{"+
                    "weight=" + a.getWeight() +
                    "}";
        }
    }

    static class AppleStringfyColor implements AppleStringfy {
        public String stringfy(Apple a) {
            return "Apple{"+
                    "color='" + a.getColor() + "\'" +
                    "}";
        }
    }

    static class AppleStringfyWeightAndColor implements AppleStringfy {
        public String stringfy(Apple a) {
            return "Apple{"+
                    "weight=" + a.getWeight() +
                    "color='" + a.getColor() + "\'" +
                    "}";
        }
    }

    public static void prettyPrintApple(List<Apple> invertory, AppleStringfy converter) {
        for(Apple apple: invertory) {
            String output = converter.stringfy(apple);
            System.out.println(output);
        }
    }
}
