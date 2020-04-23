package hw7.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static java.lang.Integer.sum;
import static java.lang.String.join;
import static java.util.Arrays.asList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MetalsAndColorsData {
    int[] summary;
    String[] elements;
    String color;
    String metals;
    String[] vegetables;

    public List<String> expectedResultList() {
        return asList("Summary: " + sum(summary[0], summary[1]),
                "Elements: " + join(", ", elements),
                "Color: " + color,
                "Metal: " + metals,
                "Vegetables: " + join(", ", vegetables));
    }
}
