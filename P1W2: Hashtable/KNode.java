// --== CS400 Project One File Header ==--
// Name: Nisitha de silva
// CSL Username: nisitha
// Email: ntdesilva@wisc.edu
// Lecture #: 001 @11:00am
// Notes to Grader: <>


public class KNode<KeyType, ValueType> {
    private KeyType key;
    private ValueType value;

    public KNode(KeyType key, ValueType value) {
        this.key = key;
        this.value = value;
    }
    public KeyType getKey() {
        return this.key;
    }

    public ValueType getValue() {
        return this.value;
    }
}
