// package com.sqa.ks;
//
// import java.util.*;
//
// import org.junit.*;
// import org.junit.runner.*;
// import org.junit.runners.*;
// import org.junit.runners.Parameterized.*;
//
// import com.sqa.ks.helpers.*;
//
// @RunWith(Parameterized.class)
// public class QAMathAddTest {
//
// @Parameters
// public static Collection<Object[]> getData() {
// return Arrays.asList(new Object[][] { { 6, 8, 14 }, { 2, 14, 16 }, { 1, 23,
// 24 },
// { -6, 4, -2 }, { 100, -138, -38 }, { 101101101, 101011, 101202112 } });
// }
//
// public int num1;
//
// public int num2;
//
// public int expected;
//
// public QAMathAddTest(int num1, int num2, int expected) {
// super();
// this.num1 = num1;
// this.num2 = num2;
// this.expected = expected;
// }
//
// // @BeforeClass
// // public static void setUpBeforeClass() throws Exception {
// // System.out.println(" Before class ");
// // }
// //
// // @AfterClass
// // public static void tearDownAfterClass() throws Exception {
// // System.out.println("\tAfter Class");
// // }
// //
// // @Before
// // public void setUp() throws Exception {
// // System.out.println(" Before test ");
// // }
// //
// // @After
// // public void tearDown() throws Exception {
// // System.out.println(" After test ");
// // }
// @Test
// public void test1() {
// int actual;
// actual = QAMath.addNumbers(this.num1, this.num2);
// Assert.assertEquals(this.expected, actual);
// }
//
// @Test
// public void test2() {
// int actual;
// QAMath math = new QAMath();
// math.addNumber(this.num1);
// math.addNumber(this.num2);
// actual = math.getTotal();
// Assert.assertEquals(this.expected, actual);
// }
// }