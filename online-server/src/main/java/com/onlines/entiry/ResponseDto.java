package com.onlines.entiry;

import com.onlines.enums.ResponseCodeEnum;

public class ResponseDto {
	public int code;
	public String codeMsg;
	public Object data;
	public String randomcode;

	public ResponseDto(){
	    
	}

	public ResponseDto(int code){
		this.code = code;
		this.codeMsg = ResponseCodeEnum.getDescByCode(code);
	}

    public ResponseDto(ResponseCodeEnum responseCodeEnum){
        this.code = responseCodeEnum.getCode();
        this.codeMsg = responseCodeEnum.getDesc();
    }

	public ResponseDto(int code , Object data){
		this.code = code;
		this.codeMsg = ResponseCodeEnum.getDescByCode(code);
		this.data = data;
	}

	public ResponseDto(int code, String codeMsg, Object data) {
		this.code = code;
		this.codeMsg = codeMsg;
		this.data = data;
	}


	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getCodeMsg() {
		return codeMsg;
	}
	public void setCodeMsg(String codeMsg) {
		this.codeMsg = codeMsg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getRandomcode() {
		return randomcode;
	}
	public void setRandomcode(String randomcode) {
		this.randomcode = randomcode;
	}

}
