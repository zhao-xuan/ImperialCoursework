package generalmatrices.matrix;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Matrix<T> {
    private final int order;
    private final T[][] matrix;

    public Matrix(List<T> source) {
        if (source.size() == 0) throw new IllegalArgumentException();
        order = (int) Math.sqrt(source.size());
        matrix = (T[][]) new Object[order][order];
        for (int i = 0; i < order; i++) {
            for (int j = 0; j < order; j++) {
                matrix[i][j] = source.get(i*order+j);
            }
        }
    }

    public Matrix(int order) {
        this.order = order;
        matrix = (T[][]) new Object[order][order];
    }

    public T get(int row, int col) {
        return matrix[row][col];
    }

    public int getOrder() {
        return order;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < order; i++) {
            s.append("[");
            for (int j = 0; j < order; j++) {
                if (j == order - 1) {
                    s.append(matrix[i][j]);
                    break;
                }
                s.append(matrix[i][j] + " ");
            }
            s.append("]");
        }
        s.append("]");
        return s.toString();
    }

    public Matrix<T> sum(Matrix<T> other, BinaryOperator<T> elementSum) {
        //PRE: other has the same dimension as the current matrix instance
        Matrix<T> result = new Matrix<>(order);
        for (int i = 0; i < order; i++) {
            for (int j = 0; j < order; j++) {
                result.matrix[i][j] = elementSum.apply(matrix[i][j], other.get(i, j));
            }
        }
        return result;
    }

    public Matrix<T> product(Matrix<T> other, BinaryOperator<T> elementSum, BinaryOperator<T> elementProduct) {
        //PRE: other has the same dimension as the current matrix instance
        Matrix<T> result = new Matrix<>(order);
        for (int i = 0; i < order; i++) {
            for (int j = 0; j < order; j++) {
                for (int k = 0; k < order; k++) {
                    if (result.matrix[i][j] == null) {
                        result.matrix[i][j] = elementProduct.apply(matrix[i][k], other.matrix[k][j]);
                    } else {
                        result.matrix[i][j] = elementSum.apply(result.matrix[i][j], elementProduct.apply(matrix[i][k], other.matrix[k][j]));
                    }
                }
            }
        }
        return result;
    }
}
