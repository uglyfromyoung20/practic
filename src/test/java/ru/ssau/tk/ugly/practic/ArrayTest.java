package ru.ssau.tk.ugly.practic;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.testng.Assert.*;

    public class ArrayTest {

        @Test
        public void testCreateArrayWithDimension() {
            Array object = new ArrayMethods();
            double[] array = object.createArrayWithDimension(5);
            Assert.assertTrue(Arrays.equals(array, object.createArrayWithDimension(5)));
            for (double element : array) {
                Assert.assertEquals(element, 0.0);
            }
        }

    }

