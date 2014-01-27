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

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Person {
	String name;
	int age;
	boolean smoker;
	int[] scores = { 12, 3, 111, 9 };

	public int compareTo(Object o) {
		Person p = (Person) o;
		return new CompareToBuilder().append(this.name, p.name)
				.append(this.age, p.age).append(this.smoker, p.smoker)
				.toComparison();
	}

	public int hashCode2() {
		// you pick a hard-coded, randomly chosen, non-zero, odd number
		// ideally different for each class
		return new HashCodeBuilder(17, 37).append(name).append(age)
				.append(smoker).toHashCode();
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		Person p = (Person) obj;
		return new EqualsBuilder().append(this.name, p.name)
				.append(this.age, p.age).append(this.smoker, p.smoker)
				.isEquals();
	}

	public boolean equals2(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		Person p = (Person) obj;
		System.out.println("...");
		System.out.println("super.equals(obj):" + super.equals(obj));
		EqualsBuilder eb = new EqualsBuilder();
		System.out.println("eb:" + eb.isEquals());
		return eb.append(this.name, p.name).append(this.age, p.age)
				.append(this.smoker, p.smoker).isEquals();
	}

	public String toString2() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("name", name).append("age", age)
				.append("smoker", smoker).append(scores).toString();
	}
}
