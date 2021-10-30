/**
 *   HotelSys系统的根类
 */
package com.abc.hotelsys.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * @author joeyang-ong
 *
 */
public abstract class ValueObject {
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
