package util;

/**
 *     A Message  de la strategie de gestion par époque
 *     Ce message sera envoyé par capteur vers le observateurs
 *     a Chaque fois que ca valeur change
 * */
public class EpoqMessage {

	private int _value; // le contenu du message
	private int _versionNumber; // la version du message

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
