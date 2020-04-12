package hw4.ex2.builder;

import org.openqa.selenium.WebElement;

import java.util.List;

public class MetalsAndColorsData {
    String oddSummary;
    String evenSummary;
    List<String> elements;
    String color;
    String metal;
    List<String> vegetables;

    public static class ExpectedResult {
        String oddSummary;
        String evenSummary;
        List<String> elements;
        String color;
        String metal;
        List<String> vegetables;

        public ExpectedResult(String oddSummary, String evenSummary, List<String> elements,
                       String color, String metal, List<String> vegetables) {
            this.evenSummary = evenSummary;
            this.oddSummary = oddSummary;
            this.elements = elements;
            this.color = color;
            this.metal = metal;
            this.vegetables = vegetables;
        }


        public boolean hasSummary() {
            return evenSummary != null && oddSummary != null;
        }

        public String getSummary() {
            return calculatedOddsAndEvens();
        }

        public boolean hasElements(){
            return elements != null;
        }

        public String getElements() {
            String tmp = elements.stream().reduce((left, right) -> left + ", " + right).get();
            return tmp;
        }

        public boolean hasColor(){
            return color != null;
        }

        public String getColor() {
            return color;
        }

        public boolean hasMetal(){
            return metal != null;
        }

        public String getMetal() {
            return metal;
        }

        public boolean hasVegetables(){
            return vegetables != null;
        }

        public String getVegetables() {
            return vegetables.stream().reduce((left, right) -> left + ", " + right).get();
        }

        private String calculatedOddsAndEvens() {
            int a = Integer.parseInt(oddSummary);
            int b = Integer.parseInt(evenSummary);
            Integer calculateNumbers = a + b;
            return calculateNumbers.toString();
        }

        public boolean checkText(String actualResult) {
            boolean everythingOk = true;
            if (hasSummary()){
                everythingOk &= actualResult.contains(getSummary());
            }
            if (hasElements()){
                for (String value : elements){
                    everythingOk &= actualResult.contains(value);
                }
            }
            if (hasColor()){
                everythingOk &= actualResult.contains(color);
            }
            if (hasMetal()){
                everythingOk &= actualResult.contains(metal);
            }
            if (hasVegetables()){
                for (String value : vegetables){
                    everythingOk &= actualResult.contains(value);
                }
            }
            return  everythingOk;
        }
    }
    private MetalsAndColorsData(String oddSummary, String evenSummary, List<String> elements,
                                String color, String metal, List<String> vegetables) {
        this.evenSummary = evenSummary;
        this.oddSummary = oddSummary;
        this.elements = elements;
        this.color = color;
        this.metal = metal;
        this.vegetables = vegetables;
    }

    public String getOddSummary() {
        return oddSummary;
    }

    public String getEvenSummary() {
        return evenSummary;
    }

    public List<String> getElements() {
        return elements;
    }

    public String getColor() {
        return color;
    }

    public String getMetal() {
        return metal;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        String oddSummary;
        String evenSummary;
        List<String> elements;
        String color;
        String metal;
        List<String> vegetables;

        public Builder() {

        }

        public Builder setOddSummary(String oddSummary) {
            this.oddSummary = oddSummary;
            return this;
        }

        public Builder setEvenSummary(String evenSummary) {
            this.evenSummary = evenSummary;
            return this;
        }

        public Builder setElements(List<String> elements) {
            this.elements = elements;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setMetal(String metal) {
            this.metal = metal;
            return this;
        }

        public Builder setVegetables(List<String> vegetables) {
            this.vegetables = vegetables;
            return this;
        }

        public MetalsAndColorsData build() {
            return new MetalsAndColorsData(oddSummary, evenSummary, elements, color, metal, vegetables);
        }

        public ExpectedResult buildResult() {
            return new ExpectedResult(oddSummary, evenSummary, elements, color, metal, vegetables);
        }
    }
}
