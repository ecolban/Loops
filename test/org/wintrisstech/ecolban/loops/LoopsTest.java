package org.wintrisstech.ecolban.loops;

import static org.junit.Assert.*;
import static org.wintrisstech.ecolban.loops.Loops.*;

import java.math.BigInteger;

import org.junit.Test;

public class LoopsTest {

	@Test
	public final void operatorsBackwardsTest() {
		assertEquals("ABAABB", operatorsBackwards(50));
		assertEquals("BAAAAAB", operatorsBackwards(65));
		assertEquals("BAABABB", operatorsBackwards(105));
		assertEquals("", operatorsBackwards(0));
		assertEquals("B", operatorsBackwards(1));
	}

	@Test
	public final void operatorsForwardsTest() {
		assertEquals("BBAABA", operatorsForwards(50));
		assertEquals("BAAAAAB", operatorsForwards(65));
		assertEquals("BBABAAB", operatorsForwards(105));
		assertEquals("", operatorsForwards(0));
		assertEquals("B", operatorsForwards(1));
	}

	@Test
	public final void multiplyTest() {
		assertEquals(1234 * 7654, multiply(1234, 7654));
		assertEquals(656 * 812, multiply(656, 812));
		assertEquals(0, multiply(0, 812));
		assertEquals(0, multiply(812, 0));
		assertEquals(812, multiply(1, 812));
		assertEquals(812, multiply(812, 1));
	}

	@Test
	public final void powTest() {
		assertEquals((int) Math.pow(3, 7), pow(3, 7));
		assertEquals((int) Math.pow(17, 6), pow(17, 6));
		assertEquals(1, pow(1, 123456));
		assertEquals(0, pow(0, 123456));
		assertEquals(1, pow(123456, 0));
	}

	@Test
	public final void multiplyModTest() {
		assertEquals(6, multiplyMod(3, 100, 7));
		assertEquals(0, multiplyMod(0, 123456, 13));
		assertEquals(812 % 17, multiplyMod(1, 812 % 17, 17));
		assertEquals(4415067760L, multiplyMod(9123487120L, 9998612223L, 10000000000L));
	}

	@Test
	public final void powModTest() {
		assertEquals(4, powMod(3, 100, 7));
		assertEquals(2203584716293777924L, powMod(7682000837110988L, 12776029956L,
				Long.MAX_VALUE / 2));
	}

	@Test
	public final void fibonacciTest() {
		assertEquals(BigInteger.ZERO, fibonacci(0));
		assertEquals(BigInteger.ONE, fibonacci(1));
		assertEquals(new BigInteger("1"), fibonacci(2));
		assertEquals(new BigInteger("2"), fibonacci(3));
		assertEquals(new BigInteger("3"), fibonacci(4));
		assertEquals(new BigInteger("5"), fibonacci(5));
		assertEquals(new BigInteger("8"), fibonacci(6));
		assertEquals(new BigInteger("13"), fibonacci(7));
		assertEquals(20899, fibonacci(100000).toString().length());
	}

	@Test
	public final void matrixPowTest() {
		Matrix matrixA = new Matrix(new double[][] { { 0.0, 1.0 }, { 1.0, 1.0 } });
		Matrix id = new Matrix(new double[][] { { 1.0, 0.0 }, { 0.0, 1.0 } });
		assertEquals(matrixA, pow(matrixA, 1));
		assertEquals(id, pow(id, 100));
		Matrix matrixB = new Matrix(new double[][]{{4181.0, 6765.0}, {6765.0, 10946.0}});
		assertEquals(matrixB, pow(matrixA, 20));
	}
	
	@Test
	public final void intSqrtTest() {
		BigInteger f100000 = fibonacci(100000);
		BigInteger[] result = intSqrt(f100000);
		BigInteger root = result[0];
		BigInteger remainder = result[1];
		assertEquals(root.multiply(root).add(remainder), f100000);
		assertTrue(remainder.compareTo(BigInteger.ZERO) >= 0);
		BigInteger rootPlusOne = root.add(BigInteger.ONE);
		assertTrue(rootPlusOne.multiply(rootPlusOne).compareTo(f100000) > 0);
		
	}

}
