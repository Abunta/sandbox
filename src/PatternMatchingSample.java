import testObjects.Circle;
import testObjects.Rectangle;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class PatternMatchingSample {

    private static final Function<Object, Double> AREA_CALCULATION = new LambdaVisitor<Double>()
            .on(Rectangle.class).then(r -> r.getLength() * 2 + r.getWidth() * 2)
            .on(Circle.class).then(c -> 2 * Math.PI * c.getRadius());


    public static void main(String[] args) {
        List<Object> figures = Arrays.asList(new Circle(3), new Rectangle(2, 3));

        Double totalArea = figures.stream()
                .map(AREA_CALCULATION)
                .reduce(0.0, Double::sum);

        System.out.println(totalArea);
    }
}
