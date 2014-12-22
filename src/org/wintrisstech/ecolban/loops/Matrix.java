package org.wintrisstech.ecolban.loops;

public final class Matrix {

	private final int rows;
	private final int cols;
	private final double[][] elements;

	public Matrix(double[][] elements) {
		this.rows = elements.length;
		this.cols = elements[0].length;
		this.elements = new double[rows][cols];
		for (int i = 0; i < elements.length; i++) {
			this.elements[i] = elements[i].clone();
		}
	}

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}

	public double get(int i, int j) {
		return elements[i][j];
	}

	public static Matrix identity(int dim) {
		double[][] elements = new double[dim][dim];
		for (int i = 0; i < elements.length; i++) {
			elements[i][i] = 1.0;
		}
		return new Matrix(elements);
	}

	public Matrix multiply(double scalar) {
		double[][] elements = new double[rows][cols];
		for (int i = 0; i < elements.length; i++) {
			for (int j = 0; j < elements[i].length; j++) {
				elements[i][j] = scalar * this.elements[i][j];
			}
		}
		return new Matrix(elements);
	}

	public Matrix multiply(Matrix that) {
		assert this.cols == that.rows;
		double[][] elements = new double[this.rows][that.cols];
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < that.cols; j++) {
				double sum = 0.0;
				for (int k = 0; k < this.cols; k++) {
					sum += this.elements[i][k] * that.elements[k][j];
				}
				elements[i][j] = sum;
			}
		}
		return new Matrix(elements);
	}

	public Matrix add(Matrix that) {
		assert that.rows == this.rows;
		assert that.cols == this.cols;
		double[][] elements = new double[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				elements[i][j] = this.elements[i][j] + that.elements[i][j];
			}
		}
		return new Matrix(elements);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < rows; i++) {
			sb.append("[");
			sb.append(elements[i][0]);
			for (int j = 1; j < cols; j++) {
				sb.append(" ");
				sb.append(elements[i][j]);
			}
			sb.append("]\n");
		}
		return sb.toString();
	}

	public boolean equals(Object o) {
		if (o == null || !(o instanceof Matrix)) {
			return false;
		}
		Matrix that = (Matrix) o;
		if (this.rows != that.rows || this.cols != that.cols) {
			return false;
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (this.get(i, j) != that.get(i, j)) {
					return false;
				}
			}

		}
		return true;
	}
}
