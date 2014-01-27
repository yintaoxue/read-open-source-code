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
package org.ruogu.lang3.builder;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TestBuilder {

	public static void main(String[] args) {
		testToString();
	}
	
	public static void testToString() {
		Person p = new Person();
		p.age = 12;
		p.name = "tom";
		p.smoker = true;
		
		//org.ruogu.lang3.builder.Person@61de33
		System.out.println(p.toString());
		//org.ruogu.lang3.builder.Person@1270b73[name=tom,age=12,smoker=true]
		System.out.println(p.toString2());
		
		Car car = new Car();
		//反射
		System.out.println(ToStringBuilder.reflectionToString(car, ToStringStyle.MULTI_LINE_STYLE));
		
	}

}
