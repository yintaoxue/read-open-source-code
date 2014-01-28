/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ruogu.lang3;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.BooleanUtils;


public class TestBooleanUtils {

	public static void main(String[] args) {
		boolean[] a1 = {true, true};
//		
		System.out.println("BooleanUtils.and(true, true)         = " + BooleanUtils.and(a1));
		
		/**
		 * 当and(final boolean... array)与and(final Boolean... array)构成重载时，下一行代码会报错；
		 * 只有and(final boolean... array)时正常编译；
		 */
//		System.out.println("and(true, true)         = " + and(Boolean.TRUE, Boolean.TRUE));
//		System.out.println("and(true, true)         = " + and(true, true));
		
//		System.out.println("BooleanUtils.and(true, true)         = " + BooleanUtils.and(Boolean.TRUE, Boolean.TRUE));
		
//		System.out.println("BooleanUtils.and(false, false)       = " + BooleanUtils.and(false, false));
//		System.out.println("BooleanUtils.and(true, false)        = " + BooleanUtils.and(true, false));
//		System.out.println("BooleanUtils.and(true, true, false)  = " + BooleanUtils.and(true, true, false));
//		System.out.println("BooleanUtils.and(true, true, true)   = " + BooleanUtils.and(true, true, true));
//		

		
		test("a1", "a2");
		test(1,2,3);
		test(true, false, true);
	}
	
    public static boolean and(final boolean... array) {
        // Validates input
        if (array == null) {
            throw new IllegalArgumentException("The Array must not be null");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        for (final boolean element : array) {
            if (!element) {
                return false;
            }
        }
        return true;
    }
    
    public static Boolean and(final Boolean... array) {
        if (array == null) {
            throw new IllegalArgumentException("The Array must not be null");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        try {
            final boolean[] primitive = ArrayUtils.toPrimitive(array);
            return and(primitive) ? Boolean.TRUE : Boolean.FALSE;
        } catch (final NullPointerException ex) {
            throw new IllegalArgumentException("The array must not contain any null elements");
        }
    }
	
	public static void test(String... arguments) {
        for (int i = 0; i < arguments.length; i++) {
            System.out.println(arguments[i]);
        }
	}
	
	public static void test(int... arguments) {
        for (int i = 0; i < arguments.length; i++) {
            System.out.println(arguments[i]);
        }
	}
	
	public static void test(boolean... arguments) {
        for (int i = 0; i < arguments.length; i++) {
            System.out.println(arguments[i]);
        }
	}
}
