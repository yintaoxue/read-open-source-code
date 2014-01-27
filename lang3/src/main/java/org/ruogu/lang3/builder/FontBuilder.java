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
import java.awt.Font;
import org.apache.commons.lang3.builder.Builder;

public class FontBuilder implements Builder<Font> {
	private Font font;

	public FontBuilder(String fontName) {
		this.font = new Font(fontName, Font.PLAIN, 12);
	}

	public FontBuilder bold() {
		this.font = this.font.deriveFont(Font.BOLD);
		return this; // Reference returned so calls can be chained
	}

	public FontBuilder size(float pointSize) {
		this.font = this.font.deriveFont(pointSize);
		return this; // Reference returned so calls can be chained
	}

	// Other Font construction methods

	public Font build() {
		return this.font;
	}
}
