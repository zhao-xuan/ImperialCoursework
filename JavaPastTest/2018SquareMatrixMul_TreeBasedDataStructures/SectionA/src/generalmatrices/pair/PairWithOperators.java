package generalmatrices.pair;

import generalmatrices.operators.RingElement;

import java.util.function.BinaryOperator;

public class PairWithOperators extends Pair implements RingElement<PairWithOperators> {
    public PairWithOperators(Integer coordX, Integer coordY) {
        super(coordX, coordY);
    }

    @Override
    public PairWithOperators sum(PairWithOperators other) {
        return new PairWithOperators(
                getCoordX() + other.getCoordX(),
                getCoordY() + other.getCoordY());
    }

    @Override
    public PairWithOperators product(PairWithOperators other) {
        return new PairWithOperators(
                getCoordX() * other.getCoordX(),
                getCoordY() * other.getCoordY());
    }
}
