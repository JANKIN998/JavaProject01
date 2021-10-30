/**
 * 
 */
package com.abc.hotelsys.exception;

/**
 * 
 * HotelSys自定义异常
 * 
 * @author joeyang-ong
 *
 */
public class HotelSysException extends RuntimeException {

	/**
	 * 
	 */
	public HotelSysException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public HotelSysException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public HotelSysException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public HotelSysException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public HotelSysException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
