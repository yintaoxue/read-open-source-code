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

import java.util.AbstractMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.ArrayUtils;

public class ArrayUtilsTest {
	public static void main(String[] args) {
		Class<?>[] classArray = new Class[0];

		int[][] intArray = { { 1, 4, 6 }, { 2, 0, 7 } };

		System.out.println(ArrayUtils.toString(intArray));

		// 字符串数组转map
		String[][] toMap1 = { { "k1", "v1" }, { "k2", "v2", "vv" } };
		Map<Object, Object> map1 = ArrayUtils.toMap(toMap1);
		System.out.println(map1.toString());
		
		// Entry数组转amp
		Entry<String, String> o1 = new AbstractMap.SimpleEntry<String, String>("key1", "value1");
		Entry<String, String> o2 = new AbstractMap.SimpleEntry<String, String>("key2", "value2");
		Entry[] jj = new AbstractMap.SimpleEntry[2];
		jj[0] = o1;
		jj[1] = o2;
		
		System.out.println(ArrayUtils.toMap(jj));
		
		// 如何创建数组
		Entry<String, String>[] jjs = new AbstractMap.SimpleEntry[2];
		Entry<String, String>[] jjss = new Entry[2];
		
	}
}