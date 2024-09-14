package uno.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class InputSource {
    public final boolean isInteractive;
    private BufferedReader br;
    private int inputIdx;
    private int[] inputs;
    public static final int DONE = -1;

    public InputSource(boolean isInteractive, int... inputs) {
        this.isInteractive = isInteractive;
        if (isInteractive) {
            br = new BufferedReader(new InputStreamReader(System.in));
        } else {
            this.inputs = new int[inputs.length];
            for (int i=0; i<inputs.length; i++) {
                this.inputs[i] = inputs[i];
            }
        }
    }

    public int getNextInput() {
        if (isInteractive) {
            String s;
            try {
                s = br.readLine();
            } catch (IOException e) { s = "done"; }

            if (s == "done") {
                return DONE;
            } else {
                int n = Integer.parseInt(s);
                return n;
            }
        }

        if (inputIdx == inputs.length) return DONE;
        return inputs[inputIdx++];
    }
}