package opengrep;

class Eqeq {
    void main() {
        boolean myBoolean = false;

        //myBoolean == myBoolean;

        // ruleid:eqeq
        if (myBoolean == myBoolean) {
            return;
        }

        // ruleid:eqeq
        if (myBoolean != myBoolean) {
            return;
        }

        float someFloat = 0.0f;
        // ruleid:eqeq
        if (someFloat != someFloat) {
            return;
        }
    }
}
