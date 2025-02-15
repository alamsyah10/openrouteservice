/*  This file is part of Openrouteservice.
 *
 *  Openrouteservice is free software; you can redistribute it and/or modify it under the terms of the 
 *  GNU Lesser General Public License as published by the Free Software Foundation; either version 2.1 
 *  of the License, or (at your option) any later version.

 *  This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 *  See the GNU Lesser General Public License for more details.

 *  You should have received a copy of the GNU Lesser General Public License along with this library; 
 *  if not, see <https://www.gnu.org/licenses/>.  
 */
package org.heigit.ors.localization;

public class LocalString {
	private final Language language;
	private final String string;

	public LocalString(Language language, String string) 
	{ 
		this.language = language;
		this.string = string;
	} 

	public Language getLanguage() { 
		return language;
	} 

	public String getString() { 
		return string;
	} 

	@Override 
	public boolean equals(Object o) { 
		if (this == o) return true; 
		if (o == null || getClass() != o.getClass()) return false; 

		LocalString that = (LocalString) o; 

		return language.equals(that.language) && string.equals(that.string);

	} 

	@Override 
	public int hashCode() { 
		int result = language.hashCode();
		result = 31 * result + string.hashCode();
		return result; 
	} 

	@Override 
	public String toString() { 
		return """
                LocalString{\
                language=\
                """ + language +
				", string='" + string + '\'' +
				'}'; 
	} 
}
