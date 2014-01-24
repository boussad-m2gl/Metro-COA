package util;


/**
 * A Message  to be sent to the observers 
 * */ 
public class EpoqMessage {
	
	private int _value;  // The data of this message 
	private int _versionNumber;  //  a counter to simulate the epoq strategy 
	

	public int get_value() {
		return _value;
	}
	public void set_value(int _value) {
		this._value = _value;
	}
	public int get_versionNumber() {
		return _versionNumber;
	}
	public void set_versionNumber(int _versionNumber) {
		this._versionNumber = _versionNumber;
	}
	
	
	

}
