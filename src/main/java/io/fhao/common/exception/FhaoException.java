package io.fhao.common.exception;

/**
 * @author hgw
 * @Description: TODO(自定义异常)
 * @date 2017-6-23 15:07
 */
public class FhaoException extends RuntimeException {
	
    private String msg;

    private int code = 500;
    
    public FhaoException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public FhaoException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}
	
	public FhaoException(String msg, int code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}
	
	public FhaoException(String msg, int code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
}
