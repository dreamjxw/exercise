package opengrep;

class AssignmentComparison {
    void main() {
        boolean myBoolean;

        //myBoolean == myBoolean;

        // ruleid:assignment-comparison
        if (myBoolean = true) {
            return;
        }

        // ok:assignment-comparison
        if (myBoolean) {

        }
    }
}
