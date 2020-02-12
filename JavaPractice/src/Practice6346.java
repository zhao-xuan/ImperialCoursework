interface Expr {
    int eval();
    int literalCount();
    int depth();
}

class AddExpr implements Expr {

    private Expr lhs;
    private Expr rhs;

    public AddExpr(Expr lhs, Expr rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public int eval() {
        return lhs.eval() + rhs.eval();
    }

    @Override
    public int literalCount() {
        return lhs.literalCount() + rhs.literalCount();
    }

    @Override
    public int depth() {
        return 1 + Math.max(lhs.depth(), rhs.depth());
    }

}

class FactExpr implements Expr {

    private Expr operand;

    public FactExpr(Expr operand) {
        this.operand = operand;
    }

    @Override
    public int eval() {
        int value = operand.eval();
        if (value < 0) {
            throw new RuntimeException("Negative factorial undefined");
        }
        int result = 1;
        while (value > 1) {
            result *= value;
            value--;
        }
        return result;
    }

    @Override
    public int literalCount() {
        return operand.literalCount();
    }

    @Override
    public int depth() {
        return 1 + operand.depth();
    }

}

class LiteralExpr implements Expr {

    private int value;

    public LiteralExpr(int value) {
        this.value = value;
    }

    @Override
    public int eval() {
        return value;
    }

    @Override
    public int literalCount() {
        return 1;
    }

    @Override
    public int depth() {
        return 0;
    }

}

class MulExpr implements Expr {

    private Expr lhs;
    private Expr rhs;

    public MulExpr(Expr lhs, Expr rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public int eval() {
        return lhs.eval() * rhs.eval();
    }

    @Override
    public int literalCount() {
        return lhs.literalCount() + rhs.literalCount();
    }

    @Override
    public int depth() {
        return 1 + Math.max(lhs.depth(), rhs.depth());
    }

}

public class Practice6346 {

    public static void main(String[] args) {

        Expr firstSub = new AddExpr(new LiteralExpr(1),
                new FactExpr(new AddExpr(new LiteralExpr(2), new LiteralExpr(3))));
        Expr secondSub = new MulExpr(new LiteralExpr(3), new LiteralExpr(4));

        Expr expr = new MulExpr(firstSub, secondSub);

        System.out.println("Evaluates to: " + expr.eval());
        System.out.println("Literal count: " + expr.literalCount());
        System.out.println("Depth: " + expr.depth());

    }

}